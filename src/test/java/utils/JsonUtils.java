package utils;

import basetest.BaseTest;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtils {
    private final static Logger logger = Logger.getLogger(JsonUtils.class);

    public static String getConfig(String key) {
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        try (FileReader reader = new FileReader("src/test/java/resources/config.json")) {
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
            logger.info(e.getMessage());
        }
        return key = (String) jsonObject.get(key);
    }

    public static <T> T getObject(Response response, Class<T> cls) {
        ObjectMapper mapper = new ObjectMapper();
        T tObject = null;
        try {
            tObject = mapper.readValue(response.getBody().asString(), cls);
        } catch (IOException e) {
            logger.info(e.getMessage());
        }
        return tObject;
    }
}
