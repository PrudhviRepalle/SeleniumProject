package pom.pages;

import wrappers.GenericWrappers;

public class IrctcAccommidationsPage extends GenericWrappers{
	
	public  IrctcAccommidationsPage selectStationName_accomid(String citytext)
	{
		selectVisibileTextByXpath("//select[@name='city']",citytext);
		return this;
	}
	
	public IrctcAccommidationsPage selectLounge_accomid(String platformtext) {
			selectVisibileTextByXpath("//select[@name='laungecity']", platformtext);
			return this;		
	}
	public IrctcAccommidationsPage selectNoOfPersons_accomid(String value) {
		selectValueByXpath("//select[@name='selPassangers']",value);
		return this;
	}
	public IrctcAccommidationsPage selectCurrentDateAsCheckInDate_accomid(String date) {
		clickByXpath("//input[@name='acservicecheckindate']");
		clickByXpath("//span[contains(@class,'act') and text()='"+date+"']");
		threadWait(1000);
		return this;
	}
	public IrctcAccommidationsPage selectCheckInTime_accomid(String valuetext) {
		selectVisibileTextByXpath("//select[@name='checkInTime']",valuetext);
			return this;
	}
	public IrctcAccommidationsPage selectDurationOfHours_accomid(String textvalue) {
		selectVisibileTextByXpath("//select[@name='checkOutTime']", textvalue);
		return this;
		
	}
	public IrctcAccommidationsPage clickBookButton_accomid() {
		clickByXpath("//button[normalize-space()='Book']");
		threadWait(0);
		return this;
	}
	
	public IrctcAccommidationsPage clickGuestLogin_accomid() {
		clickByXpath("//a[@id='profile-tab']");
		threadWait(1000);
		return this;
	}
	public IrctcAccommidationsPage enterMailId_accomid(String mailId) {
		enterByXpath("//input[@id='modalLRInput12']", mailId);
		return this;
	}
	public IrctcAccommidationsPage enterMobileNumber_accomid(String mobileNumber) {
		enterByXpath("//input[@name='mobileNo']", mobileNumber);
		return this;
	}
	public IrctcAccomidationsPassangerDetail clickLoginButton_accomid() {
		clickByXpath("//*[@id=\"profile\"]/div/form/div[3]/button");
		threadWait(2000);
		return new IrctcAccomidationsPassangerDetail();
	}
	
	public IrctcAccommidationsPage clickOnRightMenu_accomid() {
	clickByXpath("//i[@class='fas fa-align-left']");
	return this;
	}
	public IrctcCharterPage clickOnCharter_accomid() {
	clickByXpath("//a[text()='Charter']");
	return new IrctcCharterPage();
	}
	
	

}
