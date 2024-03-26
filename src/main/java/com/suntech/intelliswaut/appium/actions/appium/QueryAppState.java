package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class QueryAppState {
	public String run(HashMap<String, Object> params) throws Exception {
		try {
			if((Driver.driver).getPlatformName().toLowerCase().contains("android"))
			{
				String appPackage = (Get.param(params,"appPackage"));
				String AppState = (Driver.driver).queryAppState(appPackage).toString();
				Log.info(AppState);
				return AppState;
				}
				
			else{
				String appBundleId=(Get.param(params,"bundleID"));
				String AppState = (Driver.driver).queryAppState(appBundleId).toString();
			 	Log.info(AppState);
				return AppState;
				}


		} catch (Exception e) {
			Log.failed(e.getMessage());
			return null;
			//e.printStackTrace();
		}
		
	}
}
