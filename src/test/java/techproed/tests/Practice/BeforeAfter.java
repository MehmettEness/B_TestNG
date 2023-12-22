package techproed.tests.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class BeforeAfter {
    WebDriver driver;
    @BeforeGroups ("chrome")
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @Test (groups = "chrome" , priority = 6) //priority verilen int iade ye göre sıralı olarak çalıştırır.
    public void test01() {
        driver.get("https://amazon.com");
    }

    @Test (groups = "chrome" , priority = -1)
    public void test02() {
        driver.get("https://trendyol.com");
    }

    @Test (groups = "chrome" , priority = 2)
    public void test03() {
        driver.get("https://hepsiburada.com");
    }

    @Test  (groups = "chrome" , priority = 9)
    @Ignore //görmezden gelir

    public void test04() {
        driver.get("https://kamrusepa.com");
    }

    @AfterGroups (groups = "chrome")
    public void tearDown() {
        driver.close();

    }

}
