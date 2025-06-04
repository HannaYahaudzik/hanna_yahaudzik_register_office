package eu.senla.utilities;

import eu.senla.config.SpecConfig;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static io.restassured.RestAssured.given;

public final class RequestManager {

    private RequestManager() {
    }

    public static <T> T getRequest(final RequestSpecification requestSpecification,
                                   final ResponseSpecification responseSpecification,
                                   final String path,
                                   final Class<T> clazz) {

        return
                given()
                    .spec(requestSpecification)
                    .basePath(path)
                .when()
                    .get()
                .then()
                    .spec(responseSpecification)
                    .extract().as(clazz);
    }

    public static <T> T getRequest(final String path, final Class<T> clazz) {
        return getRequest(SpecConfig.requestSpecification(), SpecConfig.responseSpecification(), path, clazz);
    }

}
