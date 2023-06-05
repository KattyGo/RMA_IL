package Utils.readFromFiles;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;

public class TestData {

    private  static final  String DATA_FILE_PATH = "src/main/resources/test.json";

    public static Map<String ,String> loadData () throws IOException, ParseException {                   //-> key : value
        JSONParser parser = new JSONParser();
        FileReader reader = new FileReader(DATA_FILE_PATH);
        JSONObject jsonObject = null;
        jsonObject = (JSONObject) parser.parse(reader);
        return (Map<String, String>)  jsonObject;

    }
}
