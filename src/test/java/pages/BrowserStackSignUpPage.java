package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackSignUpPage {
    WebDriver driver;
    //By Header = By.xpath("//h1");
    //By userName = By.xpath("//*[@id='user_full_name']");
    @FindBy(xpath="//*[@id='user_full_name']")
    WebElement userName;

   // By businessEmail = By.xpath("//*[@id='user_email_login']");
   @FindBy(xpath="//*[@id='user_email_login']")
   WebElement businessEmail;


   // By password = By.xpath("//*[@id='user_password']");
   @FindBy(xpath="//*[@id='user_password']")
   WebElement password;

    public BrowserStackSignUpPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void userNameClick(String arg1)
    {

        //driver.findElement(userName).sendKeys(arg1);
        userName.sendKeys(arg1);
    }
    public void businessEmailClick(String arg1)
    {

        //driver.findElement(businessEmail).sendKeys(arg1);
        businessEmail.sendKeys(arg1);
    }

    public void passwordClick(String arg1)
    {

        //driver.findElement(password).sendKeys(arg1);
        password.sendKeys(arg1);
    }

}
