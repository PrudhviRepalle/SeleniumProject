package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.IrctcHomePage;
import wrappers.ProjectWrappers;

public class Tc_003 extends ProjectWrappers {
	@BeforeClass
	public void assignValues() {
		testCaseNumber = "TC003";
		testcaseDescripton = " FTR Signup";
		category = "Regression";
		author = "Prudhvi";
	}
	
	@Test
	public void irctcFtrSignupPage() {
		IrctcHomePage homePage = new IrctcHomePage();
		homePage.clickOkInTheAlert_irctcHome()
		.mouseOverOnTrains_irctcHome()
		.clickOnTrainBooking_irctcHome()
		.clickOnNewUserSignupLink_ftrhome()
		.enterNewuserid_ftrreg("Prudhvi3")
		.enterNewPassword_ftrreg("testing12245")
		.enterConfirmPassword_ftrreg("testing12245").
		selectSecurityQuestion_ftrreg("bike")
		.enterSecurityAnswer_ftrreg("yamaha")
		.selectDOB_ftrreg("october","1991")
		.selectGender_ftrreg("male")
		.selectMterialStatus_ftrreg("married")
		.enterMailId_ftrreg("prudhvi.rep@gmail.com")
		.selectOccupation_ftrreg("private")
		.enterFirstNameasPerPan_ftrreg("Prudhvi")
		.enterMiddleNameasPerPan_ftrreg("Middle")
		.enterLastNameasPerPan_ftrreg("Repalle")
		.selectNationality_ftrreg("India")
		.enterDoorNoAddress_ftrreg("771")
		.enterStreetName_ftrreg("papireddy")
		.enterAreaLocality_ftrreg("lingampalli")
		.selectCountry_ftrreg("india")
		.enterMobileNumber_ftrreg("8978855016")
		.enterPincode_ftrreg("534211")
		.sendTabKeys_ftrreg();
		
	}

}
