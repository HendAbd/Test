package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import java.util.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BrowserStackHomePage {
    WebDriver driver;
    // By Header=By.xpath("//h1");
    @FindBy(xpath="//h1")
    WebElement  Header;


   // By getStarted=By.xpath("//*[@id='signupModalButton']");
   @FindBy(xpath="//*[@id='signupModalButton']")
   WebElement  getStarted;

    public BrowserStackHomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    public void clickHeader()
    {

      //  System.out.println("Home page heading : " +driver.findElement(Header).getText());
        System.out.println("Home page heading : " +Header.getText());
    }
    public void clickSignButton()
    {

       // driver.findElement(getStarted).click();
        getStarted.click();

    }
}
