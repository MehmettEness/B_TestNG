package techproed.tests.T24_DataProvider_xmlfiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class C01_DataProvider {
    @DataProvider
    public static Object[][] isimler() {
        return new Object[][]{

                {"mustafa"},{"enes"},{"ibrahim"},{"ali"}
        };
    }

    @DataProvider
    public static Object[][] isimlerSoyisimler() {
        return new Object[][]{
                {"mehmet" , "Enes"},{"Ahmet" , "Can"},{"Özkan" , "Uğur"}
        };
    }

    @Test (dataProvider = "isimler") //isimler yazıp üzerine gelince yukarıdaki Object oluştu
    public void test01(String data) {

        System.out.println(data);

    }

    @Test(dataProvider = "isimlerSoyisimler")
    public void testName(String isim , String Soyisim) {
        System.out.println(isim +" " + Soyisim    );
    }
}
