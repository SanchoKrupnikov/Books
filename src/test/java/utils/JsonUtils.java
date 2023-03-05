package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {

    public static String getConfig(String key) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try (FileReader reader = new FileReader("src/test/java/resources/config.json")) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return key = (String) jsonObject.get(key);
    }

    public static <T> T getObject(Response response, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        T tObject = null;
        try {
            tObject = mapper.readValue(response.getBody().asString(), cls);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tObject;
    }
}
