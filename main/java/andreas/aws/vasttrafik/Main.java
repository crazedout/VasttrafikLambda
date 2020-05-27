package andreas.aws.vasttrafik;

import andreas.aws.vasttrafik.test.TestQNABotFullfillmentRequest;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

import java.io.IOException;

public class Main {

    private static final LambdaLogger logger = new LambdaLogger() {
        @Override
        public void log(String s) {
            System.out.println(s);
        }

        @Override
        public void log(byte[] bytes) {
            System.out.println(new String(bytes));
        }
    };

    public static void main(String[] args)
    {
        try {
            Vasttrafik vasttrafik = new Vasttrafik(logger, "WgQcqxz_mmS50T78kws3nyXih1Aa", "z1AFCo1n612AkFZovJd6FPCpUDoa");
            vasttrafik.authenticate();
            //vasttrafik.getArrivals(9021014001960000l, 9021014007340000l, DateTime.now(DateTimeZone.forID("Europe/Stockholm"));
            System.out.println(vasttrafik.getDepartureMessage(5,9021014001960000L, DateTime.now(DateTimeZone.forID("Europe/Stockholm"))));
        } catch (IOException e)
        {
            logger.log("IOException when communicating with västtrafik: " + e);
        }

        TestQNABotFullfillmentRequest.test();
    }
}
