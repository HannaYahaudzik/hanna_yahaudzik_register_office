package eu.senla;


import eu.senla.config.SpecConfig;
import eu.senla.templates.getApplication.GetApplicationResponse;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class GetApplicationTest {

    @Test
    public void testFirst() {
        GetApplicationResponse response =
                given()
                        .spec(SpecConfig.requestSpecification())
                        .basePath("getApplications")
                        .when()
                        .get()
                        .then()
                        .spec(SpecConfig.responseSpecification())
                        .extract().as(GetApplicationResponse.class);

        Assert.assertNotNull(response.getTotal());
    }

    @Test
    public void testSecond() {
        GetApplicationResponse response =
                given()
                        .spec(SpecConfig.requestSpecification())
                        .basePath("getApplications")
                        .when()
                        .get()
                        .then()
                        .spec(SpecConfig.responseSpecification())
                        .extract().as(GetApplicationResponse.class);

        Assert.assertNotNull(response.getData());
    }
}
