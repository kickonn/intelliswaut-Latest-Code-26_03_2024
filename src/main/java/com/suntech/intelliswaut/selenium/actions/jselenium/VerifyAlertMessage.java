package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.Alert;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class VerifyAlertMessage {


	public void run(HashMap<String, Object> params) throws Exception {
		try{
			Wait.waitForAlert();
			Alert alert=Browser.Driver.switchTo().alert();
			 String alertText=alert.getText();
			 if(alertText.contains(Get.param(params,"AlertMessage").toString())) {
				 Log.passed("Alert message text is as expected, "+alertText);				
			 }else {
			
				 Log.failed("Alert message text is not as expected, Actual is "+alertText+ ",Expected is "+ Get.param(params,"AlertMessage").toString());
			 }
		} catch (Exception e) {
			Log.failed("Exception caught in VerifyAlertMessage Action, Message is "+e.getMessage());
			throw e;
		}
	}
}	
