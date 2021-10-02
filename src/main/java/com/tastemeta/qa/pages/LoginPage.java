package com.tastemeta.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tastemeta.qa.base.TestBase;

public class LoginPage extends TestBase {

	@FindBy(xpath="//button[contains(text(),'Sign in')]")
	WebElement signInBtn;
	
	@FindBy(xpath="//button[contains(text(),'Create an account')]")
	WebElement createAccBtn;
	
	@FindBy(xpath="//input[@type='email']")
	WebElement emailId;
	
	@FindBy(xpath="//input[@type='password']")
	WebElement password;
	
	
	@FindBy(xpath="//div[@role='alertdialog']")
	WebElement alertdialog;
	
	
	
	//Initializing the Page Objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);
	}
	

		public CreateAccountPage clickCreateAccountBtn() {
			createAccBtn.click();
			return new CreateAccountPage();
		}
	
		public String validateLoginPageTitle(){
			return driver.getTitle();
		}
		
		
		public void setEmailId(String email) {
			emailId.sendKeys(email);
		}
		
		public void setPassword(String pwd) {
			password.sendKeys(pwd);
		}
		
		public HomePage clickSignIn() {
			signInBtn.click();
			return new HomePage();
		}
		
		
		public boolean checkAlertExistwithText(String str) {
			if(alertdialog.isDisplayed()) {
				if(alertdialog.getText().trim().equalsIgnoreCase(str)) {
					return true;
				}else {
					return false;
				}
				
			}else {
				return false;
			}
			
		}
		
}
