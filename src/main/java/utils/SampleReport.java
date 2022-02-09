package utils;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SampleReport {
	
	public static void main(String[] args) {
		
		
		//start report
		ExtentReports report = new ExtentReports("./reports/samplereport.html");
		
		//start test
		ExtentTest test = report.startTest("TC001", "IRCTC Registration");
		test.assignAuthor("Prudhvi");
		test.assignCategory("Regression");
		
		// los test staus
		test.log(LogStatus.PASS, "Browser lauched successfully");
		test.log(LogStatus.WARNING, "Thitle is not matching");
		test.log(LogStatus.FAIL, "The element is not visible");
		report.endTest(test);
		
		ExtentTest test1 = report.startTest("TC001", "IRCTC Registration");
		test1.log(LogStatus.PASS, "Browser lauched successfully");
		test1.log(LogStatus.WARNING, "Thitle is not matching");
		test1.log(LogStatus.FAIL, "The element is not visible");
		
		
		
		//end test
		report.endTest(test1);
		
		//end report
		report.flush();
		
		
		
		
		
		
	}

}
