package andreas.aws.vasttrafik;

import se.chalmers.qna.model.QNABotFullfillmentRequest;
import se.chalmers.qna.model.QNABotResponse;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.services.lambda.model.GetAccountSettingsRequest;
import software.amazon.awssdk.services.lambda.model.GetAccountSettingsResponse;
import software.amazon.awssdk.services.lambda.LambdaAsyncClient;

import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.CompletableFuture;

public class DeparturesLambda implements RequestHandler<QNABotFullfillmentRequest, String>
{
    private static LambdaLogger logger;
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    private static final LambdaAsyncClient lambdaClient = LambdaAsyncClient.create();

    public DeparturesLambda()
    {
        CompletableFuture<GetAccountSettingsResponse> accountSettings = lambdaClient.getAccountSettings(GetAccountSettingsRequest.builder().build());
        try {
            GetAccountSettingsResponse settings = accountSettings.get();
        } catch(Exception e) {
            e.getStackTrace();
        }
    }

    @Override
    public String handleRequest(QNABotFullfillmentRequest event, Context context)
    {
        QNABotResponse response = null;
        String oauthKey = System.getenv("OAUTH_KEY");
        String oauthSecret = System.getenv("OAUTH_SECRET");

        logger = context.getLogger();
        //logger.log("Incoming request:\n" + event + "\n"); // Impement toString...

        // call Lambda API
        logger.log("Getting account settings\n");
        CompletableFuture<GetAccountSettingsResponse> accountSettings =
                lambdaClient.getAccountSettings(GetAccountSettingsRequest.builder().build());

        //logger.log("OAUTH_KEY = " + oauthKey + "\n");
        //logger.log("OATH_SECRET = " + oauthSecret + "\n");

        // log execution details
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()) + "\n");
        logger.log("CONTEXT: " + gson.toJson(context) + "\n");
        logger.log("EVENT:\n" + gson.toJson(event) + "\n\n");

        // process event
        Vasttrafik vasttrafik = new Vasttrafik(logger, oauthKey, oauthSecret);

        try
        {
            vasttrafik.authenticate();
            // process Lambda API response
            String departures = vasttrafik.getDepartureMessage(5,9021014001960000L, DateTime.now(DateTimeZone.forID("Europe/Stockholm")));
            event.setMarkupMessage(departures);
            logger.log(departures);
        }
        catch (IOException e)
        {
            logger.log(e.getMessage());
        }

        logger.log("PROCESSED EVENT:\n" + gson.toJson(event) + "\n\n");
        logger.log("EVENT TYPE: " + event.getClass().toString() + "\n");

        return gson.toJson(event);
    }
}
