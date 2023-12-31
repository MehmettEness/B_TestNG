package techproed.tests.T25_xmlfiles_paralelltesting;

import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C02_ParalelTest {
    @Test
    public void test01() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));
        Driver.closeDriver();
    }

    @Test
    public void test02() {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        Driver.getDriver().get(ConfigReader.getProperty("OpenSourceUrl"));
        Driver.closeDriver();
    }
}
