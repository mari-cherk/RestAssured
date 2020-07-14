package reqres;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class AuthenticationTests {

    @Test
    public void basicPreemptiveAuthTest1() {

        String responseBody  = given()
                .auth().preemptive().basic("eve.holt@reqres.in", "cityslicka")
                .when()
                .get("https://reqres.in/api/login").asString();

        System.out.println(responseBody);
    }

    @Test
    public void basicPreemptiveAuthTest2() {

        Response response = given()
                .auth().preemptive().basic("eve.holt@reqres.in", "cityslicka")
                .when()
                .get("https://reqres.in/api/login")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        String jsonResponseString = response.asString();

        System.out.println(jsonResponseString);
    }
}
