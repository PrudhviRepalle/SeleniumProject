package wrappers;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

public class ProjectWrappers extends GenericWrappers {
	
	@BeforeSuite
	public void initReport(){
		startReport("./reports/Report.html");
	}
	
	@BeforeTest
	public void beforeTest() {
		loadProperties();
		System.out.println(prop);
	}
	
	
	@BeforeMethod
	public void openingBrowser() {
		startTest_Report(testCaseNumber, testcaseDescripton, category, author);
		invokeApp(prop.getProperty("browser"), prop.getProperty("URL"),false);
		
		
	}
	@AfterMethod
	public void closingBroswer() {
		closeAllBrowsers();
	}
	
	@AfterClass
	public void endTestMethod() {
		endTest();
	}
	@AfterSuite
	public void endTheReport() {
		endReport();
	}
	
	

}
