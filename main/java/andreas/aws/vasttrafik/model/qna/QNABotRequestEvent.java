package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestEvent
{
    /*
    "_event":
    {
        "messageVersion": "1.0",
        "invocationSource": "FulfillmentCodeHook",
        "userId": "eu-west-1:c245d029-49ce-42ad-9566-7e52400899e3",
        "sessionAttributes": {},
        "requestAttributes": null,
        "bot":
        {
            "name": "QnABot_BotFJDPq",
                "alias": "live",
                "version": "1"
        },
        "outputDialogMode": "Text",
        "currentIntent":
        {
            "name": "fulfilment_IntentSEdMAytAjY",
            "slots":
            {
                "slot": "what do the buss leave"
            },
            "slotDetails":
            {
                "slot":
                {
                    "resolutions": [],
                    "originalValue": "what do the buss leave"
                }
            },
            "confirmationStatus": "None"
        },
        "inputTranscript": "what do the buss leave?",
        "recentIntentSummaryView": null,
        "sentimentResponse": null,
        "kendraResponse": null,
        "errorFound": false
    }

     */

    String messageVersion;
    String invocationSource;
    String userId;
    QNABotRequestEventSessionAttribute sessionAttributes;
    QNABotRequestEventRequestAttributes requestAttributes = null;
    QNABotRequestEventBot bot;
    String outputDialogMode;
    QNABotRequestEventCurrentIntent currentIntent;
    String inputTranscript;
    QNABotRequestEventRecentIntentSummaryView[] recentIntentSummaryView = null;
    QNABotRequestEventSentimentResponse sentimentResponse = null;
    QNABotRequestEventKendraResponse kendraResponse = null;
    boolean errorFound;
}
