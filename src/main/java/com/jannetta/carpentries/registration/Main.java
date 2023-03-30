package com.jannetta.carpentries.registration;// https://www.youtube.com/watch?v=OrCs36S3w3w

import com.jannetta.carpentries.registration.controller.RegistrationController;
import com.jannetta.carpentries.registration.util.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.template.velocity.VelocityTemplateEngine;

import static spark.Spark.*;

public class Main {
    private static Logger logger = LoggerFactory.getLogger(Main.class);

    private static String stopServer() {
        stop();
        return "Server stopped";
    }

    private static String startServer() {
        init();
        return "Server started";
    }

    public static void main(String[] args) {
        Globals globals = Globals.getInstance();
        port(Integer.parseInt(System.getenv("PORT")));
        staticFiles.location("/public");

        logger.debug(Globals.getProperties().getProperty("data_file"));
        get("/", RegistrationController::serveRegistrationPage, new VelocityTemplateEngine());
        post("/submitForm", RegistrationController::submitForm, new VelocityTemplateEngine());
    }
}
