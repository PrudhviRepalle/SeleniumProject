package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.IrctcHomePage;
import wrappers.ProjectWrappers;

//test case can't validate due to GST validation issue in irctc page
public class Tc_005 extends ProjectWrappers{
	
	@BeforeClass
	public void assignValues() {
		testCaseNumber = "TC005";
		testcaseDescripton = "Accommodations - GST Validation";
		category = "Regression";
		author = "Prudhvi";
	}
	
	@Test
	public void gstValidation() {
		IrctcHomePage homePage = new IrctcHomePage();
		homePage.clickOkInTheAlert_irctcHome()
		.mouseOverOnHolidays_irctcHome()
		.mouseOverOnStays_irctcHome()
		.clickOnLounge_irctcHome()
		.selectStationName_accomid("NEW DELHI")
		.selectLounge_accomid("IRCTC EXECUTIVE LOUNGE, PF-1")
		.selectNoOfPersons_accomid("2")
		.selectCheckInDate_accomid("20")
		.selectCheckInTime_accomid("11:00")
		.selectDurationOfHours_accomid("13:00")
		.clickBookButton_accomid()
		.clickGuestLogin_accomid()
		.enterMailId_accomid("prudhvi.res@gmail.com")
		.clickLoginButton_accomid()
		.selectGstYesorNo_accpass("Yes")
		.enterGSTrandomNumber_accpass("114njhsg")
		.enterPasanger1Name_accpass("prudhvi")
		.enterPasanger2Age_accpass("30")
		.selectGenderPass1_accpass("male")
		.enterPasanger2Name_accpass("testerfemale")
		.enterPasanger2Age_accpass("29")
		.selectGenderPass2("female")
		.selectState_accpass("Andhra Pradesh")
		.clickOnSubmit_accpass();			
		
	}
}
