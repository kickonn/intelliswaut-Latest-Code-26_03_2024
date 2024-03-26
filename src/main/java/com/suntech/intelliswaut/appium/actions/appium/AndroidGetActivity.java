package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
public class AndroidGetActivity {
	public String run(HashMap<String, Object> params) throws Exception {
		try {

			String Activityname = (Driver.driver).getCapabilities().getCapability("appActivity").toString();
              Log.info("Activity name is "+ Activityname);
			return Activityname;

		} catch (Exception e) {
			
			Log.failed("Unable to get the Activity name "+ e.getMessage());
		
			//e.printStackTrace();
			
		}
		return null;
	}
}
