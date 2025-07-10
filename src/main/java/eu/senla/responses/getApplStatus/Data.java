package eu.senla.responses.getApplStatus;

import com.fasterxml.jackson.annotation.JsonProperty;

public record Data(

        @JsonProperty("dateofapplication")
        String dateOfApplication,

        @JsonProperty("kindofapplication")
        String kindOfApplication,

        @JsonProperty("statusofapplication")
        String statusOfApplication
) {
}
