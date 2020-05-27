package andreas.aws.vasttrafik;

import andreas.aws.vasttrafik.model.qna.QNABotFullfillmentRequest;
import andreas.aws.vasttrafik.model.qna.QNABotResponse;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.*;
import java.nio.charset.Charset;
import java.time.LocalDateTime;
import java.util.TimeZone;


public class StreamLambda implements RequestStreamHandler
{
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public void handleRequest(InputStream inputStream, OutputStream outputStream, Context context) throws IOException
    {
        LambdaLogger logger = context.getLogger();
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, Charset.forName("UTF-8")));
        PrintWriter writer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(outputStream, Charset.forName("UTF-8"))));
        try
        {
            String result = "";
            String line;
            while ((line = reader.readLine()) != null) {
                result += line;
            }
            logger.log("Message received:\n");
            logger.log(result);

            result = createRequest(result, logger);

            writer.write(result);
            if (writer.checkError())
            {
                logger.log("WARNING: Writer encountered an error.");
            }
        }
        catch (IllegalStateException | JsonSyntaxException exception)
        {
            logger.log(exception.toString());
        }
        finally
        {
            reader.close();
            writer.close();
        }
    }

    private String createRequest(String jsonText, LambdaLogger logger)
    {
        QNABotFullfillmentRequest event = gson.fromJson(jsonText, QNABotFullfillmentRequest.class);
        String oauthKey = System.getenv("OAUTH_KEY");
        String oauthSecret = System.getenv("OAUTH_SECRET");

        // process event
        Vasttrafik vasttrafik = new Vasttrafik(logger, oauthKey, oauthSecret);

        try
        {
            vasttrafik.authenticate();
            // process Lambda API response
            String departures = vasttrafik.getDepartureMessage(5,9021014001960000L, DateTime.now(DateTimeZone.forID("Europe/Stockholm")));
            event.setMarkupMessage(departures);
            logger.log(departures + "\n");
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