package andreas.aws.vasttrafik.model;

import andreas.aws.vasttrafik.Vasttrafik;

public class VasttrafikOrigin
{
    /*
    Origin
    {
        routeIdx (string, optional): Route index of a stop/station. Can be used as a reference of the stop/station in a journeyDetail response,
        $ (string),
        cancelled (boolean, optional): Will be set to true if departure/arrival at this stop is cancelled,
        track (string, optional): Track information, if available,
        rtTrack (string, optional): Realtime track information, if available,
        type (string): The attribute type specifies the type of location. Valid values are ST (stop/station), ADR (address) or POI (point of interest),
        date (date): Date in format YYYY-MM-DD,
        Notes (Notes, optional),
        id (string, optional): ID of this stop,
        rtDate (date, optional): Realtime date in format YYYY-MM-DD, if available,
        time (string): Time in format HH:MM,
        directdate (date, optional): Date in format YYYY-MM-DD. Based on the direct travel time,
        name (string): Contains the name of the location,
        rtTime (string, optional): Realtime time in format HH:MM if available,
        directtime (string, optional): Direct Time format HH:MM. Based on the direct travel time
    }
    */

    public String routeIdx;
    public String $;
    public boolean cancelled;
    public String  track;
    public String  rtTrack;
    public String  type;
    public String  date;
    public VasttrafikNotes Notes;
    public String  id;
    public String  rtDate;
    public String  time;
    public String  directdate;
    public String  name;
    public String  rtTime;
    public String  directtime;
}
