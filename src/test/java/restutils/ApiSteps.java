package restutils;

import constans.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.log4j.Logger;
import utils.JsonUtils;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class ApiSteps {

    private final static Logger logger = Logger.getLogger(ApiSteps.class);

    public static void CreateNewUser(String login, String password) {
        logger.info("Create new user.");
        RestAssured.baseURI = "https://demoqa.com/Account/v1/User";
        RequestSpecification specification = RestAssured.given();
        specification.body(("{\n" +
                "  \"userName\": \"" + login + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}"));
        specification.contentType(ContentType.JSON);
        Response response = specification.request(Method.POST, "");
    }

    public static Response getBooksListFromApiRequest() {
        logger.info("Get books list from API.");
        RestAssured.baseURI = JsonUtils.getConfig("baseUri");
        Response response = given()
                .when()
                .get(Endpoints.BOOKS_LIST)
                .then().log().all()
                .body("", notNullValue())
                .extract().response();
        return response;
    }
}
