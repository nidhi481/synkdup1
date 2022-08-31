package synkduputilities.testcase;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class synkdupassociate extends baseclass {

	public void pageopen() throws InterruptedException, IOException {

		driver.get(baseurl);
		WebElement p = driver.findElement(
				By.xpath("//a[@class='px-4 py-2 btn-second d-inline-block rounded-3 semi-bold hover-state']"));
		jse.executeScript("arguments[0].scrollIntoView();", p);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click();", p);
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
				logger1.log(Status.INFO, " associate page open");
				driver.manage().window().maximize();
				Thread.sleep(2000);
			}

		}
		captureScreen(driver, "test6");
	}

	public void logo() throws IOException {

		Boolean k1 = driver.findElement(By.xpath("(//*[@rel = 'nofollow'])[1]")).isDisplayed();
		logger1.log(Status.INFO, " logo is displaying");
		System.out.print("logo is visible--->" + k1);
		captureScreen(driver, "test");

	}

	public void findjob() throws InterruptedException, IOException {
		logger1.log(Status.INFO, " Click on find job link present on header");
		driver.findElement(By.xpath("(//*[@rel='nofollow'])[2]")).click();
		captureScreen(driver, "test1");

		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		logger1.log(Status.PASS, " find job link is clickable and search page open");

	}

	public void login() throws InterruptedException, IOException {

		logger1.log(Status.INFO, " Click on Login link present on header");
		driver.findElement(By.xpath("//a[@class='px-2 pb-0 py-2 semi-bold']")).click();
		captureScreen(driver, "test2");

		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
		logger1.log(Status.PASS, " login link is clickable and login page open");

	}

	public void signup() throws InterruptedException, IOException {
		logger1.log(Status.INFO, " Click on signup button present on header");
		driver.findElement(By.xpath("//a[text()='Signup']")).click();
		captureScreen(driver, "test3");

		Thread.sleep(2000);

		driver.navigate().back();
		Thread.sleep(2000);
		logger1.log(Status.PASS, " signup button link is clickable and signup  page open");

	}

	public void joinus() throws InterruptedException, IOException {
		logger1.log(Status.INFO, " Click on join us button ");
		WebElement k = driver.findElement(By.xpath(
				"//a[@class='d-none d-md-block px-5 px-mb-4 py-2 btn-first bg-white txt-blue  semi-bold rounded-3 fs-4']"));

		jse.executeScript("arguments[0].scrollIntoView();", k);
		jse.executeScript("arguments[0].click();", k);
		logger1.log(Status.INFO, " login page opem ");

		driver.findElement(By.name("email")).sendKeys("nidhi.goyal@tutree.com");
		logger1.log(Status.INFO, " enter  valid email id ");

		driver.findElement(By.id("exampleInputPassword1")).sendKeys("nidhi1234");
		logger1.log(Status.INFO, " enter vaild  password");

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		logger1.log(Status.INFO, " click on login button");
		captureScreen(driver, "test4");

		driver.findElement(By.xpath("(//span[@class='px-2 active-link'])")).click();
		WebElement p1 = driver.findElement(By.xpath("(//a[text()='Logout'])"));
		jse.executeScript("arguments[0].click();", p1);

	}
	/*
	 * 
	 * public void theseoppor() throws InterruptedException, IOException {
	 * 
	 * logger1.log(Status.INFO, " Click on these opportunities link"); WebElement p
	 * = driver.findElement( By.
	 * xpath("//a[@class='px-4 py-2 btn-second d-inline-block rounded-3 semi-bold hover-state']"
	 * )); jse.executeScript("arguments[0].scrollIntoView();", p);
	 * Thread.sleep(2000); jse.executeScript("arguments[0].click();", p);
	 * driver.findElement(By.xpath("(//a[text()='these opportunities.'])[1]")).click
	 * (); captureScreen(driver, "test7");
	 * 
	 * Thread.sleep(2000); logger1.log(Status.PASS, "  link is clickable"); }
	 * 
	 * public void signuplink() throws InterruptedException, IOException {
	 * 
	 * logger1.log(Status.INFO, " Click on signup link");
	 * driver.findElement(By.xpath("(//a[text()='sign up'])[1]")).click();
	 * captureScreen(driver, "test8");
	 * 
	 * Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);
	 * logger1.log(Status.PASS, "  link is clickable ang login page open"); }
	 * 
	 * public void herelink() throws InterruptedException, IOException {
	 * 
	 * logger1.log(Status.INFO, " Click on here link");
	 * driver.findElement(By.xpath("//a[text()='here.']")).click();
	 * captureScreen(driver, "test9");
	 * 
	 * Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);
	 * logger1.log(Status.PASS, "  link is clickable ang login page open"); }
	 * 
	 * public void getstart() throws InterruptedException, IOException {
	 * 
	 * logger1.log(Status.INFO, " Click on getstarted link");
	 * driver.findElement(By.xpath("//a[text()='get started.']")).click();
	 * captureScreen(driver, "test10");
	 * 
	 * Thread.sleep(2000); driver.navigate().back(); Thread.sleep(2000);
	 * logger1.log(Status.PASS, "  link is clickable ang login page open"); }
	 */
}
