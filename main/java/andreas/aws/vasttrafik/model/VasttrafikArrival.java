package andreas.aws.vasttrafik.model;

public class VasttrafikArrival
{
    /*
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
            "JourneyDetailRef":
             {
                "ref": "https://api.vasttrafik.se/bin/rest.exe/v2/journeyDetail?ref=552861%2F224055%2F810834%2F221130%2F80%3Fdate%3D2020-05-13%26station_evaId%3D7340004%26station_type%3Darr%26format%3Djson%26"
             }
    */

    private String name;
    private String sname;
    private long journeyNumber;
    private String type;
    private long stopid;
    private String stop;
    private String time;
    private String date;
    private long journeyid;
    private String origin;
    private String track;
    private String rtTime;
    private String rtDate;
    private String fgColor;
    private String bgColor;
    private String stroke;
    private String accessibility;
    private VasttrafikJourneyDetailRef JourneyDetailRef;

    public String toString()
    {
        return name + "\t\t" + time + "\n";
    }

}
