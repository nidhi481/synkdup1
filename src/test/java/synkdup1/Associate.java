package synkdup1;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Associate {
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest logger;

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver100.exe");
		htmlReporter = new ExtentHtmlReporter(
				"C:\\Users\\lxman\\eclipse-workspace\\synkdup1\\reports\\associatereport.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		logger = extent.createTest("synkdup Associate  page Test");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get("https://beta.synkdup.com/");
		driver.manage().window().maximize();
		Thread.sleep(2000);

		WebElement p = driver.findElement(
				By.xpath("//a[@class='px-4 py-2 btn-second d-inline-block rounded-3 semi-bold hover-state']"));
		jse.executeScript("arguments[0].scrollIntoView();", p);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", p);
		logger.log(Status.INFO, " synkdup Associate page open");
		Thread.sleep(5000);
		Boolean k1 = driver.findElement(By.xpath("(//*[@rel = 'nofollow'])[1]")).isDisplayed();
		System.out.print("logo is visible--->" + k1);
		logger.log(Status.PASS, "Logo is visible--->" + k1);

		String parent = driver.getWindowHandle();

		Set<String> s = driver.getWindowHandles();

		// Now iterate using Iterator
		Iterator<String> I1 = s.iterator();

		while (I1.hasNext()) {

			String child_window = I1.next();

			if (!parent.equals(child_window)) {
				driver.switchTo().window(child_window);

				driver.switchTo().window(child_window).getTitle();
				String url = driver.getCurrentUrl();

				// switch to the parent window
				// driver.switchTo().window(parent);
				driver.get(url);
				Thread.sleep(2000);
				driver.findElement(By.xpath("(//*[@rel='nofollow'])[2]")).click();

				Thread.sleep(2000);
				logger.log(Status.INFO, " Click on find job link present on header");

				driver.navigate().back();
				Thread.sleep(2000);
				logger.log(Status.PASS, " find job link is clickable and search page open");

				driver.findElement(By.xpath("//a[@class='px-2 pb-0 py-2 semi-bold']")).click();
				logger.log(Status.INFO, " Click on Login link present on header");
				Thread.sleep(2000);

				driver.navigate().back();
				Thread.sleep(2000);
				logger.log(Status.PASS, " login link is clickable and login page open");
				driver.findElement(By.xpath("//a[text()='Signup']")).click();
				logger.log(Status.INFO, " Click on signup button present on header");
				Thread.sleep(2000);

				driver.navigate().back();
				Thread.sleep(2000);
				logger.log(Status.PASS, " signup button is clickable and signup  page open");

				WebElement k = driver.findElement(By.xpath(
						"//a[@class='d-none d-md-block px-5 px-mb-4 py-2 btn-first bg-white txt-blue  semi-bold rounded-3 fs-4']"));
				logger.log(Status.INFO, " Click on join us button ");
				jse.executeScript("arguments[0].scrollIntoView();", k);
				jse.executeScript("arguments[0].click();", k);
				logger.log(Status.INFO, " login page opem ");

				driver.findElement(By.name("email")).sendKeys("nidhi.goyal@tutree.com");
				logger.log(Status.INFO, " enter  valid email id ");

				driver.findElement(By.id("exampleInputPassword1")).sendKeys("nidhi1234");
				logger.log(Status.INFO, " enter vaild  password");

				Thread.sleep(2000);
				driver.findElement(By.xpath("//button[@type='submit']")).click();
				logger.log(Status.INFO, " click on login button");

				driver.findElement(By.xpath("(//span[@class='px-2 active-link'])")).click();
				WebElement p1 = driver.findElement(By.xpath("(//a[text()='Logout'])"));
				jse.executeScript("arguments[0].click();", p1);
				extent.flush();

			}
		}

	}

}
