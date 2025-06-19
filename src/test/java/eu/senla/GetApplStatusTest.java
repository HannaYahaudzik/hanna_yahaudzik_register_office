package eu.senla;

import eu.senla.requestObjects.GetApplStatus;
import eu.senla.requestObjects.GetApplication;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetApplStatusTest {

    private Integer applicationId;

    @BeforeTest
    public void getApplicationId(){
        this.applicationId = new GetApplication()
                .getResponse()
                .getData()
                .get(0)
                .getApplicationId();
    }

    @Test
    public void schemaValidation() {
        String requestId = new GetApplStatus(applicationId)
                .getResponse()
                .getRequestId();
        Assert.assertNotNull(requestId);
    }
}
