package andreas.aws.vasttrafik.model;

import java.util.ArrayList;

public class VasttrafikTripListTrip
{
    /*
    Trip
     {
        Leg (Array[Leg], optional),
        travelWarranty (boolean, optional): IMPORTANT NOTE: journeys that are presented when the default change margin has been disregarded are not covered by V�sttrafiks travel warranty (Swedish: resegaranti).,
        valid (boolean, optional): The state indicates if the trip is still possible to ride based on the current realtime situation,
        alternative (boolean): The type indicates whether this is an original connection or an realtime alternative,
        type (string, optional): Type of trip = ["WALK" or "BIKE" or "CAR"]
    }
     */

    public ArrayList<VasttrafikTripListTripLeg> Leg;
    public boolean travelWarranty;
    public boolean valid;
    public boolean alternative;
    public String type;
}
