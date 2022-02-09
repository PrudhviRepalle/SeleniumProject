package pom.pages;

import org.apache.poi.ss.formula.functions.Value;

import wrappers.GenericWrappers;

public class IrctcFtrRegistrationSignUpPage extends GenericWrappers{
	
	public IrctcFtrRegistrationSignUpPage enterNewuserid_ftrreg(String newusername) {
		enterByXpath("//input[@id='userId']", newusername);
		return this;
	}
	
	
    public IrctcFtrRegistrationSignUpPage enterNewPassword_ftrreg(String newPassword) {
    	enterByXpath("//input[@id='password']",newPassword);
    	return this;
    }
  

    public IrctcFtrRegistrationSignUpPage enterConfirmPassword_ftrreg(String confPassword) {
    	enterByXpath("//input[@id='cnfPassword']",confPassword);
    	return this;
    }
   
    
    public IrctcFtrRegistrationSignUpPage selectSecurityQuestion_ftrreg(String value) {
    	
    	
          selectVisibileTextByXpath("//select[@id='secQstn']", value);	
    	return this;
    }
  
    public IrctcFtrRegistrationSignUpPage enterSecurityAnswer_ftrreg(String vlaue) {
    	enterByXpath("//input[@id='secAnswer']",vlaue);
    	return this;
    }
    
    public IrctcFtrRegistrationSignUpPage selectDOB_ftrreg(String monthtext,String year) {
    	clickByXpath("//input[@id='dateOfBirth']");
		selectVisibileTextByXpath("//select[@class='ui-datepicker-month']", monthtext);
		threadWait(2000);
		selectVisibileTextByXpath("//select[@class='ui-datepicker-year']", year);
		threadWait(2000);
		clickByXpath("//*[@id=\"ui-datepicker-div\"]/table/tbody/tr[5]/td[3]");
		return this;
    }
    
    
    public IrctcFtrRegistrationSignUpPage selectGender_ftrreg(String value) {
		if(value.equalsIgnoreCase("male")) {
    		clickByXpath("//input[@id='gender0']");
    		}else if(value.equalsIgnoreCase("female")){
    			clickByXpath("(//input[@id='gender1'])[1]");
    		}
		return this;
    }
    public IrctcFtrRegistrationSignUpPage selectMterialStatus_ftrreg(String value) {
    	 if(value.equalsIgnoreCase("married")) {
    		 clickByXpath("//input[@id='maritalStatus0']");;
     		}else if(value.equalsIgnoreCase("unmarried")){
     			clickByXpath("(//input[@id='maritalStatus1'])[1]");
     		}  	 	
    	 return this;
    }
  
    public IrctcFtrRegistrationSignUpPage enterMailId_ftrreg(String mailId) {
    	enterByXpath("//input[@id='email']", mailId);
    	return this;
    }
   
    public IrctcFtrRegistrationSignUpPage selectOccupation_ftrreg(String value) {
    	
    	threadWait(1000);  	
    	
    	selectValueByXpath("(//select[@id='occupation'])[1])",value);
    		   
    	return this;
    }
    public IrctcFtrRegistrationSignUpPage enterFirstNameasPerPan_ftrreg(String value) {
    	enterByXpath("//input[@id='fname']", value);
    	return this;
    }
    public IrctcFtrRegistrationSignUpPage enterMiddleNameasPerPan_ftrreg(String value) {
    	 enterByXpath("//input[@id='mname']", value); 
    	 return this;
    }
    public IrctcFtrRegistrationSignUpPage enterLastNameasPerPan_ftrreg(String value) {
   	 enterByXpath("//input[@id='lname']", value);
   	return this;
   }
    public IrctcFtrRegistrationSignUpPage selectNationality_ftrreg(String nationalityvalue) {
    	clickByXpath("");
    	threadWait(1000);
    	if(nationalityvalue.equalsIgnoreCase("india")) {
    	selectVisibileTextByXpath("//select[@id='natinality']","Indian");
    	}
    	else {
    	   System.out.println("select proper nationality");
    	}
    	return this;
    }
    
    public IrctcFtrRegistrationSignUpPage enterDoorNoAddress_ftrreg(String textvalue) {
      	 enterByXpath("//input[@id='flatNo']", textvalue); 	
      	return this;
      }
    public IrctcFtrRegistrationSignUpPage enterStreetName_ftrreg(String streetname) {
     	 enterByXpath("//input[@id='street']", streetname); 	
     	return this;
     }
    
    public IrctcFtrRegistrationSignUpPage enterAreaLocality_ftrreg(String areaname) {
    	 enterByXpath("//input[@id='area']", areaname); 	
    	 return this;
    }
    public IrctcFtrRegistrationSignUpPage selectCountry_ftrreg(String country) {
   
    	selectVisibileTextByXpath("//select[@id='country']", "country");
    	return this;
    }
    
    public IrctcFtrRegistrationSignUpPage enterMobileNumber_ftrreg(String textvalue) {
    	enterByXpath("//input[@id='mobile']", textvalue);
    	return this;
     }
    public IrctcFtrRegistrationSignUpPage enterPincode_ftrreg(String textvalue) {
    	enterByXpath("//input[@id='pincode']", textvalue);
    	return this;
     }
    public IrctcFtrRegistrationSignUpPage sendTabKeys_ftrreg() {
    	enterByXpath("//input[@id='pincode']", "Keys.TAB");
    	return this;
    	
     }
    
}
