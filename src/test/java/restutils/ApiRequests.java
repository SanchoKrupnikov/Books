package restutils;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.ConfigReader;

import static io.restassured.RestAssured.given;

public class ApiRequests {

    public static Response sendGet(String path, int expectedStatusCode) {
        RestAssured.baseURI = ConfigReader.getConfig("baseUri");
        return given()
                .contentType(ContentType.JSON)
                .get(path)
                .then().log().all()
                .statusCode(expectedStatusCode)
                .extract().response();
    }

//    public static Response sendPost(Post post, String path, int expectedStatusCode) {
//        RestAssured.baseURI = ConfigReader.getConfig("baseUri");
//        return given()
//                .contentType((ContentType.JSON))
//                .body(post)
//                .post(path)
//                .then().log().all()
//                .statusCode(expectedStatusCode)
//                .extract().response();
//    }
}
