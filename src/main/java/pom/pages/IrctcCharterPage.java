package pom.pages;

import wrappers.GenericWrappers;

public class IrctcCharterPage extends GenericWrappers{
	
	public IrctcCharterPage clickOnEnquiryPage_chart() {
		clickByXpath("//a[@id='enquiry-tab']");
		return this;
	}
	public IrctcCharterPage enterApplicantName_chart(String text) {
		enterByXpath("//input[@placeholder='Name of Applicant']", text);
		return this;
     }
	public IrctcCharterPage enterOrganizationName_chart(String text) {
		enterByXpath("//input[@placeholder='Name of Organisation']", text);
		return this;
     }
	public IrctcCharterPage enterAddress_chart(String text) {
		enterByXpath("//input[@placeholder='Address']", text);
		return this;
     }
	public IrctcCharterPage enterMobileNumber_chart(String text) {
		enterByXpath("//input[@placeholder='Mobile*']", text);
		return this;
     }
	public IrctcCharterPage enterMailId_chart(String text) {
		enterByXpath("//input[@placeholder='Email']", text);
		return this;
     }
	 public IrctcCharterPage selectRequestFor_chart() {
		 selectValueByXpath("//select[@name='requestFor']", "Saloon Charter");
		 return this;
	    }
	 public IrctcCharterPage enterOrginCity_chart(String cityname) {
		 enterByXpath("//input[@placeholder='Originating Station*']", cityname);
			return this;
    }
	 public IrctcCharterPage enterDestinationCity_chart(String cityname) {
			enterByXpath("//input[@placeholder='Destination Station*']", cityname);	
			return this;
    }
	public IrctcCharterPage SelectDateofDeparture_chart (String date) {
		clickByXpath("//input[@placeholder='Date of Departure']");
		threadWait(1000);
		clickByXpath("//span[text()="+date+"]");
		return this;
	}
	public IrctcCharterPage SelectDateOfArrivalBack_chart (String date) {
		clickByXpath("//input[@placeholder='Date of Departure']");
		threadWait(1000);
		clickByXpath("//span[text()="+date+"]");
		return this;
	}
	public IrctcCharterPage enterNoOfCoaches_chart(String text) {
		enterByXpath("//input[@placeholder='Number and type of coaches required']", text);
		return this;
     }
	
	public IrctcCharterPage enterPurposeOfCharter_chart(String text) {
		enterByXpath("//textarea[@placeholder='Purpose of Charter']", text);
		return this;
     }
	public IrctcCharterPage selectDateOfArrivalBack_chart(String text) {
		enterByXpath("", text);
		return this;
	}
	public IrctcCharterPage enterDurationOftourinDays_chart(String days) {
		enterByXpath("//input[@placeholder='Duration of Tour in terms of number of days']", days);
		return this;
	}
	public IrctcCharterPage enterNoOfpassengers1stBlock_chart(String num) {
		enterByXpath("//input[@name='numPassenger'][1]", num);
		return this;
	}
	
	public IrctcCharterPage enterNoOfpassengers2ndBlock_chart(String num) {
		enterByXpath("//input[@name='numPassenger']/following::input", num);
		return this;
	}
	public IrctcCharterPage enterAdditonalServiceRequired_chart(String text) {
		enterByXpath("//textarea[@placeholder='Additional Services Required']", text);
		return this;
     }
	public IrctcCharterPage enteremail_chart(String text) {
		enterByXpath("//input[@placeholder='Email']", text);
		return this;
     }
	public IrctcCharterPage clickOnSubmit_chart() {
		clickByXpath("//button[@type='Submit']");
		return this;
	}
}
