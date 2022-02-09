package utils;
import org.w3c.dom.UserDataHandler;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public abstract class Reporter {
	ExtentReports report;
	static ExtentTest test;
	public String testCaseNumber,  testcaseDescripton,  category,  author;
	public void startReport(String path) {
		report = new ExtentReports(path,false);
	}

	public void startTest_Report(String testCaseNo, String testDescripton, String author, String category) {
		test = report.startTest(testCaseNo, testDescripton);
		test.assignAuthor(author);
		test.assignCategory(category);
	}
	
	public abstract long takeSnap();

	public void logTestStatus_report(String status, String message, boolean flag) {
		
		if(flag) {long name =takeSnap();
		if (status.equalsIgnoreCase("Pass")) {
			test.log(LogStatus.PASS, message+test.addScreenCapture("../screenshots/"+name+".jpeg"));
		} else if (status.equalsIgnoreCase("Fail")) {
			test.log(LogStatus.FAIL, message+test.addScreenCapture("../screenshots/"+name+".jpeg"));
		} else if (status.equalsIgnoreCase("Waraning")) {
			test.log(LogStatus.WARNING, message+test.addScreenCapture("../screenshots/"+name+".jpeg"));
		}else if (status.equalsIgnoreCase("Info")) {
			test.log(LogStatus.INFO, message+test.addScreenCapture("../screenshots/"+name+".jpeg"));
		}
		}else {if (status.equalsIgnoreCase("Pass")) {
			test.log(LogStatus.PASS, message);
		} else if (status.equalsIgnoreCase("Fail")) {
			test.log(LogStatus.FAIL, message);
		} else if (status.equalsIgnoreCase("Waraning")) {
			test.log(LogStatus.WARNING, message);
		}else if (status.equalsIgnoreCase("Info")) {
			test.log(LogStatus.INFO, message);
		}
			
		}
	}

	public void endTest() {
		report.endTest(test);
	}
	
	public void endReport() {
		report.flush();
	}

}
