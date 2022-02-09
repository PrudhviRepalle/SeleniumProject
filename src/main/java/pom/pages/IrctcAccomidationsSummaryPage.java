package pom.pages;

import wrappers.GenericWrappers;

public class IrctcAccomidationsSummaryPage extends GenericWrappers{
	
	public IrctcAccomidationsSummaryPage verifyTextOfMaild_accsummary(String maiLid) {
		verifyTextByXpath("//html/body/app-root/acsummery/div/div[2]/div/div/div/div[2]/div/div[1]/span", maiLid);
		return this;
	}
	public IrctcAccomidationsSummaryPage verifyTextOfMobileNo_accsummary(String mobileno) {
		verifyTextByXpath("//strong[text() ='Mobile No. ']",  mobileno);
		return this;
		}
	public IrctcAccomidationsSummaryPage clickAgreecheckbox_accsummary() {
		clickByXpath("//span[@class='checkmark']");
		return this;
	}
    public IrctcAccomidationsSummaryPage clickOnMakePayementButton_accsummary() {
    	clickByXpath("//button[contains(text(),'Make Payment')]");
    	return this;
    }
}
