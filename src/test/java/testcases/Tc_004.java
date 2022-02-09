package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.IrctcHomePage;
import wrappers.ProjectWrappers;

public class Tc_004 extends ProjectWrappers{
	@BeforeClass
	public void assignValues() {
		testCaseNumber = "TC004";
		testcaseDescripton = "Saloon Mandatory Check";
		category = "Regression";
		author = "Prudhvi";
	}
	
	@Test
	
	
	public void saloonMandatoryCheck() {
		IrctcHomePage homePage = new IrctcHomePage();
		homePage.clickOkInTheAlert_irctcHome()
		.mouseOverOnHolidays_irctcHome()
		.mouseOverOnStays_irctcHome()
		.clickOnLounge_irctcHome()
		.clickOnRightMenu_accomid()
		.clickOnCharter_accomid()
		.clickOnEnquiryPage_chart()
		.enterApplicantName_chart("Prudhvi")
		.enterOrganizationName_chart("Honeywell")
		.enterAddress_chart("near water tank")
		.enterMobileNumber_chart("8978855011")
		.enterMailId_chart("prudhvi.repalle111@gmail.com")
		.selectRequestFor_chart()
		.enterOrginCity_chart("delhi")
		.enterDestinationCity_chart("mumbai")
		.enterNoOfCoaches_chart("2")
		.enterNoOfpassengers1stBlock_chart("3")
		.enterNoOfpassengers2ndBlock_chart("3")
		.enterPurposeOfCharter_chart("Testing Purpose")
		.enterAdditonalServiceRequired_chart("not required")
		.clickOnSubmit_chart();//startdate and returndates are pending
		
	}

}
