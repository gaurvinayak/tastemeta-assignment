package com.tastemeta.qa.util;

import java.io.File;   

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FileUtils;
import org.json.JSONArray;
import org.json.JSONObject;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.tastemeta.qa.base.TestBase;

public class TestUtil extends TestBase {

	public static long PAGE_LOAD_TIMEOUT = 20;
	public static long IMPLICIT_WAIT = 20;

	public static String TESTDATA_PATH = System.getProperty("user.dir").replace("\\", "/")+"\\src\\main\\java\\com\\tastemeta\\qa\\testdata\\testdata.json".replace("\\", "/");


	public static String readTestDataFile() {
		File file = new File(TESTDATA_PATH);
	    System.out.println(file.exists());
	    
	    byte[] encoded;
		try {
			encoded = Files.readAllBytes(Paths.get(TESTDATA_PATH));
			return(new String(encoded, StandardCharsets.UTF_8));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	   
	}
	
	public static JSONObject getTestData(String tcName)  {
		JSONArray JsonArr;
		try {
			JsonArr = new JSONArray(readTestDataFile());
		 
		  for (Object obj : JsonArr)
		  {
			  JSONObject tc_Details = (JSONObject) obj;
			  if (tc_Details.getString("TC_Name").equalsIgnoreCase(tcName)) {
				  return tc_Details;
			  }
		  }
		  
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
	

	public static void takeScreenshotAtEndOfTest(String methodName) throws IOException {
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		String currentDir = System.getProperty("user.dir");
		FileUtils.copyFile(scrFile, new File(currentDir + "/screenshots/"+ methodName + "_"+ System.currentTimeMillis() + ".png"));
	}
	
	
	
	public static void updatePwdInFile(String oldPwd, String newPwd) {
		TextFileModificationProgram.modifyFile(TESTDATA_PATH, oldPwd, newPwd);
	}

	

}
