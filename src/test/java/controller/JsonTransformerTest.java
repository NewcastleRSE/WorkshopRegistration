package controller;	
	
import com.jannetta.carpentries.registration.controller.JsonTransformer;
import com.jannetta.carpentries.registration.model.RegistrationForm;
import org.junit.jupiter.api.Assertions;	
import org.junit.jupiter.api.Test;	
	
class JsonTransformerTest {	
	
    @Test	
    void renderTest() {	
        JsonTransformer jsonTransformer = new JsonTransformer();
        RegistrationForm registrationForm = new RegistrationForm("2023-03-03-NCL","Jannetta",
                "S", "Steyn","vegan", "website",
                "njss3", "07801889997", "PhD", "Computing",
                "Stage 4", "Computing", "jannetta.steyn@newcastle.ac.uk",
                "jannetta@henning.org", "uuid-1234");
        String s = "{\n  \"id\": \"2023-03-03-NCL\",\n  \"firstName\": \"Jannetta\",\n  \"middleNames\": \"S\"," +
                "\n  \"lastName\": \"Steyn\",\n  \"dietaryPreferance\": \"vegan\"," +
                "\n  \"howHeard\": \"website\",\n  \"loginID\": \"njss3\",\n  \"contactNumber\": \"07801889997\"," +
                "\n  \"degree\": \"PhD\",\n  \"studyProgramme\": \"Computing\",\n  \"stage\": \"Stage 4\"," +
                "\n  \"school\": \"Computing\",\n  \"universityEmail\": \"jannetta.steyn@newcastle.ac.uk\"," +
                "\n  \"preferredEmail\": \"jannetta@henning.org\",\n  \"UUID\": \"uuid-1234\"" +
                "\n}";
        Assertions.assertEquals(jsonTransformer.render(registrationForm), s);
    }	
}