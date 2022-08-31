package synkdup1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class prac {
	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver104.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://test.synkdup.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//*[text()='Find Jobs'])[1]")).click();
		driver.findElement(By.id("companyVal")).sendKeys("Amaz");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='companyField']/li[3]")).click();
		driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
		Thread.sleep(2000);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.findElement(By.xpath("(//*[text()='Apply Now'])[11]")).click();
		// Thread.sleep(2000);

//		
		System.out.println("Passed");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//input[@id='fname']")).sendKeys("text");

		/*
		 * WebDriverWait w = (new WebDriverWait(driver, 7));
		 * w.until(ExpectedConditions.elementToBeClickable(By.id("fname")));
		 * 
		 * WebElement uid = driver.findElement(By.id("fname"));
		 * 
		 * js.executeScript("arguments[0].value='ishumathur';", uid);
		 * 
		 * driver.findElement(By.id("fname")).clear();
		 * driver.findElement(By.id("fname")).sendKeys("Ishu");
		 * driver.findElement(By.id("lname")).clear();
		 * driver.findElement(By.id("lname")).sendKeys("Mathur");
		 * driver.findElement(By.id("phoneno")).clear();
		 * driver.findElement(By.id("phoneno")).sendKeys("7862787878");
		 * driver.findElement(By.id("email-address")).clear();
		 * driver.findElement(By.id("email-address")).sendKeys("amankumar999@gmail.com")
		 * ; driver.findElement(By.id("password2")).clear();
		 * driver.findElement(By.id("password2")).sendKeys("Ishu@1234");
		 * driver.findElement(By.id("confirm_password1")).clear();
		 * driver.findElement(By.id("confirm_password1")).sendKeys("Ishu@1234");
		 * driver.findElement(By.xpath("(//*[@name='submit'])[2]")).click();
		 */
		driver.close();

	}
}
