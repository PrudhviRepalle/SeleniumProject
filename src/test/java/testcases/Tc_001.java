package testcases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pom.pages.IrctcHomePage;
import pom.pages.IrctcRegistrationPage;
import wrappers.ProjectWrappers;

public class Tc_001 extends ProjectWrappers {
	
	@BeforeClass
	public void assignValues() {
		testCaseNumber = "TC001";
		testcaseDescripton = "IRCTC Registration";
		category = "Regression";
		author = "Prudhvi";
	}
	
	
	@Test
	public void irctcRegistration() {
 		IrctcHomePage homePage = new IrctcHomePage();
		homePage.clickOkInTheAlert_irctcHome()
		.clickRegisterButton_irctcHome()
		.enterUserName_irctcReg("PRudhvi12345")
		.enterPassword_irctcReg("Prudhvi12345678")
		.enterconfPassword_irctcReg("Prudhvi12345678")
		.selectPrefferedLaguage_irctcReg("English")
		.selectSequrityQuestion_irctcReg("Who was your Childhood hero?")
		.enterSequrityAnswerString_irctcReg("Spidy")
		.clickonContinueBasicDetails_irctcReg()
		.enterFirstNamePersonal_irctcReg("Prudhvi")
		.enterMiddleNamePersonal_irctcReg("middle")
		.enterLastNamePersonal_irctcReg("Repalle")
		.selectOccupation_irctcReg("PRIVATE")
		.selectDateOfBirth_irctcReg("October", "1991", "29") 
		.SelectMaterialStatus_irctcReg("married")
		.selectCountry_irctcReg("India")
		.selectGender_irctcReg("Male")
		.enterMail_irctcReg("random.gen@gmail.com")
		.enterMobileNumber_irctcReg("8978855011")
		.selectNationality_irctcReg("India")
		.clickonContinuePersonalDetails_irctcReg()
		.enterDoorNoAddress_irctcReg("TESTBLOCK:302")
		.enterStreetAddress_irctcReg("teststreet")
		.enterAreadAddress_irctcReg("abcdarea")
		.enterPincodeAddress_irctcReg("534211")		
		.selectCityAddress_irctcReg("West Godavari")
		.selectPostalOfficeAddress_irctcReg("Tanuku Old Town S.O")
		.enterPhoneNumberAddress_irctcReg("8978855123")
		.clickYesCopyResidenceAddress_irctcReg()
		.clickYesTermconditon_irctcpage();
		
		
		

				
		
		
	}

}
