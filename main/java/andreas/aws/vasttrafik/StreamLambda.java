package andreas.aws.vasttrafik;

import andreas.aws.vasttrafik.model.TripResponse;
import andreas.aws.vasttrafik.model.VasttrafikDeparture;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import se.chalmers.qna.model.QNABotFullfillmentRequest;

import java.io.*;
import java.nio.charset.Charset;
import java.util.LinkedList;


public class StreamLambda implements RequestStreamHandler
{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
    {
        LambdaLogger logger = context.getLogger();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8"))));
        try
        {
            String result = "";
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            logger.log("Message received:\n");
            logger.log(result);

            result = createRequest(result, logger);

            writer.write(result);
            if (writer.checkError())
            {
                logger.log("WARNING: Writer encountered an error.");
            }
        }
        catch (IllegalStateException | JsonSyntaxException exception)
        {
            logger.log(exception.toString());
        }
        finally
        {
            reader.close();
            writer.close();
        }
    }

    private String createRequest(String jsonText, LambdaLogger logger)
    {
        QNABotFullfillmentRequest event = gson.fromJson(jsonText, QNABotFullfillmentRequest.class);
        String oauthKey = System.getenv("OAUTH_KEY");
        String oauthSecret = System.getenv("OAUTH_SECRET");

        // process event
        Vasttrafik vasttrafik = new Vasttrafik(logger, oauthKey, oauthSecret);

        try
        {
            vasttrafik.authenticate();
        }
        catch (IOException e)
        {
            logger.log("Authentication towards Västtrafik failed: " + e.getMessage());
        }

        if (event.res.session.stops != null)
        {
            long origin = 0;
            long destination = 0;

            try
            {
                if (event.res.session.stops.START_STOP != null && event.res.session.stops.START_STOP.length() > 2)
                    origin = vasttrafik.getBestLocationMatch(event.res.session.stops.START_STOP);
                if (event.res.session.stops.END_STOP != null && event.res.session.stops.END_STOP.length() > 2)
                    destination = vasttrafik.getBestLocationMatch(event.res.session.stops.END_STOP);
            }
            catch (IOException e)
            {
                logger.log("Failed to look up stop locations: " + e);
            }

            if (origin != 0 && destination != 0)
            {
                logger.log("Finding fares between " + event.res.session.stops.START_STOP + " (" + origin + ") and " +
                        event.res.session.stops.END_STOP + " (" + destination + ")");

                try
                {
                    TripResponse tripResponse = vasttrafik.getTrips(origin, destination, DateTime.now(DateTimeZone.forID("Europe/Stockholm")));
                    event.setMarkupMessage(tripResponse.TripList.getMarkdownTrips());
                }
                catch (IOException e)
                {
                    logger.log("Failed to find a trip: " + e.getMessage());
                    event.setMarkupMessage("Trouble finding a trip. :(");
                }

                event.res.session.stops.START_STOP = ""; // Removing so user can get a location
                event.res.session.stops.END_STOP = "";
            }
            else if (origin != 0)
            {
                logger.log("Finding departures from: " + event.res.session.stops.START_STOP + "(" + origin + ")");

                try
                {
                    event.setMarkupMessage(vasttrafik.getDepartureMessage(5, origin, DateTime.now(DateTimeZone.forID("Europe/Stockholm"))));
                }
                catch (IOException e)
                {
                    logger.log("Failed to find departures: " + e.getMessage());
                    event.setMarkupMessage("Trouble finding a trip. :(");
                }
                event.res.session.stops.START_STOP = "";
            }
        }

        logger.log("PROCESSED EVENT:\n" + gson.toJson(event) + "\n\n");
        logger.log("EVENT TYPE: " + event.getClass().toString() + "\n");

        return gson.toJson(event);
    }
}