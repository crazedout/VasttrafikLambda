package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestInfoES
{
        /*
         "es":
          {
             "address": "search-qnabot-elastic-6wgov9oh92rb-o63t5g7hqjgg76lkdypvxlqguq.eu-west-1.es.amazonaws.com",
             "index": "qnabot",
             "type": "qna",
             "service":
              {
                "qid": "QnABot-ESQidLambda-DSUA9Y63QHS",
                "proxy": "QnABot-ESProxyLambda-10W9L2GGUPZAI"
              }
           }
     */

    String address;
    String index;
    String type;
    QNABotRequestInfoESService service;
}
