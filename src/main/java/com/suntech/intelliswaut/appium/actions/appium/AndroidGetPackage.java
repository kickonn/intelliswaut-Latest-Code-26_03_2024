package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class AndroidGetPackage {
	public String run(HashMap<String, Object> params) throws Exception {
		try {

			String Packagename =  (Driver.driver).getCapabilities().getCapability("appPackage").toString();
			Log.info("Package name is " + Packagename);
			return Packagename;
		
		} catch (Exception e) {
			Log.failed("Unable to get the package name "+ e.getMessage());
			return null;
		}
	
	}
}

