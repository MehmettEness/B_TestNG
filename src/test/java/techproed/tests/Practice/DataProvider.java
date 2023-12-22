package techproed.tests.Practice;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import techproed.pages.DataProviderPage;
import techproed.pages.GooglePages;
import techproed.utilities.ConfigReader;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class DataProvider {

    @org.testng.annotations.DataProvider
    public static Object[][] araclar() {
        return new Object[][]{
                {"mercedes"},
                {"volvo"},
                {"audi"},
                {"honda"},

        };
    }

    @org.testng.annotations.DataProvider (name = "urunler")
    public static Object[][] urunler() {
        return new Object[][]{
                {"mehmet"},{"enes"},{"arslan"},{"java"}


        };
    }

    @Test (dataProvider = "araclar")
    public void test01(String data) {
        System.out.println(data);
    }


    @Test (dataProvider = "urunler")
    public void test02(String data) {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        new GooglePages.GooglePage().searcBox.sendKeys(data , Keys.ENTER);
        ReusableMethods.bekle(2);

        Driver.closeDriver();
    }

    @Test(dataProvider = "positiveTestData" , dataProviderClass = DataProviderUtils.class)
    public void test02(int age) {
        Driver.getDriver().get("https://dataprovider.netlify.app/");

        DataProviderPage dataProviderPage = new DataProviderPage();
        dataProviderPage.searcBox.sendKeys(String.valueOf(age) , Keys.TAB , Keys.ENTER);


    }
}
