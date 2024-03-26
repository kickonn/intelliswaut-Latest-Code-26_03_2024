package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class ActivateApp {
	public void run(HashMap<String, Object> params) throws Exception {
		try {	
			if((Driver.driver).getPlatformName().toLowerCase().contains("android")){
				String appPackage=(Get.param(params,"appPackage"));

				if(appPackage!=null) {
					(Driver.driver).activateApp(appPackage);
					Log.passed("Android application is activated");			 
				}

			}			
			else 
			{ 
				String bundleID=(Get.param(params,"bundleID"));

				if(bundleID!=null) {
					(Driver.driver).activateApp(bundleID);
					Log.passed("IOS application is activated");
				}
			}

		} catch (Exception e) {

			Log.failed(e.getMessage());
			//	e.printStackTrace();
			throw e;
		}
	}
}
