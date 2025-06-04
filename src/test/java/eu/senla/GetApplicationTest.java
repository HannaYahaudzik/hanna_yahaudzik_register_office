package eu.senla;


import eu.senla.config.SpecConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApplicationTest {

    @Test
    public void testFirst() {

        given()
                .spec(SpecConfig.requestSpecification())
                .basePath("getApplications")
                .when()
                .get()
                .then()
                .spec(SpecConfig.responseSpecification());
    }
}
