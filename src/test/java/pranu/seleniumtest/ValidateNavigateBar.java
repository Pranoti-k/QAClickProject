package pranu.seleniumtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import resources.Base;

import java.io.IOException;

public class ValidateNavigateBar extends Base{
//WebDriver driver;

    public static Logger log= LogManager.getLogger(ValidateNavigateBar.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver=initialiazeDriver();
        log.info("Driver is successfully initialiazed");
        driver.get(props.getProperty("url"));
        log.info("Succesfully navigated to website");
    }

    @Test
    public void validatingTitle() throws IOException {

log.info("Passing driver to LandingPage class");
        LandingPage page=new LandingPage(driver);
       Assert.assertTrue(page.getNavigationBar().isDisplayed());
       log.info("Navigation Bar is displayed on Home Page");



    }

    @AfterTest
    public void tearDown()
    {
        driver.close();

    }


}
