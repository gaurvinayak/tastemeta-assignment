package com.tastemeta.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tastemeta.qa.base.TestBase;

public class HomePage extends TestBase {
	
	@FindBy(xpath="//p[contains(@class,'login cursor')]")
	WebElement loginBtn;
	
	

	@FindBy(xpath="//div[@class='guest-sec']//p[contains(@class,'name')]")
	WebElement guestName;
	
	
	
	@FindBy(xpath="//ul//li//a[contains(text(),'Settings')]")
	WebElement SettingsSection;
	
	@FindBy(xpath="//p[contains(text(),'Change Password')]")
	WebElement ChngPwdBtn;
	
	@FindBy(xpath="//input[@formcontrolname='current_password']")
	WebElement current_password;
	
	@FindBy(xpath="//input[@formcontrolname='new_password']")
	WebElement new_password;
	
	@FindBy(xpath="//input[@formcontrolname='confirm_password']")
	WebElement confirm_password;
	
	@FindBy(xpath="//button[text()='Confirm']")
	WebElement confirmBtn;
	
	@FindBy(xpath="//p[text()='Logout']")
	WebElement logoutBtn;
	
	
	//Initializing the Page Objects:
	public HomePage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public void logOut() {
		logoutBtn.click();
		
	}

	public void openSettingsSection() {
		SettingsSection.click();
	}
	
	public void openChangePwdSettings() {
		ChngPwdBtn.click();
	}
	
	public void EnterCurrentPassword(String str) {
		current_password.sendKeys(str);
	}

	public void EnterNewPassword(String str) {
		new_password.sendKeys(str);
		confirm_password.sendKeys(str);
	}
	
	
	public void clickConfirmBtn() {
		confirmBtn.click();
	}
	
	
		public LoginPage validateLoginPageTitle() throws InterruptedException{
		
			loginBtn.click();
			
			if(loginBtn.isDisplayed()) {
				Actions action = new Actions(driver);
				action.click(loginBtn).perform();
			}
			
			Thread.sleep(5000);
			return new LoginPage();
		}
		
		public void clickLoginBtn() throws InterruptedException {
			loginBtn.click();
			Thread.sleep(5000);
			
		}
		
		
		public String getGuestName() {
			return guestName.getText().trim();
		}
}
