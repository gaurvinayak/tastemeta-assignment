package com.tastemeta.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tastemeta.qa.base.TestBase;

public class CreateAccountPage extends TestBase {
	
	@FindBy(name="firstname")
	WebElement firstname;
	
	@FindBy(name="lastname")
	WebElement lastname;
	
	@FindBy(xpath="//ul/li[@data-country-code='in']")
	WebElement indiaCode;
	
	
	@FindBy(xpath="//div[@class='iti__flag-container']")
	WebElement flagcontainer;
	
	@FindBy(xpath="//input[@formcontrolname='email']")
	WebElement email;
	
	
	@FindBy(xpath="//input[@formcontrolname='password']")
	WebElement password;
	
	
	@FindBy(xpath="//label[@class='check-box signupLabel pr-0' and contains(text(),'Agree to all')]")
	WebElement agreeAllchkBox;
	
	@FindBy(xpath="//button[contains(text(),'Create an account')]")
	WebElement createAccBtn;
	
	@FindBy(xpath="//button[@class='close']")
	WebElement closeBtn;
	
	
	@FindBy(xpath="//input[@formcontrolname='phone']")
	WebElement phone;
	
	
	public CreateAccountPage(){
		PageFactory.initElements(driver, this);
	}
	
	public void clickcreateAccBtn() {
		createAccBtn.click();
	}	
	
	public void clickCloseBtn() {
		closeBtn.click();
	}
	
		public void setFirstName(String fsName) {
			firstname.sendKeys(fsName);
		}
		
		public void setLastName(String fsName) {
			lastname.sendKeys(fsName);
		}
		

		public void setEmail(String fsName) {
			email.sendKeys(fsName);
		}
		
		public void setPassword(String fsName) {
			password.sendKeys(fsName);
		}
		
		
		public void selectCountryCodeIndia() {
			flagcontainer.click();
			indiaCode.click();
		}
		
		public void setPhoneNumber(String str) {
			phone.sendKeys(str);
		}
		
		public void enableCheckBox(WebDriver driver) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,1000)");
	
			agreeAllchkBox.click();
		}
		
		
}
