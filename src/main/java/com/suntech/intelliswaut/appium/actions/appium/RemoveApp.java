package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class RemoveApp {
	public void run(HashMap<String, Object> params) throws Exception {
	
		try {	
			 if((Driver.driver).getPlatformName().toLowerCase().contains("android")){
			 String appPackage = (Get.param(params,"appPackage"));
			
			      if(appPackage!=null) {
			      (Driver.driver).removeApp(appPackage);
			      Log.passed("Android Application Removed");			 
			       }
			 }			
			 else 
			 { 
			 String bundleID=(Get.param(params,"bundleID"));
			 
			 	if(bundleID!=null) {
			 	(Driver.driver).removeApp(bundleID);
			 	Log.passed("IOS Application Removed");
				}	
			}
		}
		catch (Exception e) {
			Log.failed(e.getMessage());
			throw e;
		}
	}
}