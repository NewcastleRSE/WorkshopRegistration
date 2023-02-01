package controller;

import model.RegistrationForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Request;
import spark.Response;

import static controller.SendMail.send;

public class RegistrationTransformer {
    private static Logger logger = LoggerFactory.getLogger(RegistrationTransformer.class);
    public static RegistrationForm submitForm(Request request, Response response) {
        RegistrationForm registrationForm = new RegistrationForm(
                request.queryParams("firstName"),
                request.queryParams("middleNames"),
                request.queryParams("lastName"),
                request.queryParams("dietaryPreference"),
                request.queryParams("howHeard"),
                request.queryParams("loginID"),
                request.queryParams("contactNumber"),
                request.queryParams("degree"),
                request.queryParams("studyProgramme"),
                request.queryParams("stage"),
                request.queryParams("school"),
                request.queryParams("universityEmail"),
                request.queryParams("preferredEmail"));
        JsonTransformer jsonTransformer = new JsonTransformer();
        send("Workshop Registration from Website", jsonTransformer.render(registrationForm));
        return registrationForm;
    };

}
