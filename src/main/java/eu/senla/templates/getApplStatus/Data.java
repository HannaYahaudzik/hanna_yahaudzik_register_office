package eu.senla.templates.getApplStatus;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
public class Data {

    @JsonProperty("dateofapplication")
    private String dateOfApplication;

    @JsonProperty("kindofapplication")
    private String kindOfApplication;

    @JsonProperty("statusofapplication")
    private String statusOfApplication;
}
