package synkdup1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class registerpage {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static void main(String[] args) throws IOException, InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver104.exe");
		htmlReporter = new ExtentHtmlReporter("C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\reports\\report1.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("synkdup register page test");
		WebDriver driver = new ChromeDriver();

		Thread.sleep(2000);
		String filepath = "C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\excelfile\\file2.xlsx";
		File src = new File(filepath);
		FileInputStream file = new FileInputStream(src);

		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet1 = workbook.getSheetAt(0);
		int noofrows = sheet1.getLastRowNum() - sheet1.getFirstRowNum();
		// int column = sheet1.getRow(0).getLastCellNum();
		for (int row = 1; row <= noofrows; row++) {

			String finame = sheet1.getRow(row).getCell(2).getStringCellValue();
			String lname = sheet1.getRow(row).getCell(3).getStringCellValue();

			String emailid = sheet1.getRow(row).getCell(4).getStringCellValue();
			String phone = sheet1.getRow(row).getCell(5).getStringCellValue();
			String pass = sheet1.getRow(row).getCell(6).getStringCellValue();
			String cpass = sheet1.getRow(row).getCell(7).getStringCellValue();
			driver.get("https://beta.synkdup.com/user/register/jobseeker");
			logger.log(Status.INFO, "register page  Open");
			driver.manage().window().maximize();

			driver.findElement(By.id("fname")).sendKeys(finame);
			logger.log(Status.INFO, "enter first name");
			driver.findElement(By.id("lname")).sendKeys(lname);
			logger.log(Status.INFO, "enter last name");
			driver.findElement(By.id("email-address")).sendKeys(emailid);
			logger.log(Status.INFO, "enter email id");
			driver.findElement(By.id("phoneno")).sendKeys(phone);
			logger.log(Status.INFO, "enter phone number");
			driver.findElement(By.id("password")).sendKeys(pass);
			logger.log(Status.INFO, "enter password");
			driver.findElement(By.id("confirm_password")).sendKeys(cpass);
			logger.log(Status.INFO, "enter confirm password");
			driver.findElement(By.xpath("//input[@name='submit']")).click();
			logger.log(Status.INFO, "click on create an account");
			Thread.sleep(2000);
			XSSFCell cell1 = sheet1.getRow(row).createCell(8);
			XSSFCell cell2 = sheet1.getRow(row).createCell(9);
			if (driver.getCurrentUrl().equals("https://beta.synkdup.com/search")) {

				logger.log(Status.PASS, "registerd successfully with valid credentials");
				logger.log(Status.PASS, "TC_" + row + "  passed");
				//cell1.setCellValue("Registered successfully");
				//cell2.setCellValue("testcase pass");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src1 = ts.getScreenshotAs(OutputType.FILE);

				String path = System.getProperty("user.dir") + "./screenshots/screenshot" + row + "register.png";
				File dest = new File(path);
				FileUtils.copyFile(src1, dest);
				logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(path));

				driver.findElement(By.xpath("(//*[@rel='nofollow'])[4]")).click();
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//a[@rel='nofollow'])[6]")).click();

			} else {
				logger.log(Status.PASS, "Registration failed");
				logger.log(Status.PASS, "TC_" + row + "   passed");

				//cell1.setCellValue("Register failed");
				//cell1.setCellValue("Registered successfully");
				//cell2.setCellValue("testcase pass");
				TakesScreenshot ts = (TakesScreenshot) driver;
				File src1 = ts.getScreenshotAs(OutputType.FILE);
				String path = System.getProperty("user.dir") + "./screenshots/screenshot" + row + "register.png";
				File dest = new File(path);
				FileUtils.copyFile(src1, dest);
				logger.pass("Screenshot is below:" + logger.addScreenCaptureFromPath(path));

			}
			FileOutputStream outputStream = new FileOutputStream(
					"C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\excelfile\\file2.xlsx");
			workbook.write(outputStream);

			Thread.sleep(2000);

			extent.flush();

		}
	}

}
