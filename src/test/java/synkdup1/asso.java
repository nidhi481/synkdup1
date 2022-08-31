package synkdup1;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class asso {

	public static void main(String[] args) throws Throwable {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\lxman\\Desktop\\selenium-configuration\\chromedriver_win32\\chromedriver100.exe");
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor jse = (JavascriptExecutor) driver;

		driver.get("https://beta.synkdup.com/affiliate-program/");
		System.out.println(driver.getTitle());
		driver.manage().window().maximize();
		Thread.sleep(2000);
		Boolean k = driver.findElement(By.xpath("(//*[@rel = 'nofollow'])[1]")).isDisplayed();
		System.out.print("logo is visible--->" + k);
		driver.findElement(By.xpath("(//*[@rel='nofollow'])[2]")).click();
		Thread.sleep(2000);
		driver.navigate().back();

	}
}
