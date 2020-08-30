package andreas.aws.vasttrafik;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestStreamHandler;

import com.google.gson.JsonSyntaxException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import se.chalmers.qna.model.QNABotFullfillmentRequest;

import java.io.*;
import java.nio.charset.Charset;

public class ElicitStop implements RequestStreamHandler
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
            logger.log("Incoming event:\n");
            logger.log(result);

            result = createRequest(result, logger);
            logger.log("Processed event:\n" + result + "\n\n");

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

        return gson.toJson(event);
    }
}