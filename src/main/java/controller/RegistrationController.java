package controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import controller.util.Globals;
import controller.util.Path;
import controller.util.YamlUtil;
import model.RegistrationForm;
import model.Workshop;
import model.Workshops;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.ModelAndView;
import spark.Request;
import spark.Response;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static controller.SendMail.send;

public class RegistrationController {

    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);
    private static Properties properties = Globals.getProperties();
    static Map<String, Object> model = new HashMap<>();

    public static ModelAndView serveRegistrationPage(Request request, Response response) {
        logger.debug(properties.getProperty("data_file"));
        Workshops workshops = YamlUtil.loadWorkshopYaml(properties.getProperty("data_file"));
        Iterator<Workshop> iterator = workshops.getWorkshops().iterator();
        while (iterator.hasNext()) {
            Workshop workshop = iterator.next();
            if (workshop.getType().startsWith("n8"))
                iterator.remove();
        }
        model.put("workshops", workshops.getWorkshops());
        return new ModelAndView(model, Path.Template.REGISTRATION); // located in the resources directory
    }

    public static ModelAndView submitForm(Request request, Response response) {
        UUID uuid = UUID.randomUUID();
        RegistrationForm registrationForm = new RegistrationForm(
                request.queryParams("id"),
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
                request.queryParams("preferredEmail"),
                uuid.toString());
        JsonTransformer jsonTransformer = new JsonTransformer();
        send("Workshop Registration from Website", jsonTransformer.render(registrationForm));
        Map<String, Object> model = new HashMap<>();
        try {

            Map<String, Object> result = new ObjectMapper().readValue(jsonTransformer.render(registrationForm), HashMap.class);
            HashMap<String, Object> fixedResult = new HashMap<>();
            String include_file = Globals.fileToString(Globals.getProperties().getProperty("data_dir").concat(Globals.getProperties().getProperty("submit")));
            String[] keys = result.keySet().toArray(new String[0]);
            Pattern pattern = Pattern.compile("[A-Z]");
            String newKey = "";
            for (int i = 0; i < keys.length; i++) {
                Matcher m = pattern.matcher(keys[i]);
                if (m.find()) {
                    int index = m.start();
                    newKey = keys[i].substring(0, index) + " " + keys[i].substring(index);
                } else
                    newKey = keys[i];
                newKey = newKey.substring(0,1).toUpperCase() + newKey.substring(1);
                fixedResult.put(newKey, result.get(keys[i]));
            }
            model.put("form_content", fixedResult);
            model.put("include_file", include_file);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        return new ModelAndView(model, Path.Template.RECEIPT);
    }

    ;

}