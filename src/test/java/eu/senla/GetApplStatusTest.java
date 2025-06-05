package eu.senla;

import eu.senla.requestObjects.GetApplStatus;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplStatusTest {
    @Test
    public void schemaValidation(){
        String requestId = new GetApplStatus(49998)
                .getResponse()
                .getRequestId();
        Assert.assertNotNull(requestId);
    }
}
