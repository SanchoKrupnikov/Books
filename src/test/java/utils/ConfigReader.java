package utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;
import io.restassured.response.Response;
import models.User;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    public static List<?> getList(Response response, Class<?> dataType) {
        return response.body().jsonPath().getList("", dataType);
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


//    public static <T> T getObject(Response response, Class<T> cls) {
//        ObjectMapper mapper = new ObjectMapper();
//        T tObject = null;
//        try {
//            JsonNode responseNode = mapper.readTree(response.getBody().asString()).path("response");
//            if (responseNode.isArray()) {
//                CollectionType listType = mapper.getTypeFactory().constructCollectionType(ArrayList.class, cls);
//                List<T> list = mapper.readValue(responseNode.toString(), listType);
//                tObject = list.get(0);
//            } else {
//                String responseString = responseNode.toString();
//                tObject = Objects.isNull(responseString) || responseString.isEmpty() ?
//                        mapper.readValue(response.getBody().asString(), cls)
//                        : mapper.readValue(responseNode.toString(), cls);
//            }
//        } catch (IOException e) {
//
//        }
//        return tObject;
//    }



}
