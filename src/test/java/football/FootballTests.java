package football;

import static org.hamcrest.CoreMatchers.equalTo;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class FootballTests extends TestConfig{

    @Test
    public void getAllCompetitionsOneSeason(){
        given()
        .spec(spec)
        //.queryParam("season", 2017)
        .when()
        .get("competitions")
        .then()
        .body("count", equalTo(149));
    }


}
