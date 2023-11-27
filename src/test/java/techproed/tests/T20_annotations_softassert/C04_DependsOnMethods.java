package techproed.tests.T20_annotations_softassert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class C04_DependsOnMethods {
      /*
        Test NG de DependsOnMethods ozelligini kullanarak bazi testlerin bagimli oldugu
        diger testlerin basarili olmasi durumuna göre calistirabilirsiniz
        DependsOnMethods baglandigi testin sonucuna bakar, passed olursa calisir fail olursa hic calismaz
     */

    WebDriver driver;

    @BeforeClass
    public void beforeClass() {
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }


    @Test
    public void test01() {

        //amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        driver.navigate().refresh();
        driver.navigate().refresh();

        //arama kutusunda iphone aratiniz
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("iphone");
        searchBox.submit();
        Assert.assertEquals(2,3);

    }

    //Assert.assertEquals(2,3); bu kısım yanlış olduğundan ve test 02 test 01 e bağımlı olduğundan test02 görmezden gelinir. (Test ignored.)
    @Test(dependsOnMethods = "test01")
    public void test02() {

        //sonuc yazisinin iphone icerdigini test edelim
        String sonucYazisi =driver.findElement(By.xpath("(//*[@class='sg-col-inner'])[1]")).getText();
        Assert.assertTrue(sonucYazisi.contains("iphone"));

    }

    @AfterClass
    public void afterClass() {
        driver.close();
    }
}