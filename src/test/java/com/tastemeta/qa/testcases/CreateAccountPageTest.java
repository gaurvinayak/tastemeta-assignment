package com.tastemeta.qa.testcases;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tastemeta.qa.base.TestBase;
import com.tastemeta.qa.pages.CreateAccountPage;
import com.tastemeta.qa.pages.HomePage;
import com.tastemeta.qa.pages.LoginPage;
import com.tastemeta.qa.util.TestUtil;

public class CreateAccountPageTest extends TestBase{
	LoginPage loginPage;
	CreateAccountPage createAccountPage;
	
	public CreateAccountPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
//		loginPage = new HomePage().validateLoginPageTitle();	
	}
	
	
	@Test(priority=2)
	public void CreateAccountTest() throws InterruptedException{
		
		JSONObject tcDetails=TestUtil.getTestData("CreateAccountTest");
	    boolean useLetters = true;
	    boolean useNumbers = false;
	    String generatedString = RandomStringUtils.random(10, useLetters, useNumbers);

		String email=generatedString+tcDetails.getString("email");
		String Pwd=tcDetails.getString("Pwd");

		loginPage = new HomePage().validateLoginPageTitle();
		createAccountPage= loginPage.clickCreateAccountBtn();
		createAccountPage.setFirstName(tcDetails.getString("FirstName"));
		createAccountPage.setLastName(tcDetails.getString("LastName"));
		createAccountPage.selectCountryCodeIndia();
		createAccountPage.setPhoneNumber(tcDetails.getString("PhoneNumber"));
		
		createAccountPage.setEmail(email);
		createAccountPage.setPassword(Pwd);
		createAccountPage.enableCheckBox(driver);
		
		createAccountPage.clickcreateAccBtn();
		createAccountPage.clickCloseBtn();
		
		LoginPageTest loginPageTest = new LoginPageTest();
		loginPageTest.loginPageValidDetails(new HomePage(),email,Pwd,tcDetails.getString("GuestName"));
		
		
	}
	
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
