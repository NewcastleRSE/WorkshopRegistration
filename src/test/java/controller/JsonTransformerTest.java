package controller;

import model.RegistrationForm;
class JsonTransformerTest {

    @org.junit.jupiter.api.Test
    static void render() {
        JsonTransformer jsonTransformer = new JsonTransformer();
        RegistrationForm registrationForm = new RegistrationForm("Jannetta", "S", "Steyn",
                "vegan", "website", "njss3", "07801889997", "PhD", "Computing",
                "Stage 4", "Computing", "jannetta.steyn@newcastle.ac.uk", "jannetta@henning.org");
        String s = jsonTransformer.render(registrationForm);
        System.out.println(s);
    }
}