package andreas.aws.vasttrafik;

import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


import andreas.aws.vasttrafik.model.*;
import com.google.api.client.http.*;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.appengine.repackaged.com.google.gson.Gson;
import com.google.appengine.repackaged.com.google.gson.GsonBuilder;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.format.DateTimeFormat;


public class Vasttrafik
{
    private final String OAUTH_TOKEN_URL = "https://api.vasttrafik.se:443/token";
    private String OAUTH_KEY = "WgQcqxz_mmS50T78kws3nyXih1Aa";
    private String OAUTH_SECRET = "z1AFCo1n612AkFZovJd6FPCpUDoa";
    private final String ENDPOINT = "https://api.vasttrafik.se/bin/rest.exe/v2";
    private final String ARRIVAL_ENDPOINT = ENDPOINT + "/arrivalBoard";
    private final String DEPARTURE_ENDPOINT = ENDPOINT + "/departureBoard";
    private final String LOCATION_ENDPOINT = ENDPOINT + "/location.name";
    private String ACCESS_TOKEN;
    private String TOKEN_TYPE;
    private LambdaLogger logger;

    public Vasttrafik(LambdaLogger logger, String oauthKey, String oauthSecret)
    {
        if (logger != null)
            this.logger = logger;

        this.OAUTH_KEY = oauthKey;
        this.OAUTH_SECRET = oauthSecret;
    }

    public final void authenticate() throws IOException
    {
        GenericUrl url = new GenericUrl(OAUTH_TOKEN_URL);
        Map<String, String> params = new HashMap<>();
        params.put("grant_type", "client_credentials");
        HttpContent hc = new UrlEncodedContent(params);

        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildPostRequest(url, hc);
        request.getHeaders().setBasicAuthentication(OAUTH_KEY, OAUTH_SECRET);
        HttpResponse response = request.execute();

        try {
            if (response.isSuccessStatusCode()) {

                String json = response.parseAsString();

                Gson gson = new GsonBuilder().create();
                OAUTHresponse oauthResponse = gson.fromJson(json, OAUTHresponse.class);
                logger.log(oauthResponse.toString());
                ACCESS_TOKEN = oauthResponse.access_token;
                TOKEN_TYPE = oauthResponse.token_type;

            }
            else
                logger.log("Request failed with " + response.getStatusCode());
        }
        finally
        {
            response.disconnect();
        }
    }


    public void nextTrips(String from, String to) throws IOException
    {
        long fromID = getBestLocationMatch(from);
        long toID = getBestLocationMatch(to);

        getArrivals(fromID, toID, DateTime.now(DateTimeZone.forID("Europe/Stockholm")));
    }

    public long getBestLocationMatch(String location) throws IOException
    {
        return getMatchingLocations(location).getFirstMatch().getId();
    }

    // https://api.vasttrafik.se/bin/rest.exe/v2/location.name?input=wavrinskys%20plats
    public VasttrafikLocationList getMatchingLocations(String locationName) throws IOException
    {
        // Chalmers: 9021014001960000
        GenericUrl url = new GenericUrl(LOCATION_ENDPOINT);
        url.put("input", locationName);
        url.put("format", "json");

        String json = getRequest(url);

        Gson gson = new GsonBuilder().create();
        LocationResponse response = gson.fromJson(json, LocationResponse.class);

        return response.getLocationList();
    }


    public void getArrivals(long locationID, long directionID, DateTime dateTime) throws IOException
    {
        // https://api.vasttrafik.se/bin/rest.exe/v2/arrivalBoard?id=1&date=2020-05-12&time=07%3A00&direction=2
        // Chalmers: 9021014001960000
        // Wavrinskys plats: 9021014007340000
        // 9022014001960003
        String dateString = dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
        String timeString = dateTime.toString(DateTimeFormat.forPattern("HH:mm"));
        GenericUrl url = new GenericUrl(ARRIVAL_ENDPOINT);
        url.put("id", locationID);
        url.put("date", dateString);
        url.put("time", timeString);
        url.put("direction", directionID);
        url.put("format", "json");

        String json = getRequest(url);
        //logger.info(json);

        Gson gson = new GsonBuilder().create();
        ArrivalResponse ab = gson.fromJson(json, ArrivalResponse.class);
        //logger.info(ab.toString());
    }

    public LinkedList<VasttrafikDeparture> getDepartures(long locationID, DateTime dateTime) throws IOException
    {
        String dateString = dateTime.toString(DateTimeFormat.forPattern("yyyy-MM-dd"));
        String timeString = dateTime.toString(DateTimeFormat.forPattern("HH:mm"));
        GenericUrl url = new GenericUrl(DEPARTURE_ENDPOINT);
        url.put("id", locationID);
        url.put("date", dateString);
        url.put("time", timeString);
        url.put("format", "json");

        String json = getRequest(url);

        Gson gson = new GsonBuilder().create();
        DepatureResponse ab = gson.fromJson(json, DepatureResponse.class);
        //logger.info(ab.toString());

        return ab.getDepartureBoard().getDeparture();
    }

    public String getDepartureMessage(int maxDepartures, long locationID, DateTime dateTime) throws IOException
    {
        String departureString = "Departures:  \n";
        LinkedList<VasttrafikDeparture> departures = getDepartures(locationID, dateTime);

        if (maxDepartures <= 0 || maxDepartures >= departures.size())
            maxDepartures = departures.size() - 1;

        for (int i = 0; i < maxDepartures; i++)
            departureString = departureString.concat(departures.get(i).toString());

        return departureString;
    }

    public String getRequest(GenericUrl url) throws IOException
    {
        HttpRequestFactory requestFactory
                = new NetHttpTransport().createRequestFactory();
        HttpRequest request = requestFactory.buildGetRequest(url);
        request.getHeaders().setAuthorization("Bearer " + ACCESS_TOKEN);
        request.getHeaders().setAccept("application/json");

        HttpResponse response = request.execute();

        try
        {
            if (response.isSuccessStatusCode())
            {
                return response.parseAsString();
            }
            else
                logger.log("Request failed with " + response.getStatusCode());
        }
        finally
        {
            response.disconnect();
        }
        return null;
    }

}
