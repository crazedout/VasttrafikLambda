package andreas.aws.vasttrafik.model;

import com.google.gson.*;
import com.google.gson.JsonElement;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class VasttrafikTripListLegTypeAdapter implements JsonDeserializer<List<VasttrafikTripListTripLeg>>
{
    public List<VasttrafikTripListTripLeg> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext ctx)
    {
        List<VasttrafikTripListTripLeg> vals = new ArrayList<VasttrafikTripListTripLeg>();
        if (json.isJsonArray())
        {
            for (JsonElement e : json.getAsJsonArray())
            {
                vals.add((VasttrafikTripListTripLeg) ctx.deserialize(e, VasttrafikTripListTripLeg.class));
            }
        }
        else if (json.isJsonObject())
        {
            vals.add((VasttrafikTripListTripLeg) ctx.deserialize(json, VasttrafikTripListTripLeg.class));
        }
        else
        {
            throw new RuntimeException("Unexpected JSON type: " + json.getClass());
        }
        return vals;
    }
}