package techproed.tests.HomeWork;

import org.apache.commons.math3.ode.events.Action;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

import javax.swing.*;

public class US101122_Negative_Login {

    @Test
    public void test01() {
        //Name:
        //US101201_Negative_Login
        //Description:
        //Geçerli giriş yapmadan rezervasyon yapamamalı
        //Acceptance Criteria:
        //Kullanici arac bilgilerini girip CONTINUE RESERVATION butonuna tikladiginda
        //Ve giris yapilmadiginda
        //Hata mesaji almali : Please first login
        //Giris yapildiginda hata mesaji alınmamalı
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        Select select = new Select(blueRentalPage.selectCar);
        select.selectByValue("9");
        blueRentalPage.pickUpLocation.sendKeys
                ("Ankara" , Keys.TAB , "Güdül" , Keys.TAB , "30" , "11" , "2023" , Keys.TAB , "16" , "00" ,
                        Keys.TAB , "01","12","2023" , Keys.TAB , "08" , "34");
        blueRentalPage.reservationButton.click();
        ReusableMethods.visibleWait(blueRentalPage.pleaseFirstLogin , 10);
        Assert.assertTrue(blueRentalPage.reservationButton.isDisplayed());


    }


    @Test
    public void test02() {
        //Name:
        //US101122_Negative_Login
        //Description:
        //Geçerli email uzantısı olmadan kullanıcı girişi yapılamamalı
        //Acceptance Criteria:
        //Kullanici geçersiz email uzantısı yazdiginda, hata mesajini almalı
        //Error Message: email must be a valid email
        //Dogru email uzantisi girildiğinde hata mesajı alınmamali

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmailUS101122"));
        String errorMesaage = blueRentalPage.emailErrorMessage.getText();

        Assert.assertEquals(errorMesaage , "email must be a valid email" , "Uyarı mesajları birbirine eşit değil");
        Driver.getDriver().navigate().refresh();
        blueRentalPage.email.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmailUS101122Pass"));
        Assert.assertNotEquals(blueRentalPage.emailErrorMessage.getText() , "");


    }

    @Test
    public void test03() {

        //  Name:
        //  US100402_Negative_Login
        //  Description:
        //  Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapılamamalı
        //  Acceptance Criteria:
        //  Kullanici dogru email ve yanlis sifre girildiginde, hata mesajini alınmalı
        //  Hata Mesaji:
        //  Bad credentials
        //  Test Data:
        //  Customer email: jack@gmail.com
        //  Customer password: fakepass

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        BlueRentalPage blueRentalPage = new BlueRentalPage();
        blueRentalPage.loginButton.click();
        blueRentalPage.email.sendKeys(ConfigReader.getProperty("fakeEmailUS100402"));
        blueRentalPage.password.sendKeys(ConfigReader.getProperty("fakePasswordUS100402"), Keys.ENTER);

        ReusableMethods.visibleWait(blueRentalPage.bad_credentials , 10);
        Assert.assertTrue(blueRentalPage.bad_credentials.isDisplayed());


    }

}
