package pom.pages;

import wrappers.GenericWrappers;

public class IrctcAccomidationsPassangerDetail extends GenericWrappers{

	public IrctcAccomidationsPassangerDetail  enterPasanger1Name_accpass(String name) {
		enterByXpath("(//input[@placeholder='Name'])[1]",name);
	    threadWait(1000);
		return this;
	}
	public IrctcAccomidationsPassangerDetail  enterPasanger1Age_accpass(String age) {
		enterByXpath("//tbody/tr[1]/td[3]/input[1]",age);
		threadWait(1000);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  selectGenderPass1_accpass(String gendervalue) {
		selectVisibileTextByXpath("//input[@placeholder='Name']//following::input[@placeholder='Name']//preceding::select",gendervalue);
		threadWait(1000);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  enterPasanger2Name_accpass(String name) {
		enterByXpath("//input[@placeholder='Name']//following::input[@placeholder='Name']",name);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  enterPasanger2Age_accpass(String age) {
		enterByXpath("//input[@placeholder='Age']//following::input[@placeholder='Age']",age);
		threadWait(1000);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  selectGenderPass2(String gendertext) {
		selectVisibileTextByXpath("//input[@placeholder='Age']//following::input[@placeholder='Age']//following::select",gendertext);
		threadWait(1000);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  enterPasanger3Name_accpass(String name) {
		enterByXpath("(//input[@placeholder='Name'])[3]",name);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  enterPasanger3Age_accpass(String age) {
		enterByXpath("(//input[@placeholder='Age'])[3]",age);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  selectGenderPass3_accpass(String gendervalue) {
		selectValueByXpath("/html/body/app-root/acpassangers/div/form/div/div/div/div/div[1]/div/table/tbody/tr[3]/td[4]/select",gendervalue);
		return this;
		}
	public IrctcAccomidationsPassangerDetail  selectState_accpass(String statetext) {
		selectVisibileTextByXpath("//select[@name='state']", statetext);
		return this;
	}
	public IrctcAccomidationsSummaryPage clickOnSubmit_accpass() {
		clickByXpath("//button[normalize-space()='Submit']");
		threadWait(1000);
		return new IrctcAccomidationsSummaryPage();
	}
	
	public IrctcAccomidationsPassangerDetail  selectGstYesorNo_accpass(String value) {
				selectVisibileTextByXpath("//select[@name='gstGet']", value);
			
		return this;
	}
	public IrctcAccomidationsPassangerDetail  enterGSTrandomNumber_accpass(String gstnum) {
		enterByXpath("//input[@placeholder='Gst Number']", gstnum);	
		return this;
	}
       
}
