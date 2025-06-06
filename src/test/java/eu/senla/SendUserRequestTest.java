package eu.senla;

import eu.senla.database.DataBaseConnection;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class SendUserRequestTest {

    @Test
    public void schemaValidation() {

        try {
            System.out.println(
                    DataBaseConnection.checkDatabase()
            );
            System.out.println(
                    DataBaseConnection.getApplicationCount()
            );
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


//        Integer applicantId = new SendUserRequest()
//                .postResponse()
//                .getApplicantId();
//
//        Assert.assertNotNull(applicantId);
    }
}
