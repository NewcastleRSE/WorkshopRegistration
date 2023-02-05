package controller.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import model.Workshops;

import java.io.File;
import java.io.IOException;

public class YamlUtil {

    public static Workshops loadWorkshopYaml(String filename) {
        final ObjectMapper mapper = new YAMLMapper(); // jackson databind
        Workshops workshops;
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            File file = new File(filename);
            workshops = mapper.readValue(file, Workshops.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
//        if (workshops == null) workshops = new Workshops();
        return workshops;
    }

}
