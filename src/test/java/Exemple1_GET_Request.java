import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Exemple1_GET_Request {

    @Test
    void getWeatherDetails(){

        RestAssured.baseURI = "http://restapi.demoqa.com/utilities/weather/city/";

        RequestSpecification httpRequest = RestAssured.given();

        Response response = httpRequest.request(Method.GET, "/Hyderabad");

        String responseBody = response.getBody().asString();
        System.out.println("Response Body is "+ responseBody);

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, "200");

        String statusLine = response.getStatusLine();
        Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");

    }
}
