package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class IsAppInstalled {
	public boolean run(HashMap<String, Object> params) throws Exception {
		try {	
			if((Driver.driver).getPlatformName().toLowerCase().contains("android")){
			
				String appPackage=(Get.param(params,"appPackage"));
				boolean value=Driver.driver.isAppInstalled(appPackage);
				Log.info("App is Installed " +  value);
				return value;

				
				}
			else {
				String appBundleId=(Get.param(params,"bundleID"));
			 	boolean value=(Driver.driver).isAppInstalled(appBundleId);
				Log.info("App is Installed " +  value);
				return value;
				}
	

		} catch (Exception e) {
				Log.failed(e.getMessage());
			//Log.failed(e.printStackTrace());
			return (Boolean) null;
		}
	}
}
