package synkdup1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class loginpage {

	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver104.exe");
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\reports\\report.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("synkdup Login page Test");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		Thread.sleep(2000);
		String filepath = "C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\excelfile\\file1.xlsx";
		File src = new File(filepath);
		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet1 = workbook.getSheetAt(0);

		int noofrows = sheet1.getLastRowNum();
		for (int row = 1; row <= noofrows; row++) {
			String userid = sheet1.getRow(row).getCell(2).getStringCellValue();
			int column = sheet1.getRow(0).getLastCellNum();

			String password = sheet1.getRow(row).getCell(3).getStringCellValue();

			driver.get("https://beta.synkdup.com/user/login/jobseeker");
			logger.log(Status.INFO, "Login page open");

			driver.findElement(By.name("email")).sendKeys(userid);
			logger.log(Status.INFO, "enter email id");

			driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
			logger.log(Status.INFO, "enter password");

			Thread.sleep(2000);
			driver.findElement(By.xpath("//button[@type='submit']")).click();
			logger.log(Status.INFO, "click on submit button");

			XSSFCell cell1 = sheet1.getRow(row).createCell(4);

			XSSFCell cell2 = sheet1.getRow(row).createCell(5);
			if (driver.getCurrentUrl().equals("https://beta.synkdup.com/user/agent/dashboard")) {
				logger.log(Status.PASS, "login successfully with valid credentials");
				logger.log(Status.PASS, "TC_" + row + "  passed");

				//cell1.setCellValue("login success");
				//cell2.setCellValue("Test case pass");

				TakesScreenshot ts = (TakesScreenshot) driver;
				File src1 = ts.getScreenshotAs(OutputType.FILE);

				String path = System.getProperty("user.dir") + "./screenshots/screenshot" + row + "login.png";
				File dest = new File(path);
				FileUtils.copyFile(src1, dest);
				logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(path));

				JavascriptExecutor jse = (JavascriptExecutor) driver;
				driver.findElement(By.xpath("(//span[@class='px-2 active-link'])")).click();
				WebElement p = driver.findElement(By.xpath("(//a[text()='Logout'])"));
				jse.executeScript("arguments[0].click();", p);

			} else {
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src1 = ts.getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir") + "./screenshots/screenshot" + row + "login.png";
				File dest = new File(path);
				FileUtils.copyFile(src1, dest);
				logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(path));

				logger.log(Status.PASS, "login failed with invalid credentials");
				logger.log(Status.PASS, "TC_" + row + "  passed");
				//cell1.setCellValue("login FAIL");
				//cell2.setCellValue("Test case pass");
			}
			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\excelfile\\file1.xlsx");
			workbook.write(outputStream);

			Thread.sleep(2000);
			extent.flush();

		}
	}
}
