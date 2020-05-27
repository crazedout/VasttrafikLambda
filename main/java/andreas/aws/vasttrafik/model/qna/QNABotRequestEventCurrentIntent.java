package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestEventCurrentIntent
{
    /*
        "currentIntent":
         {
            "name": "fulfilment_IntentSEdMAytAjY",
            "slots":
             {
                "slot": "when do the buss leave"
             },
            "slotDetails":
             {
                "slot":
                 {
                    "resolutions: [],
                    "originalValue: "when do the buss leave" +
                 }
             },
            "confirmationStatus: "None"
         },
    */

    String name;
    QNABotRequestEventCurrentIntentSlots slots;
    QNABotRequestEventCurrentIntentSlotDetails slotDetails;
    String confirmationStatus;

}
