package com.tastemeta.qa.testcases;


import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tastemeta.qa.base.TestBase;
import com.tastemeta.qa.pages.HomePage;
import com.tastemeta.qa.util.TestUtil;


public class HomePageTest extends TestBase{
	
	HomePage homePage;
	
	public HomePageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
//		loginPage = new HomePage().validateLoginPageTitle();	
	}
	
	
	@Test(priority=2)
	public void ChangePwdTest() throws InterruptedException{
		
		JSONObject tcDetails=TestUtil.getTestData("ChangePwdTest");
		
		 boolean useLetters = false;
		 boolean useNumbers = true;
		 String generatedString = RandomStringUtils.random(6, useLetters, useNumbers);
		
		String email=tcDetails.getString("email");
		String oldPwd=tcDetails.getString("oldPwd");
		String updatePwd=tcDetails.getString("updatePwd")+generatedString;
		System.out.println(updatePwd);
		
		
		LoginPageTest loginPageTest = new LoginPageTest();
		homePage=loginPageTest.loginPageValidDetails(new HomePage(),email,oldPwd,tcDetails.getString("GuestName"));
		homePage.openSettingsSection();
		homePage.openChangePwdSettings();
		homePage.EnterCurrentPassword(oldPwd);
		homePage.EnterNewPassword(updatePwd);
		homePage.clickConfirmBtn();
		Thread.sleep(4000);
		TestUtil.updatePwdInFile(oldPwd, updatePwd);
		homePage.logOut();		
		loginPageTest.loginPageValidDetails(new HomePage(),email, updatePwd, tcDetails.getString("GuestName"));
		

	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
