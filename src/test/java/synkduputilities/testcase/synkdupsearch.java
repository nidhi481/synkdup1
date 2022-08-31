package synkduputilities.testcase;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class synkdupsearch extends baseclass {
	public void pageopen() throws InterruptedException, IOException {

		driver.get(baseurl);
		driver.manage().window().maximize();
		Thread.sleep(2000);
		logger1.log(Status.INFO, " click on find job link present on header");
		driver.findElement(By.xpath("//a[text()='Find Jobs']")).click();
		driver.manage().window().maximize();
		Thread.sleep(2000);
		captureScreen(driver, "test1");
	}

	public void title() throws InterruptedException, IOException {
		logger1.log(Status.INFO, " enter any character in title box dropdown list should be open");
		driver.findElement(By.xpath("//*[@id='companyVal']")).sendKeys("amaz");
		Thread.sleep(3000);
		List<WebElement> companylist = driver.findElements(By.xpath("//*[@id='companyField']/li"));
		System.out.println(companylist.size());
		for (WebElement webElement : companylist) {
			if (webElement.getText().equalsIgnoreCase("Amazon")) {
				webElement.click();
			}

		}
		logger1.log(Status.INFO, " click on find job button");
		driver.findElement(By.xpath("//*[@value='Find Jobs']")).click();

		captureScreen(driver, "test2");
	}

	public void location() throws InterruptedException, IOException {
		logger1.log(Status.INFO, " enter any character in location box dropdown list should be open");
		driver.findElement(By.xpath("//*[@name='loc']")).sendKeys("new");
		Thread.sleep(3000);
		List<WebElement> locationlist = driver.findElements(By.xpath("//*[@id='stateField']/li"));
		System.out.println(locationlist.size());
		for (WebElement webElement : locationlist) {
			if (webElement.getText().equalsIgnoreCase("New Albany, IN")) {
				webElement.click();
				Thread.sleep(2000);
			}

		}
		Thread.sleep(2000);
		logger1.log(Status.INFO, " click on find job button");
		driver.findElement(By.xpath("//*[@value='Find Jobs']")).click();

		captureScreen(driver, "test3");
		Thread.sleep(2000);
		logger1.log(Status.INFO, " Scroll the page click on the 2nd page");
		WebElement k1 = driver.findElement(By.xpath("//i[@class='fas fa-chevron-right']"));
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].scrollIntoView();", k1);
		Thread.sleep(2000);
		jse.executeScript("arguments[0].click()", k1);
		captureScreen(driver, "test4");
		Thread.sleep(2000);

	}
}
