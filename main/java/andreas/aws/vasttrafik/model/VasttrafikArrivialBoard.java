package andreas.aws.vasttrafik.model;

import java.util.LinkedList;

/*
{
  "ArrivalBoard": {
    "noNamespaceSchemaLocation": "http://api.vasttrafik.se/v1/hafasRestArrivalBoard.xsd",
    "servertime": "22:26",
    "serverdate": "2020-05-13",
    "Arrival": [
      {
        "name": "Spårvagn 6",
        "sname": "6",
        "journeyNumber": "4242",
        "type": "TRAM",
        "stopid": "9022014007340004",
        "stop": "Wavrinskys Plats, Göteborg",
        "time": "22:24",
        "date": "2020-05-13",
        "journeyid": "9015014500604242",
        "origin": "Nymånegatan, Göteborg",
        "track": "D",
        "rtTime": "22:25",
        "rtDate": "2020-05-13",
        "fgColor": "#F89828",
        "bgColor": "#00435C",
        "stroke": "Solid",
        "accessibility": "wheelChair",
        "JourneyDetailRef": {
          "ref": "https://api.vasttrafik.se/bin/rest.exe/v2/journeyDetail?ref=552861%2F224055%2F810834%2F221130%2F80%3Fdate%3D2020-05-13%26station_evaId%3D7340004%26station_type%3Darr%26format%3Djson%26"
        }
      }
    ]
  }
}
 */

public class VasttrafikArrivialBoard
{
    private LinkedList<VasttrafikArrival> Arrival = new LinkedList<>();
    private String noNamespaceSchemaLocation;
    private String servertime;
    private String serverdate;

    @Override
    public String toString()
    {
        String result = "servertime: " + servertime + "\nserverdate: " + serverdate + "\n";

        for (VasttrafikArrival a : Arrival)
        {
            result = result.concat(a.toString());
        }

        return result;
    }

    public LinkedList<VasttrafikArrival> getArrival()
    {
        return Arrival;
    }
}
