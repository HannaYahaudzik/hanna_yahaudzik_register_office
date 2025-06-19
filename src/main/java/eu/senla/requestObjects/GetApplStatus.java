package eu.senla.requestObjects;

import eu.senla.responses.getApplStatus.GetApplStatusResponse;
import eu.senla.utilities.RequestManager;
import lombok.Getter;

public class GetApplStatus {

    private final String BASE_PATH = "getApplStatus";

    @Getter
    private GetApplStatusResponse response;
    @Getter
    private Integer applicationId;

    public GetApplStatus(final Integer applicationId) {
        this.applicationId = applicationId;
        response = RequestManager.getRequest(BASE_PATH + "/" + applicationId, GetApplStatusResponse.class);
    }
}
