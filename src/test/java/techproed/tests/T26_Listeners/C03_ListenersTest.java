package techproed.tests.T26_Listeners;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


@Listeners(techproed.utilities.Listeners.class)
public class C03_ListenersTest {
    @Test(retryAnalyzer = techproed.utilities.Listeners.class) //tek tek çalıştırmak iiçin eski yol gerek yok
    public void test01() {
        System.out.println("PASS");
        Assert.assertTrue(true);
    }
    @Test(retryAnalyzer = techproed.utilities.Listeners.class) //tek tek çalıştırmak iiçin
    public void test02() {
        System.out.println("FAIL");
        Assert.assertTrue(false);
    }

}

