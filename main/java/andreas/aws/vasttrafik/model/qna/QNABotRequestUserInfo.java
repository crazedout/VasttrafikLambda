package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestUserInfo
{
    /*
        "_userInfo":
         {
            "UserId": "eu-west-1:ec44b893-e0b7-40da-a7c1-60431db3c696",
            "InteractionCount": 0,
            "TimeSinceLastInteraction": 1590394279.516 //Float represented in different format... 1.590394279516E9
         },
     */

    String UserId;
    int InteractionCount;
    double TimeSinceLastInteraction;
}
