package jsonplaceholder;

import java.util.List;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.Matchers.lessThan;

public class RequestTests extends TestConfig {

    @Test
    public void checkBody(){
        given()
                .spec(spec)
                //.queryParam("postId", 1)
                .when()
                .get("posts")
                .then()
                .body("body[0]", equalTo("quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto"));
    }

    @Test
    public void getAllPosts() {

        String responseBody = given().spec(spec).when().get("posts").asString();
        System.out.println(responseBody);

    }

    @Test
    public void getAllPosts_DoCheckFirst(){

        Response response =
                given()
                .spec(spec)
                .when()
                .get("posts")
                .then()
                .contentType(ContentType.JSON)
                .extract().response();

        String jsonResponseString = response.asString();

        System.out.println(jsonResponseString);
    }

    @Test
    public void extractHeaders(){

        Response response =
                given()
                        .spec(spec)
                        .when()
                        .get("posts")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        Headers headers = response.getHeaders();

        String contentType = response.getHeader("Content-Type");

        System.out.println(contentType);
    }

    @Test
    public void extractFirstTitle(){

        String firstTitle = given().spec(spec).when()
                .get("posts").jsonPath().getString("title[0]");

        System.out.println(firstTitle);
    }

    @Test
    public void extractAllTitles(){

        Response response =
                given()
                        .spec(spec)
                        .when()
                        .get("posts")
                        .then()
                        .contentType(ContentType.JSON)
                        .extract().response();

        List<String> titles = response.path("title");

        System.out.println("The total number of titles are: " + titles.size());

        //titles.forEach( x-> System.out.println(x));

        titles.forEach(System.out::println);

        /*for(String title: titles) {
            System.out.println(title);
        }*/
    }

    @Test
    public void getResponseTime() {

        long responseTime = given()
                .spec(spec)
                .when()
                .get("posts")
                .time();

        System.out.println(responseTime);
    }

    @Test
    public void checkResponseTime() {

         given()
                .spec(spec)
                .when()
                .get("posts")
                .then()
         .time(lessThan(2000L));

    }
}
