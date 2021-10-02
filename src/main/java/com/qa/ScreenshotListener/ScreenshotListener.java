package com.qa.ScreenshotListener;

import java.io.IOException;

import org.openqa.selenium.*;

import org.testng.*;

import com.tastemeta.qa.util.TestUtil;

public class ScreenshotListener extends TestListenerAdapter {
    @Override
    public void onTestFailure(ITestResult result) {


        String methodName = result.getName();
        if(!result.isSuccess()){
           try {
			TestUtil.takeScreenshotAtEndOfTest(methodName);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        }
    }
}