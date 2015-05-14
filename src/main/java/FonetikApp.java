import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URLDecoder;

import static spark.Spark.*;

public class FonetikApp {
    private static final Logger LOG = LoggerFactory.getLogger("spark.Spark");

    public static void main(String[] args) {
        externalStaticFileLocation("asset");

        get("/fonetik/*/*/*", ((request, response) -> {
            final String fromLang = request.splat()[0];
            final String toLang = request.splat()[1];
            final String expr = URLDecoder.decode(request.splat()[2], "UTF-8");

            LOG.info("expr: " + expr);

            return makeJsonArray(HungarianRules.phonetize(expr));
        }));
    }

    public static String makeJsonArray(String input) {
        return "[\"" + input.replace("\"", "\\\"") + "\"]";
    }
}
