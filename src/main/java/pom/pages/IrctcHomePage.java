package pom.pages;

import wrappers.GenericWrappers;

public class IrctcHomePage extends GenericWrappers{
	
	public IrctcHomePage clickOkInTheAlert_irctcHome(){
		clickByXpath("//button[contains(text(),'OK')]");
		return this;
		
	}
	public IrctcRegistrationPage clickRegisterButton_irctcHome() {
		clickByXpath(".//a[@aria-label='Click here to register your account with I.R.C.T.C.']");
		return new IrctcRegistrationPage();
	}
	public IrctcHomePage mouseOverOnHolidays_irctcHome() {
		moveToElementByXpath("//a[@aria-label='Menu Holiday']");
		return this;
		
	}
	public IrctcHomePage mouseOverOnStays_irctcHome() {
		moveToElementByXpath("(//span[text()='Stays'])[1]");
		return this;
	}
	public IrctcAccommidationsPage clickOnLounge_irctcHome() {
		clickByXpath("(//span[text()='Lounge'])[1]");
		switchToLastWindow();
		return new IrctcAccommidationsPage();
	}
	public IrctcHomePage mouseOverOnTrains_irctcHome() {
		clickByXpath("//a[@aria-label='Menu Train']//strong[contains(text(),'TRAINS')]");
		return this;
	}
	public IrctcFtrTrainBookingHomepage clickOnTrainBooking_irctcHome() {
		clickByXpath("//a[@aria-label='Sub Menu of Train, FTR Coach or Train Booking. Website will be opened in new tab']//span[@class='list_text']");
		return new IrctcFtrTrainBookingHomepage();
	}
	
}
