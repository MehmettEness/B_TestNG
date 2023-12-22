package techproed.tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.EnesAmazonPage;
import techproed.utilities.Driver;


public class EnesAmazon {
    EnesAmazonPage amazonPage = new EnesAmazonPage();
    @Test
    public void test01() {
        Driver.getDriver().get("https://amazon.com");
        Driver.getDriver().navigate().refresh();
        Driver.getDriver().navigate().refresh();

        //arama kutusuna enes yazdır
        amazonPage.searchBox.sendKeys("enes");
        amazonPage.searchBox.submit();
        Driver.closeDriver();

    }
}
