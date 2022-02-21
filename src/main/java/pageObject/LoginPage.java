package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
   public WebDriver driver;

 public LoginPage(WebDriver driver)
   {
      this.driver=driver;
   }
    By email= By.cssSelector("input[type='email']");
    By password=By.cssSelector("input[id='user_password']");
    By login=By.cssSelector("input[value='Log In']");

    public WebElement getEmailID()
    {
        return driver.findElement(email);
    }

    public WebElement getPassword()
    {
        return driver.findElement(password);
    }

    public WebElement getLoginButton()
    {
        return driver.findElement(login);
    }

}
