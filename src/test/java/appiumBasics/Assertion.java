package appiumBasics;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assertion {

    @Test
    public void testHardAssertion() throws Exception {
        //Hard Assertions - if one fail others will not be reached
        Assert.assertEquals(1, 2);
        Assert.assertTrue(true);
        Assert.fail();

    }

    @Test
    public void testSoftAssertion() throws Exception {

        //Soft Assertions - if one fail others will be reached
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(1, 1);
        softAssert.assertEquals(1, 2);
        softAssert.assertTrue(false);
        softAssert.assertTrue(true);
        softAssert.assertTrue(false);
        softAssert.assertAll();
    }
}
