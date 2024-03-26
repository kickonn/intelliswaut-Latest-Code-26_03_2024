package com.suntech.intelliswaut.utils;


import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.By;

import com.suntech.intelliswaut.appium.actions.appium.Get;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;
public class Elements2 {

	public static MobileElement find1(HashMap<String, Object> params, AppiumDriver<MobileElement> Driver) {
		Assert.assertNotNull("Error Emulator is not opened.  Use Launch Emulator action.", Driver);
		MobileElement foundElement = null;
		 String strPlatform = Driver.getPlatformName();
		 if(com.suntech.intelliswaut.appium.actions.appium.Driver.type1.equalsIgnoreCase("app")){
			if (strPlatform.equalsIgnoreCase(Constants.ANDROID)) {
				switch (Get.param(params,Constants.ID_TYPE)) {
				case Constants.CLASS_NAME:
					foundElement = Driver.findElement(ByAndroidUIAutomator.className(Get.param(params,Constants.ID1)));
					break;
				case Constants.ID:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params,Constants.ID1)));
					break;
				case Constants.XPATH:
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(Get.param(params,Constants.ID1)));
					break;
				case Constants.ANDROID_UI_AUTOMATOR:
					foundElement = Driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator(Get.param(params,Constants.ID1)));
					break;
				case Constants.NAME:
					String xpath = ".//*[contains(@text,'" + Get.param(params,Constants.ID1) + "')]";
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(xpath));
					break;
				default:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params,Constants.ID1)));
				}

				return foundElement;

			} else if (strPlatform.equalsIgnoreCase(Constants.IOS)) {
					switch (Get.param(params,Constants.ID_TYPE)) {
					case Constants.CLASS_NAME:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID1)));
						break;
					case Constants.ID:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID1)));
						break;
					case Constants.XPATH:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID1)));
						break;
					case Constants.IOS_UI_AUTOMATOR:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID1)));
						break;
					default:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID1)));
					}

				return foundElement;
		} else {
			switch (Get.param(params,Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElement = Driver.findElement(By.className(Get.param(params,Constants.ID1)));
				break;
			case Constants.CSS_SELECTOR:
				foundElement = Driver.findElement(By.cssSelector(Get.param(params,Constants.ID1)));
				break;
			case Constants.ID:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID1)));
				break;
			case Constants.LINK_TEXT:
				foundElement = Driver.findElement(By.linkText(Get.param(params,Constants.ID1)));
				break;
			case Constants.XPATH:
				foundElement = Driver.findElement(By.xpath(Get.param(params,Constants.ID1)));
				break;
			case Constants.NAME:
				foundElement = Driver.findElement(By.name(Get.param(params,Constants.ID1)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElement = Driver.findElement(By.partialLinkText(Get.param(params,Constants.ID1)));
				break;
			case Constants.TAG_NAME:
				foundElement = Driver.findElement(By.tagName(Get.param(params,Constants.ID1)));
				break;
			default:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID1)));
			}
		}
		 }else{
			switch (Get.param(params,Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElement = Driver.findElement(By.className(Get.param(params,Constants.ID1)));
				break;
			case Constants.CSS_SELECTOR:
				foundElement = Driver.findElement(By.cssSelector(Get.param(params,Constants.ID1)));
				break;
			case Constants.ID:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID1)));
				break;
			case Constants.LINK_TEXT:
				foundElement = Driver.findElement(By.linkText(Get.param(params,Constants.ID1)));
				break;
			case Constants.XPATH:
				foundElement = Driver.findElement(By.xpath(Get.param(params,Constants.ID1)));
				break;
			case Constants.NAME:
				foundElement = Driver.findElement(By.name(Get.param(params,Constants.ID1)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElement = Driver.findElement(By.partialLinkText(Get.param(params,Constants.ID1)));
				break;
			case Constants.TAG_NAME:
				foundElement = Driver.findElement(By.tagName(Get.param(params,Constants.ID1)));
				break;
			default:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID1)));
			}
		}

			return foundElement;
		
	}
