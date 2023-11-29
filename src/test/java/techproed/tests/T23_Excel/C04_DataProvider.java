package techproed.tests.T23_Excel;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C04_DataProvider {//loopların kullanımını kolaylaştırmak için kullandığımız bir class
    //  @DataProvider
    //  public static Object[][] araclar() {
    //      return new Object[][]{};
    //  }


    @DataProvider
    public static Object[][] araclar() {
        return new Object[][]{

                {"mercedes"},
                {"volvo"},
                {"tofas"},
                {"honda"}
        };
    }





    @Test (dataProvider = "araclar") //"araclar" kısmını yazınca ve üstüne gelince Create method seç ve yukarıdaki @dataProvider oluştu
    public void test01(String data) {
        System.out.println(data);

    }
}
