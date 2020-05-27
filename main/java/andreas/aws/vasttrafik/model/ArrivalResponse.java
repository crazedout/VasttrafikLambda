package andreas.aws.vasttrafik.model;

public class ArrivalResponse
{
    VasttrafikArrivialBoard ArrivalBoard;

    public String toString()
    {
        if (ArrivalBoard != null)
            return ArrivalBoard.toString();
        else
            return "null";
    }

    public VasttrafikArrivialBoard getArrivalBoard() {
        return ArrivalBoard;
    }
}
