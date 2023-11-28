package techproed.tests.HomeWork;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import techproed.pages.ZeroBankPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HomeWork01 {
    @Test
    public void test01() {
        //1."http://zero.webappsecurity.com/" Adresine gidin başlığın Personal içerdiğini test edin
        Driver.getDriver().get(ConfigReader.getProperty("zeroBankUrl"));
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Personal"));

        //2. Sign in butonuna basin
        ZeroBankPage zeroBankPage = new ZeroBankPage();
        zeroBankPage.signInButton.click();

        //3. Login kutusuna "username" yazin
        zeroBankPage.userName.sendKeys("username");

        //4. Password kutusuna "password" yazin
        zeroBankPage.passWord.sendKeys("password");

        //5. Sign in tusuna basin
        zeroBankPage.signInSubmit.click();
        Driver.getDriver().navigate().back();

        //6. Online banking menusu icinde Pay Bills sayfasina gidin başlığın Zero içerdiğini test edin
        zeroBankPage.onlineBanking.click();
        zeroBankPage.payPall.click();
        Assert.assertTrue(Driver.getDriver().getTitle().contains("Zero"));

        //7. "Purchase Foreign Currency" tusuna basin
        zeroBankPage.PFC.click();

        //8. "Currency" drop down menusunden Eurozone'u secin
        zeroBankPage.currency.click();
        Select select = new Select(zeroBankPage.currency);
        select.selectByVisibleText("Eurozone (euro)");

        //9. soft assert kullanarak "Eurozone (Euro)" secildigini test edin
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(select.getFirstSelectedOption().getText().equals("Eurozone (Euro)"));

        //10.soft assert kullanarak DropDown listesinin su secenekleri oldugunu test
        //edin ("Select One", "Australia (dollar)", "Canada (dollar)","Switzerland
        //(franc)","China (yuan)","Denmark (krone)","Eurozone (euro)","Great Britain
        //(pound)","Hong Kong (dollar)","Japan (yen)","Mexico (peso)","Norway
        //(krone)","New Zealand (dollar)","Sweden (krona)","Singapore
        //(dollar)","Thailand (baht)")

        String[] expectedDropDownList = {"Select One", "Australia (dollar)", "Canada (dollar)", "Switzerland (franc)", "China (yuan)",
                "Denmark (krone)", "Eurozone (euro)", "Great Britain (pound)", "Hong Kong (dollar)", "Japan (yen)", "Mexico (peso)",
                "Norway (krone)", "New Zealand (dollar)", "Sweden (krona)", "Singapore (dollar)", "Thailand (baht)"};
        List<String> actualDropDownList = new ArrayList<>();
        List<WebElement> dropDownOptions = select.getOptions();

        for (WebElement w : dropDownOptions) {
            actualDropDownList.add(w.getText());
        }

        softAssert.assertTrue(actualDropDownList.containsAll(Arrays.asList(expectedDropDownList)));

        softAssert.assertAll();

        Driver.closeDriver();




    }

}
