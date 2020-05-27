package andreas.aws.vasttrafik.test;

import andreas.aws.vasttrafik.model.qna.QNABotFullfillmentRequest;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestQNABotFullfillmentRequest
{
    private static final String TEST_STRING = "{" +
            "    \"req\": {" +
            "        \"_event\": {" +
            "            \"messageVersion\": \"1.0\"," +
            "            \"invocationSource\": \"FulfillmentCodeHook\"," +
            "            \"userId\": \"eu-west-1:ec44b893-e0b7-40da-a7c1-60431db3c696\"," +
            "            \"sessionAttributes\": {" +
            "                \"navigation\": \"{\\\"next\\\":\\\"\\\",\\\"previous\\\":[],\\\"hasParent\\\":false}\"," +
            "                \"previous\": \"{\\\"qid\\\":\\\"General_question_get_stop_1_en\\\",\\\"a\\\":\\\"Sorry can't find any information about busses or trams.\\\",\\\"alt\\\":{\\\"markdown\\\":\\\"\\\",\\\"ssml\\\":\\\"\\\"},\\\"q\\\":\\\"when do the buss leave?\\\"}\"," +
            "                \"topic\": \"\"" +
            "            }," +
            "            \"requestAttributes\": null," +
            "            \"bot\": {" +
            "                \"name\": \"QnABot_BotFJDPq\"," +
            "                \"alias\": \"live\"," +
            "                \"version\": \"1\"" +
            "            }," +
            "            \"outputDialogMode\": \"Text\"," +
            "            \"currentIntent\": {" +
            "                \"name\": \"fulfilment_IntentSEdMAytAjY\"," +
            "                \"slots\": {" +
            "                    \"slot\": \"when do the buss leave\"" +
            "                }," +
            "                \"slotDetails\": {" +
            "                    \"slot\": {" +
            "                        \"resolutions\": []," +
            "                        \"originalValue\": \"when do the buss leave\"" +
            "                    }" +
            "                }," +
            "                \"confirmationStatus\": \"None\"" +
            "            }," +
            "            \"inputTranscript\": \"when do the buss leave?\"," +
            "            \"recentIntentSummaryView\": null," +
            "            \"sentimentResponse\": null," +
            "            \"kendraResponse\": null," +
            "            \"errorFound\": false" +
            "        }," +
            "        \"_settings\": {" +
            "            \"ES_USE_KEYWORD_FILTERS\": \"true\"," +
            "            \"ES_NO_HITS_QUESTION\": \"no_hits\"," +
            "            \"ES_KEYWORD_SYNTAX_TYPES\": \"NOUN,PROPN,VERB,INTJ\"," +
            "            \"ES_SYNTAX_CONFIDENCE_LIMIT\": \".20\"," +
            "            \"ES_MINIMUM_SHOULD_MATCH\": \"2<75%\"," +
            "            \"ES_SCORE_ANSWER_FIELD\": \"true\"," +
            "            \"ERRORMESSAGE\": \"Unfortunately I encountered an error when searching for your answer. Please ask me again later.\"," +
            "            \"EMPTYMESSAGE\": \"You stumped me! Sadly I don't know how to answer your question.\"," +
            "            \"DEFAULT_ALEXA_LAUNCH_MESSAGE\": \"Hello, Please ask a question\"," +
            "            \"DEFAULT_ALEXA_STOP_MESSAGE\": \"Goodbye\"," +
            "            \"SMS_HINT_REMINDER_ENABLE\": \"true\"," +
            "            \"SMS_HINT_REMINDER\": \" (Feedback? Reply THUMBS UP or THUMBS DOWN. Ask HELP ME at any time)\"," +
            "            \"SMS_HINT_REMINDER_INTERVAL_HRS\": \"24\"," +
            "            \"IDENTITY_PROVIDER_JWKS_URLS\": []," +
            "            \"ENABLE_MULTI_LANGUAGE_SUPPORT\": \"false\"," +
            "            \"MINIMUM_CONFIDENCE_SCORE\": 0.6," +
            "            \"ALT_SEARCH_KENDRA_INDEXES\": []," +
            "            \"ELICIT_RESPONSE_MAX_RETRIES\": 3," +
            "            \"ELICIT_RESPONSE_RETRY_MESSAGE\": \"Please try again?\"," +
            "            \"ELICIT_RESPONSE_BOT_FAILURE_MESSAGE\": \"Your response was not understood. Please start again.\"," +
            "            \"ELICIT_RESPONSE_DEFAULT_MSG\": \"Ok. \"," +
            "            \"ENABLE_REDACTING\": \"false\"," +
            "            \"REDACTING_REGEX\": \"\\\\b\\\\d{4}\\\\b(?![-])|\\\\b\\\\d{9}\\\\b|\\\\b\\\\d{3}-\\\\d{2}-\\\\d{4}\\\\b\"," +
            "            \"DEFAULT_USER_POOL_JWKS_URL\": \"https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_dXtQcUcXb/.well-known/jwks.json\"" +
            "        }," +
            "        \"_type\": \"LEX\"," +
            "        \"_userId\": \"eu-west-1:ec44b893-e0b7-40da-a7c1-60431db3c696\"," +
            "        \"question\": \"when do the buss leave?\"," +
            "        \"session\": {}," +
            "        \"_userInfo\": {" +
            "            \"UserId\": \"eu-west-1:ec44b893-e0b7-40da-a7c1-60431db3c696\"," +
            "            \"InteractionCount\": 0," +
            "            \"TimeSinceLastInteraction\": 1590394279.516" +
            "        }," +
            "        \"_info\": {" +
            "            \"es\": {" +
            "                \"address\": \"search-qnabot-elastic-6wgov9oh92rb-o63t5g7hqjgg76lkdypvxlqguq.eu-west-1.es.amazonaws.com\"," +
            "                \"index\": \"qnabot\"," +
            "                \"type\": \"qna\"," +
            "                \"service\": {" +
            "                    \"qid\": \"QnABot-ESQidLambda-DSUA9Y63QHS\"," +
            "                    \"proxy\": \"QnABot-ESProxyLambda-10W9L2GGUPZAI\"" +
            "                }" +
            "            }" +
            "        }" +
            "    }," +
            "    \"res\": {" +
            "        \"type\": \"PlainText\"," +
            "        \"message\": \"Sorry can't find any information about busses or trams.\"," +
            "        \"session\": {" +
            "            \"topic\": \"\"," +
            "            \"appContext\": {" +
            "                \"altMessages\": {" +
            "                    \"markdown\": \"\"," +
            "                    \"ssml\": \"\"" +
            "                }" +
            "            }," +
            "            \"previous\": {" +
            "                \"qid\": \"General_question_get_stop_1_en\"," +
            "                \"a\": \"Sorry can't find any information about busses or trams.\"," +
            "                \"alt\": {" +
            "                    \"markdown\": \"\"," +
            "                    \"ssml\": \"\"" +
            "                }," +
            "                \"q\": \"when do the buss leave?\"" +
            "            }," +
            "            \"navigation\": {" +
            "                \"next\": \"\"," +
            "                \"previous\": []," +
            "                \"hasParent\": false" +
            "            }" +
            "        }," +
            "        \"card\": {" +
            "            \"send\": false," +
            "            \"title\": \"\"," +
            "            \"text\": \"\"," +
            "            \"url\": \"\"" +
            "        }," +
            "        \"_userInfo\": {" +
            "            \"UserId\": \"eu-west-1:ec44b893-e0b7-40da-a7c1-60431db3c696\"," +
            "            \"InteractionCount\": 1," +
            "            \"TimeSinceLastInteraction\": 1590394279.516," +
            "            \"FirstSeen\": \"Mon May 25 2020 20:11:19 GMT+0000 (Coordinated Universal Time)\"," +
            "            \"LastSeen\": \"Mon May 25 2020 20:11:19 GMT+0000 (Coordinated Universal Time)\"" +
            "        }," +
            "        \"got_hits\": 1," +
            "        \"result\": {" +
            "            \"args\": [" +
            "                \"Chalmers\"" +
            "            ]," +
            "            \"next\": \"\"," +
            "            \"questions\": [" +
            "                {" +
            "                    \"q\": \"When do the buss leave?\"" +
            "                }," +
            "                {" +
            "                    \"q\": \"When do the tram leave?\"" +
            "                }" +
            "            ]," +
            "            \"a\": \"Sorry can't find any information about busses or trams.\"," +
            "            \"r\": {" +
            "                \"buttons\": [" +
            "                    {" +
            "                        \"text\": \"\"," +
            "                        \"value\": \"\"" +
            "                    }" +
            "                ]," +
            "                \"subTitle\": \"\"," +
            "                \"imageUrl\": \"\"," +
            "                \"title\": \"\"," +
            "                \"text\": \"\"," +
            "                \"url\": \"\"" +
            "            }," +
            "            \"t\": \"\"," +
            "            \"elicitResponse\": {" +
            "                \"response_sessionattr_namespace\": \"\"," +
            "                \"responsebot_hook\": \"\"" +
            "            }," +
            "            \"alt\": {" +
            "                \"markdown\": \"\"," +
            "                \"ssml\": \"\"" +
            "            }," +
            "            \"conditionalChaining\": \"\"," +
            "            \"l\": \"arn:aws:lambda:eu-west-1:923235743949:function:HelloLambda\"," +
            "            \"qid\": \"General_question_get_stop_1_en\"," +
            "            \"type\": \"qna\"," +
            "            \"autotranslate\": {" +
            "                \"a\": true" +
            "            }" +
            "        }," +
            "        \"plainMessage\": \"Sorry can't find any information about busses or trams.\"" +
            "    }" +
            "}";

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void test()
    {
        QNABotFullfillmentRequest request = gson.fromJson(TEST_STRING, QNABotFullfillmentRequest.class);
        System.out.println(gson.toJson(request));
    }
}
