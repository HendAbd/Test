package library;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;

import java.io.IOException;


public class SelectBrowser {
    static WebDriver driver;
    private static ExtentHtmlReporter htmlReporter;
    private static ExtentReports extent;
    private static ExtentTest test;

    public static WebDriver StartBrowser(String browsername)
    {
        // ---If the browser is Firefox----
        if(browsername.equalsIgnoreCase("Firefox"))
        {
            // Set the path for geckodriver.exe
            System.setProperty("webdriver.gecko.driver",System.getProperty("user.dir") +"/geckodriver.exe");
            driver = new FirefoxDriver();
        }
        //---- If the browser is Chrome--
        else if(browsername.equalsIgnoreCase("Chrome"))
        {
            // Set the path for chromedriver.exe
            System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir") +"/chromedriver.exe");
            driver = new ChromeDriver();
        }
        // ----If the browser is  EdgeIE----
        else if(browsername.equalsIgnoreCase("EdgeExplore"))
        {
            // Set the path for IEdriver

            System.setProperty("webdriver.edge.driver",System.getProperty("user.dir") +"/msedgedriver.exe");
            // Instantiate a EdgeDriverclass.
            EdgeOptions options = new EdgeOptions();
            driver = new EdgeDriver(options);
        }
        driver.manage().window().maximize();
        return driver;
    }


}

