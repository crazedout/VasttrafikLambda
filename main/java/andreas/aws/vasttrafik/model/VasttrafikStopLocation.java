package andreas.aws.vasttrafik.model;

public class VasttrafikStopLocation implements Comparable<VasttrafikStopLocation>
{
    /*
         "name": "Chalmers, Göteborg",
         "lon": "11.972957",
         "lat": "57.690000",
         "id": "9021014001960000",
         "idx": "1"
     */

    String name;
    double lon;
    double lat;
    long id;
    int idx;

    public String toString()
    {
        return "(" + idx + ")\t" + name + ": " + id + "\t(" + lon + ", " + lat + ")\n";
    }

    @Override
    public int compareTo(VasttrafikStopLocation o)
    {
        if (idx > o.idx)
            return 1;
        else if (idx < o.idx)
            return -1;
        else
            return 0;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public int getIdx() {
        return idx;
    }
}
