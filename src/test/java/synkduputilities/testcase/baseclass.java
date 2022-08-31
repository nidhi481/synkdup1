package synkduputilities.testcase;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import synkduputilities.readconfig;

public class baseclass {

	readconfig rconfig = new readconfig();

	public String baseurl = rconfig.getApplicationURL();
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger1;
	public static String ScreenShotName;
	JavascriptExecutor jse = (JavascriptExecutor) driver;

	@BeforeSuite
	public void setup() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver102.exe");
		driver = new ChromeDriver();
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\reports\\associatereport.html");

		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}

	@AfterSuite
	public void teardown() {
		extent.flush();
		driver.quit();
	}

	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + tname + ".png";
		File target = new File(path);
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
		logger1.pass("Screenshot is below:" + logger1.addScreenCaptureFromPath(path));

	}

}