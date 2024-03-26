package com.suntech.intelliswaut.appium.actions.appium;

import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Constants;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class Driver {
	public static AppiumDriver<MobileElement> driver;
	public static String type1 = "App";
	String url;

	public void run(HashMap<String, Object> params) throws Exception {
		
		// Capabilities for driver
		try{
		//	Log.info("Started");
		driver = null;
		
		url =(Get.param(params,Constants.APPIUM_NODE_URL));
		if (!url.startsWith(Constants.HTTP) && !url.startsWith(Constants.HTTPS)) {
			url = Constants.HTTP + url;
		}
		URL remoteAddress = new URL(url);
		DesiredCapabilities capabilities = new DesiredCapabilities();
		switch (Get.param(params,Constants.PLATFORM)) {
		case Constants.ANDROID:
		//	Log.info("Started");
		//	Log.info(Get.param(params,"platform"));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, (Get.param(params,Constants.PLATFORM)));
		//	Log.info(Get.param(params,Constants.PLATFORM));
			capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, (Get.param(params,Constants.DEVICE_NAME)));
			capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, (Get.param(params,Constants.VERSION)));
			capabilities.setCapability(MobileCapabilityType.NO_RESET, (Get.param(params,Constants.NO_RESET)));
			capabilities.setCapability(Constants.APP_PACKAGE, (Get.param(params,Constants.APP_PACKAGE)));
			capabilities.setCapability(Constants.APP_ACTIVITY, (Get.param(params,Constants.LAUNCH_ACTIVITY)));
			capabilities.setCapability("skipDeviceInitialization", true);
			capabilities.setCapability("skipServerInstallation", true);
			//capabilities.setCapability("noReset", false);
		//	Log.info("capabilities done");
			driver = new AndroidDriver<MobileElement>(remoteAddress, capabilities);
			break;
		case Constants.IOS:
		//	Log.info("Started");
		//	Log.info(Get.param(params,"platform"));
			capabilities.setCapability("platformName", (Get.param(params,Constants.PLATFORM)));
			capabilities.setCapability("deviceName", (Get.param(params,Constants.DEVICE_NAME)));
			capabilities.setCapability("OSVersion", (Get.param(params,Constants.VERSION)));
			capabilities.setCapability("automationName", Get.param(params,"automationName"));
			capabilities.setCapability("udid", Get.param(params,"udid"));
			capabilities.setCapability("bundleId", Get.param(params,"bundleId"));
			capabilities.setCapability("xcodeOrgid", Get.param(params,"xcodeOrgid"));
			capabilities.setCapability("xcodeSigningId", Get.param(params,"xcodeSigningId"));
			capabilities.setCapability("noReset", false);
			driver = new IOSDriver<MobileElement>(remoteAddress, capabilities);
			break;
		}
		
		Log.passed("Launched the Application successfully");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e1) {
			
		}
		}catch(Exception ex){
			Log.failed("Exception caught while launching the driver ,Message is->"+ex.getMessage());
			throw ex;
		}	
	}
}