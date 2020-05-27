package andreas.aws.vasttrafik.model;

import java.util.LinkedList;

public class VasttrafikDepartureBoard
{
    private LinkedList<VasttrafikDeparture> Departure = new LinkedList<>();
    private String noNamespaceSchemaLocation;
    private String servertime;
    private String serverdate;

    @Override
    public String toString()
    {
        String result = "servertime: " + servertime + "\nserverdate: " + serverdate + "\n";

        for (VasttrafikDeparture d : Departure)
        {
            result = result.concat(d.toString());
        }

        return result;
    }

    public LinkedList<VasttrafikDeparture> getDeparture()
    {
        return Departure;
    }
}
