package pom.pages;

import wrappers.GenericWrappers;

public class IrctcFtrTrainBookingHomepage extends GenericWrappers {
	
	public IrctcFtrRegistrationSignUpPage clickOnNewUserSignupLink_ftrhome() {
		clickByXpath("//a[contains(text(),'New User? Signup')]");
		switchToLastWindow();
		return new IrctcFtrRegistrationSignUpPage();
	}
	

}
