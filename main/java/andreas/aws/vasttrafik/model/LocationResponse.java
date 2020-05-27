package andreas.aws.vasttrafik.model;

public class LocationResponse
{
    VasttrafikLocationList LocationList;

    public String toString()
    {
        return LocationList.toString();
    }

    public VasttrafikLocationList getLocationList() {
        return LocationList;
    }
}
