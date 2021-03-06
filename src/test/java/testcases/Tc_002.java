package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.IrctcHomePage;
import wrappers.ProjectWrappers;


public class Tc_002 extends ProjectWrappers{
	
	@BeforeClass
	public void assignValues() {
		testCaseNumber = "TC002";
		testcaseDescripton = "IRCTC Accomidations";
		category = "Regression";
		author = "Prudhvi";
	}
	
	@Test
	
	public void irctcAccommodations() {
		IrctcHomePage homePage = new IrctcHomePage();
		homePage.clickOkInTheAlert_irctcHome()
		.mouseOverOnHolidays_irctcHome()
		.mouseOverOnStays_irctcHome()
		.clickOnLounge_irctcHome()
		.selectStationName_accomid("NEW DELHI")
		.selectLounge_accomid("IRCTC EXECUTIVE LOUNGE, PF-1")
		.selectNoOfPersons_accomid("2")
		.selectCurrentDateAsCheckInDate_accomid("20")
		.selectCheckInTime_accomid("10:00")
		.selectDurationOfHours_accomid("13:00")
		.clickBookButton_accomid()
		.clickGuestLogin_accomid()
		.enterMailId_accomid("prudhvi.res@gmail.com")
		.enterMobileNumber_accomid("8978855016")
		.clickLoginButton_accomid()
		.enterPasanger1Name_accpass("prudhvi")
		.enterPasanger1Age_accpass("30")
		.selectGenderPass1_accpass("Male")
		.enterPasanger2Name_accpass("testerfemale")
		.enterPasanger2Age_accpass("29")
		.selectGenderPass2("Female")
		.selectState_accpass("ANDHRA PRADESH")
		.clickOnSubmit_accpass()
		.verifyTextOfMaild_accsummary("prudhvi.res@gmail.com")
		.verifyTextOfMobileNo_accsummary("8978855000");				
		
}
}