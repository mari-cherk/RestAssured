package thecat;

import org.testng.annotations.Test;
import thecat.testConfig.TestConfig;

import static io.restassured.RestAssured.given;

public class TheCat_GET_Votes extends TestConfig {

    @Test
    public void getVotes() {

        given()
                .spec(spec)
                .when().get("/votes").
                then().spec(responseSpec);



    }
}
