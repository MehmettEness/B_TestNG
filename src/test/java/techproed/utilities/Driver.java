package techproed.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Driver {
    private Driver(){
        /*
        POM de driver classındaki getDriver methodunun object oluşturararkta erişimi kısıtlamak için SINGLETON PATTERN benimsenmiştir
         */
    }

    /*
    Driveri her çağırdığımızda yeni bir pencere açmaması için ve hata almamak için dolayısıyla if blogu içinde ayarlama yaptık

     */
    static WebDriver driver;
    public static WebDriver getDriver () {


        if (driver == null){ //eger driver deger atanmamış ise driveri başlat dedik. Driver değer atanmış ise return driver devreye girer
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver!=null){
            driver.close();
            driver =null;
        }


    }

}
