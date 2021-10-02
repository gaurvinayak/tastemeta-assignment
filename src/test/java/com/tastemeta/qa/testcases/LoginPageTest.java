package com.tastemeta.qa.testcases;


import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tastemeta.qa.base.TestBase;
import com.tastemeta.qa.pages.HomePage;
import com.tastemeta.qa.pages.LoginPage;
import com.tastemeta.qa.util.TestUtil;

public class LoginPageTest extends TestBase {
	HomePage homePage;
	LoginPage loginPage;
	
	
	public LoginPageTest(){
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws InterruptedException{
		initialization();
	}
	
	
	
	
	@Test(priority=2)
	public void loginPageInvalidDetailsTest() throws InterruptedException{
		JSONObject tcDetails=TestUtil.getTestData("loginPageInvalidDetailsTest");
		loginPage = new HomePage().validateLoginPageTitle();
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "META");
		loginPage.setEmailId(tcDetails.getString("email"));
		loginPage.setPassword(tcDetails.getString("Pwd"));
		loginPage.clickSignIn();
		Assert.assertEquals(loginPage.checkAlertExistwithText(" Invalid Email address or Password ".trim()),true);
	}
	
	
	@Test(priority=2)
	public void loginPageValidDetailsTest() throws InterruptedException{
		HomePage homePage= new HomePage();
		JSONObject tcDetails=TestUtil.getTestData("loginPageValidDetailsTest");
		loginPageValidDetails(homePage,tcDetails.getString("email"),tcDetails.getString("Pwd"),tcDetails.getString("GuestName"));
	
	}
	
	
	public HomePage loginPageValidDetails(HomePage homePage,String email,String pwd,String GuestNameExp) throws InterruptedException{
		loginPage = homePage.validateLoginPageTitle();
		loginPage.setEmailId(email);
		loginPage.setPassword(pwd);
		homePage=loginPage.clickSignIn();
		String guestName=homePage.getGuestName();
		Assert.assertEquals(guestName, GuestNameExp);
		return homePage;
	}
	
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
}
