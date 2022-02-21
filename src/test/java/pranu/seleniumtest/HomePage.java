package pranu.seleniumtest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base{
//WebDriver driver;

    public static Logger log= LogManager.getLogger(HomePage.class.getName());


    @Test(dataProvider = "getData")
    public void basepageNavigation(String username,String password) throws IOException {

        driver=initialiazeDriver();
        log.info("Driver is successfully Initialiazed");
        driver.get(props.getProperty("url"));
        log.info("Url is successfully fetched from properties file");
        LandingPage page=new LandingPage(driver);
        page.getLogin().click();

        LoginPage lp = new LoginPage(driver);
        lp.getEmailID().sendKeys(username);
        lp.getPassword().sendKeys(password);
        log.error("Invalid username or password");
        //System.out.println(text);
        lp.getLoginButton().click();
        driver.close();
        log.info("driver is closed successfully");
    }



    @DataProvider
    public Object[][] getData()
    {
        Object[][] data=new Object[3][2];

        data[0][0]="san.sai2011@gmail.com" ;
        data[0][1]="123abv";
       // data[0][2]="Restricted User";

        data[1][0]="abc@yahoo.com";
        data[1][1]="12345677";
       // data[1][2]="Non Restricted User";
        data[2][0]="pranotik2011@gmail.com";
        data[2][1]="Sandy@3321";

        return data;

    }

   /* @AfterTest
    public void tearDown()
    {
        driver.quit();
    }*/
}


