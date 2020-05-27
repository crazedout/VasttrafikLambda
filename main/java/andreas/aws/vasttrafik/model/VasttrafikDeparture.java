package andreas.aws.vasttrafik.model;

public class VasttrafikDeparture
{
    /*
    {
            "name":"Spårvagn 8",
            "sname":"8",
            "journeyNumber":"107",
            "type":"TRAM",
            "stopid":"9022014001960001",
            "stop":"Chalmers, Göteborg",
            "time":"13:11",
            "date":"2020-05-15",
            "journeyid":"9015014500800107",
            "direction":"Angered",
            "track":"A",
            "rtTime":"13:12",
            "rtDate":"2020-05-15",
            "fgColor":"#A5449A",
            "bgColor":"#FFFFFF",
            "stroke":"Solid",
            "accessibility":"wheelChair",
            "JourneyDetailRef":{      "ref":"https://api.vasttrafik.se/bin/rest.exe/v2/journeyDetail?ref=982248%2F341039%2F178816%2F238014%2F80%3Fdate%3D2020-05-15%26station_evaId%3D1960001%26station_type%3Ddep%26format%3Djson%26"
        }
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
        private String direction;
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
            return String.format("%s   %-15s%-30s\n", time, name.trim(), direction.trim() + "  ");
        }
}