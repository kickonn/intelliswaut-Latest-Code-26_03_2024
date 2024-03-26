package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class VerifyElementExists {
	public boolean run(HashMap<String, Object> params) throws Exception {
		String elemName = (Get.param(params,"Element Name"));
		try{
			MobileElement element1= Elements.find(params, Driver.driver);
			Thread.sleep(1000);
			element1.isDisplayed();
			Log.passed("Element is displayed as expected : "+elemName);
			return true;
		}catch(Exception ex){
			Log.failed("Element is not displayed as expected : "+elemName);
			return false;
		}	
	}

}
