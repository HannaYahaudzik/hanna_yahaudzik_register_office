package eu.senla;

import eu.senla.database.DataBaseConnection;
import eu.senla.requestObjects.GetApplication;
import eu.senla.responses.getApplication.ApplicationData;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLException;

public class GetApplicationTest {

    @Test
    public void schemaValidation(){
        Assert.assertNotNull(
                new GetApplication()
                        .getResponse()
        );
    }

    @Test (priority = 1)
    public void checkTotal() throws SQLException {
        Assert.assertEquals(
                new GetApplication()
                        .getResponse()
                        .getTotal(),
                DataBaseConnection.getApplicationCount()
        );
    }

    @Test (priority = 1)
    public void checkApplication() throws SQLException {
        ApplicationData applicationData = new GetApplication()
                .getResponse().getData().get(0);

        ApplicationData expectedApplicationData = DataBaseConnection.getApplicationData(applicationData.getApplicationId());

        Assert.assertEquals(
                applicationData.getCitizenId(),
                expectedApplicationData.getCitizenId()
        );
    }
}
