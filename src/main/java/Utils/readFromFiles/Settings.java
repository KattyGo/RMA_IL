package Utils.readFromFiles;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings {

    private static final String DATA_FILE_PATH = "src/main/resources/settings.properties";

    private static Properties properties = new Properties();

    public static String readFromProp(String prop) {
        try {
            FileInputStream inputStream = new FileInputStream(DATA_FILE_PATH);
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return  properties.getProperty(prop);
    }



}

