package techproed.tests.T23_Excel;

import org.testng.annotations.Test;
import techproed.utilities.ExcelReader;

public class C01_ExcelTest {
    @Test
    public void test01() {
        String dosyayolu= "src\\test\\java\\techproed\\resources\\mysmoketestdata.xlsx";
        String sayfaIsmi ="customer_info";

        ExcelReader excelReader = new ExcelReader(dosyayolu , sayfaIsmi);
        System.out.println("excelReader.getCellData(0 , 0) = " + excelReader.getCellData(0, 0));
        System.out.println("excelReader.getCellData(0 , 1) = " + excelReader.getCellData(0, 1));
        String email = excelReader.getCellData(1,0);
        String password = excelReader.getCellData(1,1);
        System.out.println( email + " " + password);

    }
}
