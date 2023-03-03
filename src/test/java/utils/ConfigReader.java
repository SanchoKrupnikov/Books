package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public static String getConfig (String key) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try (FileReader reader = new FileReader("src/test/java/resources/config.json")) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return key = (String) jsonObject.get(key);
    }

}
