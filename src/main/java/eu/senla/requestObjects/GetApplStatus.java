package eu.senla.requestObjects;

import eu.senla.templates.getApplStatus.GetApplStatusResponse;
import eu.senla.utilities.RequestManager;
import lombok.Getter;

public class GetApplStatus {

    private final String BASE_PATH = "getApplStatus";

    @Getter
    private GetApplStatusResponse response;

    public GetApplStatus(final Integer applicationId) {
        response = RequestManager.getRequest(BASE_PATH + "/" + applicationId, GetApplStatusResponse.class);
    }
}
