package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyUtils {
    static Properties properties;

    // Static block loads config.properties file
    static {
        try (FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/test/resources/config.properties")) {
            properties = new Properties();
            properties.load(fileInputStream);
        } catch (IOException e) {
            System.out.println("Error while reading properties file");
        }
    }

    // Returns the value in the config file for the specified key
    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
