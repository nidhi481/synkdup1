package synkdupmethod;

import java.io.IOException;

import org.testng.annotations.Test;

import synkduputilities.testcase.baseclass;
import synkduputilities.testcase.synkdupsearch;

public class search extends baseclass {
	@Test
	public void run1() throws IOException, Exception {
		logger1 = extent.createTest("Search  page open");
		synkdupsearch a = new synkdupsearch();
		a.pageopen();
	}

	@Test

	public void run2() throws IOException, Exception {
		logger1 = extent.createTest("To  verify enter the title name and click on  find job button ");
		synkdupsearch a = new synkdupsearch();
		a.title();
	}

	@Test

	public void run3() throws IOException, Exception {
		logger1 = extent.createTest("To  verify enter the title name and click on  find job button ");
		synkdupsearch a = new synkdupsearch();
		a.location();
	}

}
