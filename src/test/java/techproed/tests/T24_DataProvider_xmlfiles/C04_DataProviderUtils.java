package techproed.tests.T24_DataProvider_xmlfiles;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;

public class C04_DataProviderUtils {
    @Test(dataProvider = "negativeTestData", dataProviderClass = DataProviderUtils.class)
    public void test01(int age) {

        //https://dataprovider.netlify.app/ adresine gidelim
        Driver.getDriver().get("https://dataprovider.netlify.app/");

        //BlackBoxTesting techniques ile otomasyon test yapalim
        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searcBox.sendKeys(String.valueOf(age), Keys.TAB, Keys.ENTER);

        Assert.assertTrue(dataProviderPage.positiveVerifyMessage.isDisplayed());
        //Driveri kapatalim
        Driver.closeDriver();

    }
}
