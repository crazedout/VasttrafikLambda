package andreas.aws.vasttrafik.model;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class VasttrafikLocationList
{
    /*
{
  "LocationList":
 {
    "noNamespaceSchemaLocation": "http://api.vasttrafik.se/v1/hafasRestLocation.xsd",
    "servertime": "22:31",
    "serverdate": "2020-05-13",
    "StopLocation":
    [
       {
         "name": "Chalmers, Göteborg",
         "lon": "11.972957",
         "lat": "57.690000",
         "id": "9021014001960000",
         "idx": "1"
       }
     ]
  }
}
     */

    String noNamespaceSchemaLocation;
    String servertime;
    String serverdate;
    HashSet<VasttrafikStopLocation> StopLocation;

    public String toString()
    {
        String result = "servertime: " + serverdate + "\nserverdate: " + servertime + "\n";

        for (VasttrafikStopLocation location : StopLocation)
        {
            result = result.concat(location.toString());
        }

        return result;
    }

    public VasttrafikStopLocation getFirstMatch()
    {
        for (VasttrafikStopLocation location : StopLocation)
        {
            if (location.getIdx() == 1)
                return location;
        }
        return null;
    }
}
