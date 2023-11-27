package techproed.tests.T21_POM;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import techproed.pages.AmazonPage;
import techproed.utilities.Driver;

public class C02_PageKullanimi {


    @Test
    public void test01() {
        //amazona gidelim
        Driver.getDriver().get("https://amazon.com");



        //arama kutusunda iphone aratalım
        AmazonPage amazonPage = new AmazonPage();
        amazonPage.searchBox.sendKeys("iphone" , Keys.ENTER);

    }
}
