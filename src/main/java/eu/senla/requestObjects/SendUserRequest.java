package eu.senla.requestObjects;

import eu.senla.templates.sendUserRequest.SendUserRequestResponse;
import eu.senla.utilities.RequestManager;
import lombok.Getter;

public class SendUserRequest {

    private final String BASE_PATH = "/sendUserRequest";

    @Getter
    private SendUserRequestResponse response;

    private String body = "{\n" +
            "  \"mode\": \"string\",\n" +
            "  \"personalLastName\": \"string\",\n" +
            "  \"personalMiddleName\": \"string\",\n" +
            "  \"personalPhoneNumber\": \"string\",\n" +
            "  \"personalNumberOfPassport\": \"string\",\n" +
            "  \"citizenLastName\": \"string\",\n" +
            "  \"citizenFirstName\": \"string\",\n" +
            "  \"citizenMiddleName\": \"string\",\n" +
            "  \"citizenBirthDate\": \"string\",\n" +
            "  \"citizenNumberOfPassport\": \"string\",\n" +
            "  \"citizenGender\": \"string\",\n" +
            "  \"dateOfMarriage\": \"string\",\n" +
            "  \"newLastName\": \"string\",\n" +
            "  \"anotherPersonLastName\": \"string\",\n" +
            "  \"anotherPersonFirstName\": \"string\",\n" +
            "  \"anotherPersonMiddleName\": \"string\",\n" +
            "  \"birth_of_anotoherPerson\": \"string\",\n" +
            "  \"anotherPersonPassport\": \"string\",\n" +
            "  \"birth_place\": \"string\",\n" +
            "  \"birth_mother\": \"string\",\n" +
            "  \"birth_father\": \"string\",\n" +
            "  \"death_dateOfDeath\": \"string\",\n" +
            "  \"death_placeOfDeath\": \"string\"\n" +
            "}";

    public SendUserRequest() {
        response = RequestManager.postRequest(BASE_PATH, body, SendUserRequestResponse.class);
    }
}
