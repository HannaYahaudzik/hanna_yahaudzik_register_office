package eu.senla;

import eu.senla.database.DataBaseConnection;
import eu.senla.requestObjects.GetApplication;
import eu.senla.responses.getApplication.ApplicationData;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.sql.SQLException;

public class GetApplicationTest {

    @Test
    public void schemaValidation() {
        Assert.assertNotNull(
                new GetApplication()
                        .getResponse()
        );
    }

    @Test(priority = 1)
    public void checkTotal() throws SQLException {
        Assert.assertEquals(
                new GetApplication()
                        .getResponse()
                        .total(),
                DataBaseConnection.getApplicationCount()
        );
    }

    @Test(priority = 1)
    public void checkApplicationData() throws SQLException {
        ApplicationData applicationData = new GetApplication()
                .getResponse().data().get(0);

        ApplicationData expectedApplicationData = DataBaseConnection.getApplicationData(applicationData.applicationId());

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(applicationData.citizenId(), expectedApplicationData.citizenId());
        softAssert.assertEquals(applicationData.applicantId(), expectedApplicationData.applicantId());
        softAssert.assertEquals(applicationData.staffId(), expectedApplicationData.staffId());
        softAssert.assertEquals(applicationData.kindOfApplication(), expectedApplicationData.kindOfApplication());
        softAssert.assertEquals(applicationData.statusOfApplication(), expectedApplicationData.statusOfApplication());
        softAssert.assertEquals(applicationData.channel(), expectedApplicationData.channel());
        softAssert.assertAll();
    }
}
