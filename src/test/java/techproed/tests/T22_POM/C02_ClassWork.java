package techproed.tests.T22_POM;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.TestCenterPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_ClassWork {


    @Test
    public void test01() {

        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        Driver.getDriver().get(ConfigReader.getProperty("testCenterUrl"));

        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        TestCenterPage testCenterPage = new TestCenterPage();
        String username = ConfigReader.getProperty("techpro_test_username");
        String password = ConfigReader.getProperty("techpro_test_password");

        testCenterPage.username.sendKeys(username);
        testCenterPage.password.sendKeys(password);
        testCenterPage.submitButton.click();

        ReusableMethods.visibleWait(testCenterPage.logOutButton , 15);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(testCenterPage.logOutButton.isDisplayed());

        //Sayfadan cikis yap ve cikis yapildigini test et
        testCenterPage.logOutButton.click();
        softAssert.assertEquals(Driver.getDriver().getTitle() , "Login");
        softAssert.assertAll();


        //sayfayı kapatınız
        Driver.closeDriver();
    }


}
