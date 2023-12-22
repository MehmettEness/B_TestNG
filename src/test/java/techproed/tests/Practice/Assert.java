package techproed.tests.Practice;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Assert {

    @Test
    public void testassert() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals("enes" , "enes" , "eşit olmaları gerekir");
        softAssert.assertTrue(3<2 , "başarısız kontrol");
        softAssert.assertFalse(3>2 , "başarısız kontrol");
        softAssert.assertNotEquals("enes" , "enes" , "başarısız kontrol");
        softAssert.assertAll();


    }
}
