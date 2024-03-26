package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class WaitForNewWindow {
	public boolean run(HashMap<String, Object> params) throws Exception {
		boolean blnWindow = false;
		int i =2;
		if(Get.param(params,"NoOfWindows")!=""){
			i = Integer.parseInt(Get.param(params,"NoOfWindows"));
		}else{
			Log.info("NoOfWindows parameter is not passed in Wait For New Window Action, So considering the NoOfWindows to be waited as 2");
		}
		
		try{			
			new WebDriverWait(Browser.Driver, Duration.ofSeconds(60)).until(ExpectedConditions.numberOfWindowsToBe(i));	
			Log.passed("Total number of windows opened is "+i);
			blnWindow = true;
		}catch(Exception Ex){
			Log.failed("Expected number of windows are not opened, Expected is "+i);
			blnWindow = false;
			throw Ex;
		}
		return blnWindow;
	}
}
