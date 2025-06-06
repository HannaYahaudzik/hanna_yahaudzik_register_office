package eu.senla.templates.sendUserRequest;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class SendUserRequestResponse {

    @JsonProperty("applicationid")
    private Integer applicationId;

    @JsonProperty("applicantid")
    private Integer applicantId;

    @JsonProperty("citizenid")
    private Integer citizenId;

    @JsonProperty("merrigecertificateid")
    private Integer merrigeCertificateId;
}
