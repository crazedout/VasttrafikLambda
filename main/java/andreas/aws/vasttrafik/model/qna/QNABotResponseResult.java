package andreas.aws.vasttrafik.model.qna;

public class QNABotResponseResult
{
    /*
    "result":
    {
        "qid": "GreetingHookExample",
        "a": "Lambda Hooks allow you to extend QnABot by returning dynamic answers.",
        "l": "QNA:ExampleJSLambdahook",
        "type": "qna",
        "questions":
        [
            {
                "q": "What are lambda hooks"
            },
            {
                "q": "What is a lambda hook"
            }
        ],
        "autotranslate":
        {
            "a": true
        }
    },
    */

    String qid;
    String a;
    String l;
    String type;
    QNABotResponseResultQuestions[] questions;
    QNABotResponseResultAutotranslate autotranslate;
}
