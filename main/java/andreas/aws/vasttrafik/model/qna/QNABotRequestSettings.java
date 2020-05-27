package andreas.aws.vasttrafik.model.qna;

public class QNABotRequestSettings
{
    /*
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
            "            \"DEFAULT_USER_POOL_JWKS_URL\": \"https://cognito-idp.eu-west-1.amazonaws.com/eu-west-1_dXtQcUcXb/.well-known/jwks.json\""
     */

    String      ES_USE_KEYWORD_FILTERS;
    String      ES_NO_HITS_QUESTION;
    String      ES_KEYWORD_SYNTAX_TYPES;
    String      ES_SYNTAX_CONFIDENCE_LIMIT;
    String      ES_MINIMUM_SHOULD_MATCH;
    String      ES_SCORE_ANSWER_FIELD;
    String      ERRORMESSAGE;
    String      EMPTYMESSAGE;
    String      DEFAULT_ALEXA_LAUNCH_MESSAGE;
    String      DEFAULT_ALEXA_STOP_MESSAGE;
    String      SMS_HINT_REMINDER_ENABLE;
    String      SMS_HINT_REMINDER;
    String      SMS_HINT_REMINDER_INTERVAL_HRS;
    String[]    IDENTITY_PROVIDER_JWKS_URLS;
    String      ENABLE_MULTI_LANGUAGE_SUPPORT;
    double      MINIMUM_CONFIDENCE_SCORE;
    String[]    ALT_SEARCH_KENDRA_INDEXES;
    int         ELICIT_RESPONSE_MAX_RETRIES;
    String      ELICIT_RESPONSE_RETRY_MESSAGE;
    String      ELICIT_RESPONSE_BOT_FAILURE_MESSAGE;
    String      ELICIT_RESPONSE_DEFAULT_MSG;
    String      ENABLE_REDACTING;
    String      REDACTING_REGEX;
    String      DEFAULT_USER_POOL_JWKS_URL;
}
