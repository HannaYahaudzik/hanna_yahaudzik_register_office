package eu.senla;

import eu.senla.requestObjects.GetApplication;
import eu.senla.templates.getApplication.GetApplicationResponse;
import eu.senla.utilities.RequestManager;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplicationTest {

    @Test
    public void testFirst() {
        GetApplicationResponse response = RequestManager.getRequest("getApplications", GetApplicationResponse.class);
        Assert.assertNotNull(response.getTotal());
    }

    @Test
    public void testSecond() {
        String total = new GetApplication()
                .getResponse()
                .getTotal();
        Assert.assertNotNull(total);
    }
}
