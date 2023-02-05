package controller.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class Globals {
    static Globals globals = null;
    static Properties properties;
    private static final String propertyFile = "system.properties";

    private Globals() {}

    public static Globals getInstance() {
        if (globals == null) {
            globals = new Globals();
            properties = loadProperties(propertyFile);
        }
        return globals;
    }

    private static Properties loadProperties(String propertyFile) {

        Properties properties = new Properties();
        try {
            InputStream is = new FileInputStream(propertyFile);
            properties.load(is);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return properties;
    }

    public static Properties getProperties() {
        return properties;
    }

    public static String fileToString(String filename) {
        try {
            InputStream inputStream = new FileInputStream(filename);
            return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
