package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class NavigateForward {

	public void run(HashMap<String, Object> params) throws Exception {
		try{
			if(Browser.Driver!=null) {
				Browser.Driver.navigate().forward();		
				Log.passed("Navigated Forward from browser history successfully");
			}
		}catch (Exception e) {	
			Log.failed("Exception caught in NavigateForward Action " + e.getMessage());			
			throw e;
		}
	}
}
