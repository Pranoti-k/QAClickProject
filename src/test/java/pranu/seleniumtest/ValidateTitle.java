package pranu.seleniumtest;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

import java.io.IOException;


public class ValidateTitle extends Base{

    public WebDriver driver;
    public static Logger log=LogManager.getLogger(ValidateTitle.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initialiazeDriver();
        log.info("Driver is Initialiazed");
        driver.get(props.getProperty("url"));
        log.info("Navigated to Home Page");
    }
    @Test
    public void validatingTitle() throws IOException {


        LandingPage page=new LandingPage(driver);
        Assert.assertEquals(page.getTitle().getText(),"FEATURED COURSE");
        log.info("Text is successfully validated");


    }

    @AfterTest
    public void tearDown()
    {
        driver.close();
    }


}
