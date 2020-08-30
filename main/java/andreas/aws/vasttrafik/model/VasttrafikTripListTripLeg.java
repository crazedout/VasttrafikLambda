package andreas.aws.vasttrafik.model;

import andreas.aws.vasttrafik.Vasttrafik;

public class VasttrafikTripListTripLeg
{
    /*
    Leg
     {
        fgColor (string, optional): Foregroundcolor of this line,
        booking (boolean, optional): Will be true if this journey needs to be booked,
        direction (string, optional): Direction information,
        JourneyDetailRef (JourneyDetailRef, optional),
        cancelled (boolean, optional): Will be true if this journey is cancelled,
        kcal (float, optional): Energy use,
        Origin (Origin, optional),
        sname (string, optional): Short name of the leg,
        type (string): The attribute type specifies the type of the leg. Valid values are VAS, LDT (Long Distance Train), REG (Regional train), BUS , BOAT, TRAM, TAXI (Taxi/Telebus). Furthermore it can be of type WALK, BIKE and CAR if these legs are routes on the street network,
        GeometryRef (GeometryRef, optional),
        bgColor (string, optional): Backgroundcolor of this line,
        Notes (Notes, optional),
        id (string, optional): ID of the journey,
        stroke (string, optional): Stroke style of this line,
        reachable (boolean, optional): Will be true if this journey is not reachable due to delay of the feeder,
        name (string): The attribute name specifies the name of the leg,
        night (boolean, optional): Will be true if this journey is a night journey,
        Destination (Destination, optional),
        percentBikeRoad (float, optional): Percentage of the route that is made up of bike roads,
        accessibility (string, optional): will only be set if the vehicle has wheelchair + ramp/lift or lowfloor according to realtime data
     }
    */

    public String fgColor;
    public boolean booking;
    public String direction;
    public VasttrafikJourneyDetailRef JourneyDetailRef;
    public boolean cancelled;
    public double kcal;
    public VasttrafikOrigin Origin;
    public String sname;
    public String type;
    public VasttrafikGeometryRef VasttrafikGeometryRef;
    public String bgColor;
    public VasttrafikNotes Notes;
    public String id;
    public String stroke;
    public boolean reachable;
    public String name;
    public boolean night;
    public VasttrafikDestination Destination;
    public double percentBikeRoad;
    public String accessibility;
}
