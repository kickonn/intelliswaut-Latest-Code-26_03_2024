package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;
import java.util.Set;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SwitchToNewWindow {
	
	public void run(HashMap<String, Object> params) throws Exception {
		if(WindowApp.driver!=null) {
			Set<String> str1 = WindowApp.driver.getWindowHandles();
            for(String strwin : str1){
				WindowApp.driver.switchTo().window(strwin);
            }
		}else{
			Log.failed("Error Desktop Application is not opened.  Use Open Desktop action.");
			
		}	
	}
}
