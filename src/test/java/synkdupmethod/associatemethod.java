package synkdupmethod;

import java.io.IOException;

import org.testng.annotations.Test;

import synkduputilities.testcase.baseclass;
import synkduputilities.testcase.synkdupassociate;

public class associatemethod extends baseclass {
	@Test
	public void run1() throws IOException, Exception {
		logger1 = extent.createTest("Associate page open");
		synkdupassociate a = new synkdupassociate();
		a.pageopen();
	}

	@Test
	public void run2() throws IOException, Exception {
		logger1 = extent.createTest("To verify Logo displayed or not ");
		synkdupassociate a = new synkdupassociate();
		a.logo();
	}

	@Test
	public void run3() throws IOException, Exception {
		logger1 = extent.createTest("To verify  find job link is clickable");
		synkdupassociate a = new synkdupassociate();

		a.findjob();
	}

	@Test
	public void run4() throws IOException, Exception {
		logger1 = extent.createTest("to verify login link is clickable");
		synkdupassociate a = new synkdupassociate();

		a.login();
	}

	@Test
	public void run5() throws IOException, Exception {
		logger1 = extent.createTest("To verify signup link is clickable");
		synkdupassociate a = new synkdupassociate();
		a.signup();
	}

	@Test
	public void run6() throws IOException, Exception {
		logger1 = extent.createTest("To verify join us button");
		synkdupassociate a = new synkdupassociate();
		a.joinus();
	}
	/*
	 * @Test public void run7() throws IOException, Exception { logger1 =
	 * extent.createTest("To verify these opportunity link"); synkdupassociate a =
	 * new synkdupassociate(); a.theseoppor(); }
	 * 
	 * @Test public void run8() throws IOException, Exception { logger1 =
	 * extent.createTest("To verify signup link"); synkdupassociate a = new
	 * synkdupassociate(); a.signuplink(); }
	 * 
	 * @Test public void run9() throws IOException, Exception { logger1 =
	 * extent.createTest("To verify here link"); synkdupassociate a = new
	 * synkdupassociate(); a.herelink(); }
	 * 
	 * @Test public void run10() throws IOException, Exception { logger1 =
	 * extent.createTest("To verify getstarted link"); synkdupassociate a = new
	 * synkdupassociate(); a.getstart(); }
	 */
}