public static MobileElement find2(HashMap<String, Object> params, AppiumDriver<MobileElement> Driver) {
		Assert.assertNotNull("Error Emulator is not opened.  Use Launch Emulator action.", Driver);
		MobileElement foundElement = null;
		 String strPlatform = Driver.getPlatformName();
		 if(com.suntech.intelliswaut.appium.actions.appium.Driver.type1.equalsIgnoreCase("app")){
			if (strPlatform.equalsIgnoreCase(Constants.ANDROID)) {
				switch (Get.param(params,Constants.ID_TYPE)) {
				case Constants.CLASS_NAME:
					foundElement = Driver.findElement(ByAndroidUIAutomator.className(Get.param(params,Constants.ID2)));
					break;
				case Constants.ID:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params,Constants.ID2)));
					break;
				case Constants.XPATH:
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(Get.param(params,Constants.ID2)));
					break;
				case Constants.ANDROID_UI_AUTOMATOR:
					foundElement = Driver.findElement(ByAndroidUIAutomator.AndroidUIAutomator(Get.param(params,Constants.ID2)));
					break;
				case Constants.NAME:
					String xpath = ".//*[contains(@text,'" + Get.param(params,Constants.ID2) + "')]";
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(xpath));
					break;
				default:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params,Constants.ID2)));
				}

				return foundElement;

			} else if (strPlatform.equalsIgnoreCase(Constants.IOS)) {
					switch (Get.param(params,Constants.ID_TYPE)) {
					case Constants.CLASS_NAME:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID2)));
						break;
					case Constants.ID:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID2)));
						break;
					case Constants.XPATH:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID2)));
						break;
					case Constants.IOS_UI_AUTOMATOR:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID2)));
						break;
					default:
						foundElement = Driver.findElement(MobileBy.iOSNsPredicateString(Get.param(params,Constants.ID2)));
					}

				return foundElement;
		} else {
			switch (Get.param(params,Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElement = Driver.findElement(By.className(Get.param(params,Constants.ID2)));
				break;
			case Constants.CSS_SELECTOR:
				foundElement = Driver.findElement(By.cssSelector(Get.param(params,Constants.ID2)));
				break;
			case Constants.ID:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID2)));
				break;
			case Constants.LINK_TEXT:
				foundElement = Driver.findElement(By.linkText(Get.param(params,Constants.ID2)));
				break;
			case Constants.XPATH:
				foundElement = Driver.findElement(By.xpath(Get.param(params,Constants.ID2)));
				break;
			case Constants.NAME:
				foundElement = Driver.findElement(By.name(Get.param(params,Constants.ID2)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElement = Driver.findElement(By.partialLinkText(Get.param(params,Constants.ID2)));
				break;
			case Constants.TAG_NAME:
				foundElement = Driver.findElement(By.tagName(Get.param(params,Constants.ID2)));
				break;
			default:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID2)));
			}
		}
		 }else{
			switch (Get.param(params,Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElement = Driver.findElement(By.className(Get.param(params,Constants.ID2)));
				break;
			case Constants.CSS_SELECTOR:
				foundElement = Driver.findElement(By.cssSelector(Get.param(params,Constants.ID2)));
				break;
			case Constants.ID:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID2)));
				break;
			case Constants.LINK_TEXT:
				foundElement = Driver.findElement(By.linkText(Get.param(params,Constants.ID2)));
				break;
			case Constants.XPATH:
				foundElement = Driver.findElement(By.xpath(Get.param(params,Constants.ID2)));
				break;
			case Constants.NAME:
				foundElement = Driver.findElement(By.name(Get.param(params,Constants.ID2)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElement = Driver.findElement(By.partialLinkText(Get.param(params,Constants.ID2)));
				break;
			case Constants.TAG_NAME:
				foundElement = Driver.findElement(By.tagName(Get.param(params,Constants.ID2)));
				break;
			default:
				foundElement = Driver.findElement(By.id(Get.param(params,Constants.ID2)));
			}
		}

			return foundElement;
		
	}
	

}
