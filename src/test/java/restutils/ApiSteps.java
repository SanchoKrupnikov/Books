package restutils;

import constans.Endpoints;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import models.Book;

import java.util.List;

public class ApiSteps {

    public static void CreateNewUser (String login, String password) {
        RestAssured.baseURI = "https://demoqa.com/Account/v1/User";
        RequestSpecification specification = RestAssured.given();
        specification.body(("{\n" +
                "  \"userName\": \"" + login + "\",\n" +
                "  \"password\": \"" + password + "\"\n" +
                "}"));
        specification.contentType(ContentType.JSON);
        Response response = specification.request(Method.POST, "");
      }


//   public static Response createUser(String endpoint, String userName, String password) {
//        HashMap<String, String> queryParamsForCreateUser = new HashMap<>() {
//            {
//                put("userName", userName);
//                put("password", password);
//            }
//        };
//        return ApiRequests.sendPost(queryParamsForCreateUser, endpoint);
//    }
//
//    public static Response receiveBooksList(String endpoint) {
//        HashMap<String, String> queryParamsForBooksList = new HashMap<>() {
//            {
//
//            }
//        };
//        return ApiRequests.sendPost(queryParamsForBooksList, endpoint);
//    }


    public static List<Book> getAllBooks (int expectedStatusCode) {
        return ApiRequests.sendGet(Endpoints.BOOKS_LIST,expectedStatusCode)
                .body().jsonPath().getList(".", Book.class);
    }

}
