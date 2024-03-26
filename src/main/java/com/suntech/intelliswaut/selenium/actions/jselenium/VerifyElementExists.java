package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyElementExists {
	public boolean run(HashMap<String, Object> params) throws Exception {
		boolean bln = false;
		String elemName = Get.param(params,"Element Name").toString();
		try{			
			WebElement element1 = Elements.find(params, Browser.Driver);
			Thread.sleep(1000);
			element1.isDisplayed();
			Log.info("Element is displayed as expected : "+elemName);			
		}catch(Exception ex){
			Log.failed("Element "+elemName + "does not exists in the application " );
			throw ex;
		}	
		return bln;
	}

}
