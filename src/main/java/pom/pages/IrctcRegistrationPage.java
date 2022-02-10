package pom.pages;

import wrappers.GenericWrappers;

public class IrctcRegistrationPage extends GenericWrappers {

	public IrctcRegistrationPage enterUserName_irctcReg(String username) {
		enterByXpath("//input[@id='userName']", username);
		return this;
	}

	public IrctcRegistrationPage enterPassword_irctcReg(String password) {
		enterByXpath("//input[@id='usrPwd']", password);
		return this;
	}
	public IrctcRegistrationPage enterconfPassword_irctcReg(String confpassword) {
		enterByXpath("//input[@id='cnfUsrPwd']",confpassword);
		
		return this;
	}

	public IrctcRegistrationPage selectPrefferedLaguage_irctcReg(String value) {
		clickByXpath("//*[@formcontrolname='prefLang']");
		threadWait(2000);
		clickByXpath("//li[@aria-label='English']");
		scrolldown(0,1000);
		threadWait(2000);
		return this;
	}

	public IrctcRegistrationPage selectSequrityQuestion_irctcReg(String question) {
		clickByXpath("//*[@formcontrolname='secque']");	
		threadWait(1000);
		clickByXpath("//span[text()='"+question+"']");
		
		//clickElementByXpathExplictwait("//li[@aria-label="+question+"]");
		threadWait(1000);
		return this;
	}

	public IrctcRegistrationPage enterSequrityAnswerString_irctcReg(String seqans) {		
		enterByXpath("//*[@placeholder='Security Answer']", seqans);
		threadWait(1000);
		return this;
	}

	public IrctcRegistrationPage clickonContinueBasicDetails_irctcReg() {
		threadWait(1000);
		clickElementByXpathExplictwait("//button[@label='Continue']");
		return this;
	}

	public IrctcRegistrationPage enterFirstNamePersonal_irctcReg(String firstname) {
		threadWait(2000);
		enterByXpath("//input[@id='firstName']", firstname);

		return this;
	}

	public IrctcRegistrationPage enterMiddleNamePersonal_irctcReg(String middlename) {
		enterByXpath("//input[@id='middleName']", middlename);
		return this;
	}

	public IrctcRegistrationPage enterLastNamePersonal_irctcReg(String Lastname) {
		enterByXpath("//input[@id='lastname']", Lastname);
		return this;
	}

	public IrctcRegistrationPage selectOccupation_irctcReg(String value) {		
		clickByXpath("//*[@formcontrolname='occupation']");	
		threadWait(1000);
		clickByXpath("//*[@aria-label='"+value+"']");
		threadWait(1000);
		return this;
	}

	public IrctcRegistrationPage selectDateOfBirth_irctcReg(String month, String year,String date) {
		clickByXpath("//p-calendar[@formcontrolname='dob']");
		threadWait(2000);
		selectVisibileTextByXpath("//*[contains(@class,'ui-datepicker-month')]",month);
		threadWait(2000);
		selectVisibileTextByXpath("//*[contains(@class,'ui-datepicker-year')]",year);		
		threadWait(2000);
		clickByXpath("//a[text()='"+date+"']");
		return this;
	}

	public IrctcRegistrationPage selectGender_irctcReg(String gender) {
		clickByXpath("//div[@aria-label='"+gender+"']");
		return this;
	}

	public IrctcRegistrationPage SelectMaterialStatus_irctcReg(String status) {
          clickByXpath("//p-radiobutton[@id='"+status+"']");

		return this;
	}

	public IrctcRegistrationPage selectCountry_irctcReg(String country) {
//		clickByXpath("//*[@formcontrolname='resCountry']");
//		threadWait(1000);
		selectVisibileTextByXpath("//*[@formcontrolname='resCountry']", country);
//		if(country.equalsIgnoreCase("India")){
//		selectVisibileTextByXpath("//body/app-root[1]/app-home[1]/div[3]/div[1]/app-user-registration[1]/div[1]/div[1]/form[1]/div[1]/div[2]/div[1]/div[2]/p-tabview[1]/div[1]/div[1]/p-tabpanel[2]/div[1]/div[1]/div[8]/select[1]",
//				"India");
		
		return this;
	}

	public IrctcRegistrationPage enterMail_irctcReg(String mail) {
		enterByXpath("//input[@name='email']", mail);
		return this;
	}

	public IrctcRegistrationPage enterMobileNumber_irctcReg(String number) {
		enterByXpath("//input[@name='mobile']", number);
		return this;
	}

	public IrctcRegistrationPage selectNationality_irctcReg(String nationalityvalue) {
		selectVisibileTextByXpath("//*[@formcontrolname='nationality']", nationalityvalue);
		return this;	
		}

		
	

	public IrctcRegistrationPage clickonContinuePersonalDetails_irctcReg() {
		clickByXpath("//button[@label='Continue']");
		return this;
	}

	public IrctcRegistrationPage enterDoorNoAddress_irctcReg(String doorno) {
		enterByXpath("//input[@id='resAddress1']", doorno);
		return this;
	}

	public IrctcRegistrationPage enterStreetAddress_irctcReg(String streetname) {
		enterByXpath("//input[@id='resAddress2']", streetname);
		return this;
	}

	public IrctcRegistrationPage enterAreadAddress_irctcReg(String areaname) {
		enterByXpath("//input[@id='resAddress3']", areaname);
		return this;
	}

	public IrctcRegistrationPage enterPincodeAddress_irctcReg(String pincode) {
		enterByXpath("//input[@placeholder='Pin code']", pincode);
		threadWait(1000);
		return this;
	}

	public IrctcRegistrationPage enterStateAddress_irctcReg(String statename) {
		enterByXpath("//input[@id='resState']", statename);
		return this;
	}

	public IrctcRegistrationPage selectCityAddress_irctcReg(String textofcity) {	
		selectVisibileTextByXpath("//*[@formcontrolname='resCity']",textofcity);
		threadWait(1000);
		return this;
	}

	public IrctcRegistrationPage selectPostalOfficeAddress_irctcReg(String postaladdvalue) {
		selectValueByXpath("//*[@formcontrolname='resPostOff']",postaladdvalue);
		threadWait(1000);
		return this;
	}
	
	

	public IrctcRegistrationPage enterPhoneNumberAddress_irctcReg(String phonenumber) {
		enterByXpath("//input[@id='resPhone']", phonenumber);
		return this;
	}

	public IrctcRegistrationPage clickYesCopyResidenceAddress_irctcReg() {
		clickByXpath("//p-radiobutton[@id='yes']");
		return this;
	}
	
	public IrctcRegistrationPage clickYesTermconditon_irctcpage() {
		clickByXpath("//*[@formcontrolname='termCondition']");
		return this;
	}

}
