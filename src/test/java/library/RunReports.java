package library;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;

public class RunReports {
    private static ExtentHtmlReporter htmlReporter;
    public static ExtentReports extent;
    public static ExtentTest test;




    public static void setUpReport()
    {
        //create the HtmlReporter in that path by the name of  MyOwnReport.html
        htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") +"/test-output/GoogleReport.html");
        extent = new ExtentReports();

        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Host Name", "Hend.home-server.local");
        extent.setSystemInfo("Environment", "Jenkins test ");
        extent.setSystemInfo("User Name", "Hend Omar");
        htmlReporter.config().setChartVisibilityOnOpen(true);
        htmlReporter.config().setDocumentTitle("AutomationTesting  report");
        htmlReporter.config().setReportName(" Report");
        htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);
        htmlReporter.config().setTheme(Theme.DARK);
    }

    public static void takeScreenShot(WebDriver driver, String path) throws IOException {
        File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File(path));


    }


    public static void tearDown() throws IOException {
        test.addScreenCaptureFromPath(System.getProperty("user.dir") +"/test-output/test.png");
        extent.flush();
    }
}
