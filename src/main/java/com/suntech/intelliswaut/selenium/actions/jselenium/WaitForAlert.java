package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class WaitForAlert {
	
	public boolean run(HashMap<String, Object> params) throws Exception {
		int time;
		boolean blnAlert = false;
		try{
			if(Get.param(params,"Time")!="") {
				time = Integer.parseInt(Get.param(params,"Time").toString());
			}else {
				time = 30;
			}
			try{
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(time)).until(ExpectedConditions.alertIsPresent());			
				blnAlert = true;
			}catch(Exception Ex){
				blnAlert = false;
				throw Ex;
			}
		}catch(Exception e){
			Log.failed("Exception caught in waitForAlert Action, Message is "+e.getMessage());
			throw e;
		}	
		return blnAlert;
	}
	
}
