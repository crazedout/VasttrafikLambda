package andreas.aws.vasttrafik.model;

public class DepatureResponse
{
    VasttrafikDepartureBoard DepartureBoard;

    public String toString()
    {
        if (DepartureBoard != null)
            return DepartureBoard.toString();
        else
            return "null";
    }

    public VasttrafikDepartureBoard getDepartureBoard() {
        return DepartureBoard;
    }
}
