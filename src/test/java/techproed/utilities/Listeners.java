package techproed.utilities;

import org.testng.*;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Listeners implements ITestListener, IRetryAnalyzer, IAnnotationTransformer {

    @Override
    public void onStart(ITestContext context) {
        System.out.println("onStart==> Tum testlerden once tek bir kere cagirilir  :  "+context.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println("onFinish==> Tum testlerden sonra tek bir kere cagirilir  :  " +context.getName() );
    }

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println("onTestStart==> her bir @Test ten once bir kere cagirilir  :  "+result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        System.out.println("onTestSuccess==> sadece pass olan testlerden sonra bir kere cagirilir  :  "+result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {
        System.out.println("onTestFailure==> sadece fail olan testlerden sonra bir kere cagirilir  :  "+result.getName());
        ReusableMethods.screenShot(result.getName());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        System.out.println("onTestSkipped==> sadece atlanan testlerden sonra bir kere cagirilir  :  "+result.getName());
    }

    /*
    Bu method sadece FAIL olan tet methıodları tekrar çalıştırır
    maxRetryCount = 1; buraya kaç yazarsak o kadar tekrar çalıştır dedik.
    Bu altyapı bu methodu kullanmak istersek ;
     @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(Listeners.class);
        bunla kullanmamız lazım
     */
    private static int retryCount = 0;
    private static final int maxRetryCount = 1;
    @Override
    public boolean retry(ITestResult result) {
        if (retryCount < maxRetryCount) {
            retryCount++;
            return true;
        }
        return false;
    }

/*
Bu method retry methodu için yardımıc bir methoddur.Teknik olarak tet notasyonlarının
classları, cons , ve methodları transform yapmaya yarar.
 */
    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

        annotation.setRetryAnalyzer(Listeners.class);
    }

}