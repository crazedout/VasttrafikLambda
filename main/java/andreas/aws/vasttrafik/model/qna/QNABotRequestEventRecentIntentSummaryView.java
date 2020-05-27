package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestEventRecentIntentSummaryView
{
    /*
    "recentIntentSummaryView":
    [
      {
        "intentName": "fulfilment_IntentSEdMAytAjY",
        "checkpointLabel": null,
        "slots":
         {
           "slot": "when do the buss leave"
         },
        "confirmationStatus": "None",
        "dialogActionType": "Close",
        "fulfillmentState": "Fulfilled",
        "slotToElicit": null
      }
    ]
     */

    String intentName;
    String checkpointLabel;
    QNABotRequestEventRecentIntentSummaryViewSlots slots;
    String confirmationStatus;
    String dialogActionType;
    String fulfillmentState;
    String slotToElicit;
}
