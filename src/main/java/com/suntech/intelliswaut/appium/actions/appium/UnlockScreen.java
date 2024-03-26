package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;

public class UnlockScreen {

	public void run(HashMap<String, Object> params) throws Exception {

		try {
			if((Driver.driver).getPlatformName().toLowerCase().contains("android")){ 
				((AndroidDriver)Driver.driver).unlockDevice();
				Log.passed("Device unlocked");
			}
			else{
				((IOSDriver)Driver.driver).unlockDevice();
				Log.passed("Device unlocked");
			}
		}
		catch (Exception e) {
			Log.failed("Device unlocked is not working");
			e.printStackTrace();
			throw e;
		}

	}
}