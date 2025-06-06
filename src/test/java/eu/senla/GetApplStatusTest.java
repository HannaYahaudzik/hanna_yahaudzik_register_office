package eu.senla;

import eu.senla.requestObjects.GetApplStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplStatusTest {

    private final Integer APPLICATION_ID = 49998;

    @Test
    public void schemaValidation() {
        String requestId = new GetApplStatus(APPLICATION_ID)
                .getResponse()
                .getRequestId();
        Assert.assertNotNull(requestId);
    }
}
