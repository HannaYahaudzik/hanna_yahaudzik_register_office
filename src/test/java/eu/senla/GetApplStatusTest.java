package eu.senla;

import eu.senla.requestObjects.GetApplStatus;
import eu.senla.requestObjects.GetApplication;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetApplStatusTest {

    private Integer applicationId;

    @BeforeTest
    public final void getApplicationId() {
        this.applicationId = new GetApplication()
                .getDTOResponse()
                .data()
                .getFirst()
                .applicationId();
    }

    @Test
    public void schemaValidation() {
        String requestId = new GetApplStatus(applicationId)
                .getResponse()
                .requestId();
        Assert.assertNotNull(requestId);
    }
}
