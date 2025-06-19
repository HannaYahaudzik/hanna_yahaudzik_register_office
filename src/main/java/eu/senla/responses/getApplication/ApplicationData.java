package eu.senla.responses.getApplication;

import com.fasterxml.jackson.annotation.JsonProperty;

public record ApplicationData(

        @JsonProperty("applicationid")
        Integer applicationId,

        @JsonProperty("citizenid")
        Integer citizenId,

        @JsonProperty("applicantid")
        Integer applicantId,

        @JsonProperty("staffid")
        Integer staffId,

        @JsonProperty("dateofapplication")
        String dateOfApplication,

        @JsonProperty("kindofapplication")
        String kindOfApplication,

        @JsonProperty("statusofapplication")
        String statusOfApplication,

        String channel,
        String image
) {
}
