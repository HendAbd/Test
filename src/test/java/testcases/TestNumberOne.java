package testcases;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import library.RunReports;
import library.SelectBrowser;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pages.BrowserStackHomePage;
import pages.BrowserStackSignUpPage;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TestNumberOne {

    WebDriver driver;
    BrowserStackHomePage homePage;
    BrowserStackSignUpPage signPage;

    @BeforeSuiteza
    public void launcheReport() {
        // here you can change the browserycfyjham
    }
    @BeforeTest
    public void browserlauncher() {
        // here you can change the browser
        driver = SelectBrowser.StartBrowser("EdgeExplore");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://www.browserstack.com/");
    }
    @Test(priority = 1)
    public void navigate_to_homepage_click_on_getstarted() throws IOException {
        RunReports.test = RunReports.extent.createTest("verifyTitle", "Test Passed");
        homePage = new BrowserStackHomePage(driver);
        homePage.clickHeader();
        RunReports.takeScreenShot(driver,System.getProperty("user.dir") +"/test-output/img1.jpg");
        RunReports.test.addScreenCaptureFromPath(System.getProperty("user.dir") +"/test-output/img1.png");
        homePage.clickSignButton();
        RunReports.takeScreenShot(driver,System.getProperty("user.dir") +"/test-output/img2.jpg");
        RunReports.test.addScreenCaptureFromPath(System.getProperty("user.dir") +"/test-output/img2.png");
    }
    @Test(priority = 2)
    public void enter_userDetails() throws InterruptedException, IOException {
        signPage = new BrowserStackSignUpPage(driver);
       // signPage.veryHeader();
        signPage.userNameClick("TestUser");
        signPage.businessEmailClick("TestUser@gmail.com");
        signPage.passwordClick("TestUserPassword");
        RunReports.takeScreenShot(driver,System.getProperty("user.dir") +"/test-output/img3.jpg");
        RunReports.test.addScreenCaptureFromPath(System.getProperty("user.dir") +"/test-output/img3.png");


        Thread.sleep(10000);
    }
    @AfterTest
    public void closeBrowser() throws IOException {

        RunReports.tearDown();
        driver.quit();

    }

    @AfterMethod
    public void getResult(ITestResult result)
    {
        if(result.getStatus() == ITestResult.FAILURE)
        {
            RunReports.test.log(Status.FAIL, MarkupHelper.createLabel(result.getName()+" Test case FAILED due to below issues:", ExtentColor.RED));

            RunReports.test.fail(result.getThrowable());
        }
        else if(result.getStatus() == ITestResult.SUCCESS)
        {
            RunReports.test.log(Status.PASS, MarkupHelper.createLabel(result.getName()+" Test Case PASSED", ExtentColor.GREEN));
        }
        else
        {
            RunReports.test.log(Status.SKIP, MarkupHelper.createLabel(result.getName()+" Test Case SKIPPED", ExtentColor.ORANGE));
            RunReports.test.skip(result.getThrowable());
        }
    }



}