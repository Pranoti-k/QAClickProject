package pranu.seleniumtest;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

import java.io.IOException;

public class Listener extends Base implements ITestListener
{
    @Override
    public void onTestStart(ITestResult result)
    {

    }

    @Override
    public void onTestSuccess(ITestResult result)
    {

    }

    @Override
    public void onTestFailure(ITestResult result)
    {
        WebDriver driver=null;
        try {
            driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
        String Testcasename=result.getMethod().getMethodName();
        try {
            getScreenshoot(Testcasename,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTestSkipped(ITestResult result)
    {

         }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result)
    {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result)
    {

    }

    @Override
    public void onStart(ITestContext context)
    {

    }

    @Override
    public void onFinish(ITestContext context)
    {

    }
}
