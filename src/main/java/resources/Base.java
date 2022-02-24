package resources;

import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.apache.logging.log4j.core.config.plugins.util.ResolverUtil;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
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
        FileInputStream fis=new FileInputStream("C:\\Users\\Pranoti Kulkarni\\IdeaProjects\\QAClickProject\\src\\main\\java\\resources\\data.properties");
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

    public void getScreenshoot(String Testcasename,WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
      // String destination = System.getProperty("")+"\\reports\\"+Testcasename+".png";
       FileHandler.copy(source,new File("C:\\Users\\Pranoti Kulkarni\\IdeaProjects\\QAClickProject"+Testcasename+".png"));
    }
}
