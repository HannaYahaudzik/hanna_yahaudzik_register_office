package eu.senla;

import eu.senla.requestObjects.GetApplication;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GetApplicationTest {

    @Test
    public void schemaValidation() {
        String total = new GetApplication()
                .getResponse()
                .getTotal();
        Assert.assertNotNull(total);
    }
}
