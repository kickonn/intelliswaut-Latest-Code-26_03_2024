package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class TerminateApp {
	public void run(HashMap<String, Object> params) throws Exception {
		try {	
			if((Driver.driver).getPlatformName().toLowerCase().contains("android")){

				String appPackage=(Get.param(params,"appPackage"));
				
				Driver.driver.terminateApp(appPackage);
					
				Log.passed("Android APP is Terminated");				
				}

			else{
				String bundleID=(Get.param(params,"bundleID"));
			 	
				Driver.driver.terminateApp(bundleID);
					
				Log.passed("IOS APP is Terminated");
				}
			
			} 
			
		catch (Exception e) {
			Log.failed(e.getMessage());
			//e.printStackTrace();
			throw e;
			}
	}
}
