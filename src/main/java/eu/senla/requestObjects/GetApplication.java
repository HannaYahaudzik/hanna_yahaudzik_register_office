package eu.senla.requestObjects;

import eu.senla.responses.getApplication.GetApplicationResponse;
import eu.senla.utilities.RequestManager;
import io.restassured.response.Response;


public class GetApplication {

    private final String BASE_PATH = "getApplications";

    public GetApplication() {
    }

    public final GetApplicationResponse getDTOResponse() {
        return RequestManager.getRequest(BASE_PATH, GetApplicationResponse.class);
    }

    public final Response getResponse() {
        return RequestManager.getRequest(BASE_PATH);
    }
}
