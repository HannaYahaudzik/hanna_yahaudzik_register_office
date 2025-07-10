package eu.senla;

import eu.senla.database.DataBaseConnection;
import eu.senla.requestObjects.GetApplication;
import eu.senla.responses.getApplication.ApplicationData;
import eu.senla.utilities.Random;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class GetApplicationTest {

    @Test
    public void schemaValidation() {
        Assert.assertNotNull(
                new GetApplication()
                        .getDTOResponse()
        );
    }

    @Test(priority = 1)
    public void checkTotal() throws SQLException {
        Assert.assertEquals(
                new GetApplication()
                        .getDTOResponse()
                        .total(),
                DataBaseConnection.getApplicationCount()
        );
    }

    @Test(priority = 1)
    public void checkFirstApplicationData() throws SQLException {
        ApplicationData applicationData = new GetApplication()
                .getDTOResponse()
                .data()
                .get(0);

        ApplicationData expectedApplicationData = DataBaseConnection.getApplicationData(applicationData.applicationId());

        Assert.assertEquals(expectedApplicationData, applicationData, "Actual ApplicationData isn't equaled an ApplicationData from DB");

    }

    @Test
    public void checkRandomApplicationData() throws SQLException {

        Response response = new GetApplication()
                .getResponse();

        int applicationId = response
                .jsonPath()
                .getInt(
                        "data[" + Random.getRandomInt(
                                response.jsonPath().getInt("total") - 1
                        ) + "].applicationid"
                );

        ApplicationData applicationData = response
                .jsonPath()
                .getObject("data.find { it.applicationid == " + applicationId + " }", ApplicationData.class);

        ApplicationData expectedApplicationData = DataBaseConnection.getApplicationData(applicationId);

        Assert.assertEquals(expectedApplicationData, applicationData, "Actual ApplicationData isn't equaled an ApplicationData from DB");

    }
}
