package techproed.tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;

public class BlueRental {
    BlueRentalPage blueRentalPage = new BlueRentalPage();

    @Test
    public void test01() {

        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        blueRentalPage.loginButton.click();


        String excelDosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String dosyaIsmi = "customer_info";
        ExcelReader excelReader = new ExcelReader(excelDosyaYolu , dosyaIsmi);

        String emailExcel = excelReader.getCellData(2,0);
        String passwordExcel = excelReader.getCellData(2 , 1);

        blueRentalPage.email.sendKeys(emailExcel);
        blueRentalPage.password.sendKeys(passwordExcel , Keys.ENTER);






    }
}
