package eu.senla.utilities;

import eu.senla.config.SpecConfig;
import io.restassured.response.Response;
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
                        .log().ifError()
                        .spec(responseSpecification)
                        .extract().as(clazz);
    }

    public static <T> T getRequest(final String path, final Class<T> clazz) {
        return getRequest(SpecConfig.requestSpecification(), SpecConfig.responseSpecification(), path, clazz);
    }

    public static Response getRequest(final RequestSpecification requestSpecification,
                                      final ResponseSpecification responseSpecification,
                                      final String path) {
        return
                given()
                        .spec(requestSpecification)
                        .basePath(path)
                        .when()
                        .get();
    }

    public static Response getRequest(final String path) {
        return getRequest(SpecConfig.requestSpecification(), SpecConfig.responseSpecification(), path);
    }

    public static <T> T postRequest(final RequestSpecification requestSpecification,
                                    final ResponseSpecification responseSpecification,
                                    final String path,
                                    final String body,
                                    final Class<T> clazz) {

        return given()
                .spec(requestSpecification)
                .basePath(path)
                .body(body)
                .when()
                .post()
                .then()
                .log().ifError()
                .spec(responseSpecification)
                .extract().as(clazz);
    }

    public static <T> T postRequest(final String path, final String body, final Class<T> clazz) {
        return postRequest(SpecConfig.requestSpecification(), SpecConfig.responseSpecification(), path, body, clazz);
    }
}
