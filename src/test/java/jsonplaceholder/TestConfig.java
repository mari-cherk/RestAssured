package jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;

import static org.hamcrest.Matchers.lessThan;

public class TestConfig {

    public static RequestSpecification spec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup(){


        //RestAssured.baseURI = "https://thecatapi.com";
        //RestAssured.basePath = "/v1";
        //RestAssured.requestSpecification = new RequestSpecBuilder()
        //.setAccept(ContentType.JSON)
        //.setContentType(ContentType.JSON)
        //.addHeader("x-api-key","603af0af-0bb0-4752-95b2-9362bb9678a7")
        //.build();

        spec = new RequestSpecBuilder()
                .setBaseUri("http://jsonplaceholder.typicode.com/")
                //.setBasePath("posts/")
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .build();

        RestAssured.requestSpecification = spec;

        responseSpec = new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectStatusCode(200)
                //.expectResponseTime(lessThan(3000L))
                .build();

        RestAssured.responseSpecification = responseSpec;

    }
}
