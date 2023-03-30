package com.jannetta.carpentries.registration.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;
import com.jannetta.carpentries.registration.controller.RegistrationController;
import com.jannetta.carpentries.registration.model.Workshops;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class YamlUtil {
    private static Logger logger = LoggerFactory.getLogger(RegistrationController.class);

    public static Workshops loadWorkshopYaml(String dataFileURL) {
        try {
            URL url = new URL(dataFileURL);
            logger.info("Read data from: " + dataFileURL);
            URLConnection connection = url.openConnection();
            final ObjectMapper mapper = new YAMLMapper(); // jackson databind
            Workshops workshops;
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            try {
                File file = new File(dataFileURL);
                workshops = mapper.readValue(url, Workshops.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
//        if (workshops == null) workshops = new Workshops();
            return workshops;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
