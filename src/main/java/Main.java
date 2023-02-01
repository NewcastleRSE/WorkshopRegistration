// https://www.youtube.com/watch?v=OrCs36S3w3w
import controller.JsonTransformer;
import controller.RegistrationTransformer;

import static spark.Spark.*;
public class Main {
    private static String stopServer() {
        stop();
        return "Server stopped";
    }

    private static String startServer() {
        init();
        return "Server started";
    }
    public static void main(String[] args) {
        post("/submitForm", (req, res) -> RegistrationTransformer.submitForm(req, res), new JsonTransformer());
        post("/hello", (req, res) -> "Hello World");
        get("/stop", (req, res) -> stopServer());
        get("/start", (req, res) -> startServer());
    }
}
