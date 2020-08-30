package andreas.aws.vasttrafik.model;

import java.util.ArrayList;
import java.util.Date;

public class VasttrafikTripList
{
    /*
    TripList
    {
        errorText (string, optional),
        error (string, optional),
        serverdate (date, optional),
        servertime (string, optional): Current server time in format HH:MM,
        Trip (Array[Trip], optional),
        noNamespaceSchemaLocation (string)
    }
    */

    public String errorText;
    public String error;
    public String serverdate;
    public String servertime;
    public ArrayList<VasttrafikTripListTrip> Trip;
    public String noNamespaceSchemaLocation;

    public String getMarkdownTrips()
    {
        String result = "";

        for (VasttrafikTripListTrip trip : Trip)
        {
            int currentPos = 0;

            for (VasttrafikTripListTripLeg leg : trip.Leg)
            {
                currentPos++;

                if (currentPos == trip.Leg.size())
                    result = result.concat(leg.name + "  \n");
                else
                    result = result.concat(leg.name + " -> ");
            }
        }

        return result;
    }
}
