package eu.senla.requestObjects;

import eu.senla.responses.getApplication.GetApplicationResponse;
import eu.senla.utilities.RequestManager;
import lombok.Getter;


public class GetApplication {

    private final String BASE_PATH = "getApplications";

    @Getter
    private GetApplicationResponse response;

    public GetApplication() {
        response = RequestManager.getRequest(BASE_PATH, GetApplicationResponse.class);
    }
}
