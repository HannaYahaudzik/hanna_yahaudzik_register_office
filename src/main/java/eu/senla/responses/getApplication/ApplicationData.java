package eu.senla.responses.getApplication;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

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

    @Override
    public boolean equals(final Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ApplicationData that = (ApplicationData) o;
        return Objects.equals(channel, that.channel)
                && Objects.equals(image, that.image)
                && Objects.equals(staffId, that.staffId)
                && Objects.equals(citizenId, that.citizenId)
                && Objects.equals(applicantId, that.applicantId)
                && Objects.equals(applicationId, that.applicationId)
//                        && Objects.equals(dateOfApplication, that.dateOfApplication)
                && Objects.equals(kindOfApplication, that.kindOfApplication)
                && Objects.equals(statusOfApplication, that.statusOfApplication);
    }

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, citizenId, applicantId, staffId, dateOfApplication, kindOfApplication, statusOfApplication,
                channel, image);
    }
}
