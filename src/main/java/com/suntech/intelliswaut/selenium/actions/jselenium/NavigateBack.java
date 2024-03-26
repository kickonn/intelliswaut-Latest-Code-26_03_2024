package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class NavigateBack {

	public void run(HashMap<String, Object> params) throws Exception {
		try{
			if(Browser.Driver!=null) {
				Browser.Driver.navigate().back();	
				Log.passed("Navigated backward from browser history successfully");
			}
		}catch (Exception e) {	
			Log.failed("Exception caught in NavigateBack Action " + e.getMessage());			
			throw e;
		}
	}
}
