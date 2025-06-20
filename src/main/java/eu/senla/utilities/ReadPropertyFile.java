package eu.senla.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public final class ReadPropertyFile {

    private static Properties properties;

    static {
        try {
            properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("src/main/resources/app.properties");
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.err.println("Error: properties file isn't found.");
        }
    }

    private ReadPropertyFile() {
    }

    public static String getProperties(final String key) {
        return properties.getProperty(key);
    }
}
