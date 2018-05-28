package battleshipsJava.mvc;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertyReader {
    public static Properties readGameProperties(){
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("src/main/resources/config.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return properties;
    }

}
