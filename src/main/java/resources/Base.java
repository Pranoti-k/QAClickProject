package resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public WebDriver driver;
    public Properties props;

    public WebDriver initialiazeDriver() throws IOException {
        props=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\Pranoti Kulkarni\\IdeaProjects\\E2EProject\\src\\main\\java\\resources\\data.properties");
        props.load(fis);
       String browsrname= props.getProperty("browser");

System.out.println(browsrname);
       if(browsrname.equals("chrome"))
       {
           System.setProperty("webdriver.chrome.driver","C:\\Users\\Pranoti Kulkarni\\Desktop\\chromedriver.exe");
           driver=new ChromeDriver();
       }

       else if(browsrname.equals("firefox"))
       {
           System.setProperty("webdriver.gecko.driver","C:\\Users\\Pranoti Kulkarni\\Desktop\\PranuTesting\\Selenium WebDriver\\geckodriver.exe");
           driver=new ChromeDriver();
       }

       else if(browsrname.equals("Edge"))
       {
           System.setProperty("webdriver.edge.driver","C:\\Users\\Pranoti Kulkarni\\Desktop\\PranuTesting\\Selenium WebDriver\\msedgedriver.exe");
           driver=new ChromeDriver();
       }


       return driver;
    }
}
