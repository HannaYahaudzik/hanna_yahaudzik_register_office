package eu.senla.config;

import eu.senla.utilities.ReadPropertyFile;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public final class SpecConfig {

    private static final int STATUS_CODE_SUCCESS = 200;

    private SpecConfig() {
    }

    public static RequestSpecification requestSpecification() {
        return new RequestSpecBuilder()
                .setBaseUri(ReadPropertyFile.getProperties("BASE_URL"))
                .setAuth(RestAssured.basic(ReadPropertyFile.getProperties("USERNAME"), ReadPropertyFile.getProperties("PASSWORD")))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static ResponseSpecification responseSpecification() {
        return new ResponseSpecBuilder()
                .expectStatusCode(STATUS_CODE_SUCCESS)
                .build();
    }
}
