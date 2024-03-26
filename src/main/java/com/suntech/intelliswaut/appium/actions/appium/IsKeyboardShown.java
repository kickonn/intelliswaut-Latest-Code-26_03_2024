package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class IsKeyboardShown {
	
public boolean run(HashMap<String, Object> params) throws Exception {
		try {	
			if((Driver.driver).getPlatformName().toLowerCase().contains("android")){ 
				
			 boolean value = ((AndroidDriver)Driver.driver).isKeyboardShown();
			Log.passed("Keyboard shown successfully " + value);
			return value;
			}
			
			else {
				
			boolean value = ((IOSDriver)Driver.driver).isKeyboardShown();
			Log.passed("Keyboard shown successfully " + value);
			return (Boolean) null;
			}
		}

		catch (Exception e) {
         	//e.printStackTrace();
			Log.failed("Elements are not equal " + e.getMessage());
        	return (Boolean) null;
		}
	}
}
