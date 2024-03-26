package com.suntech.intelliswaut.utils;

import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import com.suntech.intelliswaut.appium.actions.appium.Driver;
import com.suntech.intelliswaut.appium.actions.appium.Get;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class SwipeAndFindElement {
	public static MobileElement find(HashMap<String, Object> params, AppiumDriver<MobileElement> driver) {
		int noOfTimes = Integer.parseInt(Get.param(params, Constants.NO_OF_TIMES));
		MobileElement element = null;
		MobileElement swipeElement = Elements.find(params, Driver.driver);
		String strPlatform = driver.getPlatformName();
		for (int i = 0; i < noOfTimes; i++) {
			if (strPlatform.equalsIgnoreCase(Constants.ANDROID)) {
				JavascriptExecutor js = (JavascriptExecutor) driver;
				HashMap<String, Object> scrollObject = new HashMap<String, Object>();
				scrollObject.put("direction", "up");
				scrollObject.put("element", (swipeElement).getId());
				js.executeScript("mobile: scroll", scrollObject);
			} else {
				// SwipeElement.swipeUpSlow(swipeElement, driver);
			}
		}
		return element;

	}

	public static boolean isElementPresent(HashMap<String, Object> searchElementParams,
			AppiumDriver<MobileElement> driver) {
		boolean size = Elements.findAll(searchElementParams, driver).size() > 0;
		return size;
	}
}
