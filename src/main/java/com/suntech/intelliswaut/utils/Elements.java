package com.suntech.intelliswaut.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.appium.actions.appium.Get;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAndroidUIAutomator;
import io.appium.java_client.MobileElement;

public class Elements {

	public static MobileElement find(HashMap<String, Object> params, AppiumDriver<MobileElement> Driver) {
		Assert.assertNotNull("Error Emulator is not opened.  Use Launch Emulator action.", Driver);
		MobileElement foundElement = null;
		String strPlatform = Driver.getPlatformName();
		if (com.suntech.intelliswaut.appium.actions.appium.Driver.type1.equalsIgnoreCase("app")) {
			if (strPlatform.equalsIgnoreCase(Constants.ANDROID)) {
				switch (Get.param(params, Constants.ID_TYPE)) {
				case Constants.CLASS_NAME:
					foundElement = Driver.findElement(ByAndroidUIAutomator.className(Get.param(params, Constants.ID)));
					break;
				case Constants.ID:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params, Constants.ID)));
					break;
				case Constants.XPATH:
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(Get.param(params, Constants.ID)));
					break;
				case Constants.ANDROID_UI_AUTOMATOR:
					foundElement = Driver
							.findElement(ByAndroidUIAutomator.AndroidUIAutomator(Get.param(params, Constants.ID)));
					break;
				case Constants.NAME:
					String xpath = ".//*[contains(@text,'" + Get.param(params, Constants.ID) + "')]";
					foundElement = Driver.findElement(ByAndroidUIAutomator.xpath(xpath));
					break;
				default:
					foundElement = Driver.findElement(ByAndroidUIAutomator.id(Get.param(params, Constants.ID)));
				}

				return foundElement;
			} else {
				switch (Get.param(params, Constants.ID_TYPE)) {
				case Constants.CLASS_NAME:
					foundElement = Driver.findElement(By.className(Get.param(params, Constants.ID)));
					break;
				case Constants.CSS_SELECTOR:
					foundElement = Driver.findElement(By.cssSelector(Get.param(params, Constants.ID)));
					break;
				case Constants.ID:
					foundElement = Driver.findElement(By.id(Get.param(params, Constants.ID)));
					break;
				case Constants.LINK_TEXT:
					foundElement = Driver.findElement(By.linkText(Get.param(params, Constants.ID)));
					break;
				case Constants.XPATH:
					foundElement = Driver.findElement(By.xpath(Get.param(params, Constants.ID)));
					break;
				case Constants.NAME:
					foundElement = Driver.findElement(By.name(Get.param(params, Constants.ID)));
					break;
				case Constants.PARTIAL_LINK_TEXT:
					foundElement = Driver.findElement(By.partialLinkText(Get.param(params, Constants.ID)));
					break;
				case Constants.TAG_NAME:
					foundElement = Driver.findElement(By.tagName(Get.param(params, Constants.ID)));
					break;
				default:
					foundElement = Driver.findElement(By.id(Get.param(params, Constants.ID)));
				}
			}
		} else {
			switch (Get.param(params, Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElement = Driver.findElement(By.className(Get.param(params, Constants.ID)));
				break;
			case Constants.CSS_SELECTOR:
				foundElement = Driver.findElement(By.cssSelector(Get.param(params, Constants.ID)));
				break;
			case Constants.ID:
				foundElement = Driver.findElement(By.id(Get.param(params, Constants.ID)));
				break;
			case Constants.LINK_TEXT:
				foundElement = Driver.findElement(By.linkText(Get.param(params, Constants.ID)));
				break;
			case Constants.XPATH:
				foundElement = Driver.findElement(By.xpath(Get.param(params, Constants.ID)));
				break;
			case Constants.NAME:
				foundElement = Driver.findElement(By.name(Get.param(params, Constants.ID)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElement = Driver.findElement(By.partialLinkText(Get.param(params, Constants.ID)));
				break;
			case Constants.TAG_NAME:
				foundElement = Driver.findElement(By.tagName(Get.param(params, Constants.ID)));
				break;
			default:
				foundElement = Driver.findElement(By.id(Get.param(params, Constants.ID)));
			}
		}
		return foundElement;
	}

	public static List<MobileElement> findAll(HashMap<String, Object> params, AppiumDriver<MobileElement> Driver) {
		Assert.assertNotNull("Error Emulator is not opened.  Use Launch Emulator action.", Driver);

		List<MobileElement> foundElements = new ArrayList<>();
		if (Get.param(params, Constants.APP_TYPE).equals(Constants.ANDROID)) {
			switch (Get.param(params, Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElements = Driver.findElements(ByAndroidUIAutomator.className(Get.param(params, Constants.ID)));
				break;
			case Constants.ID:
				foundElements = Driver.findElements(ByAndroidUIAutomator.id(Get.param(params, Constants.ID)));
				break;
			case Constants.XPATH:
				foundElements = Driver.findElements(ByAndroidUIAutomator.xpath(Get.param(params, Constants.ID)));
				break;
			case Constants.ANDROID_UI_AUTOMATOR:
				foundElements = Driver
						.findElements(ByAndroidUIAutomator.AndroidUIAutomator(Get.param(params, Constants.ID)));
				break;
			case Constants.NAME:
				String xpath = ".//*[contains(@text,'" + Get.param(params, Constants.ID) + "')]";
				foundElements = Driver.findElements(ByAndroidUIAutomator.xpath(xpath));
				break;
			default:
				foundElements = Driver.findElements(ByAndroidUIAutomator.id(Get.param(params, Constants.ID)));
			}

			return foundElements;
		} else if (Get.param(params, Constants.APP_TYPE).equals(Constants.IOS)) {
			switch (Get.param(params, Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElements = Driver.findElements(MobileBy.iOSNsPredicateString(Get.param(params, Constants.ID)));
				break;
			case Constants.ID:
				foundElements = Driver.findElements(MobileBy.iOSNsPredicateString(Get.param(params, Constants.ID)));
				break;
			case Constants.XPATH:
				foundElements = Driver.findElements(MobileBy.iOSClassChain(Get.param(params, Constants.ID)));
				break;
			case Constants.IOS_UI_AUTOMATOR:
				foundElements = Driver.findElements(MobileBy.iOSNsPredicateString(Get.param(params, Constants.ID)));
				break;
			default:
				foundElements = Driver.findElements(MobileBy.iOSNsPredicateString(Get.param(params, Constants.ID)));
			}

			return foundElements;
		} else {
			switch (Get.param(params, Constants.ID_TYPE)) {
			case Constants.CLASS_NAME:
				foundElements = Driver.findElements(By.className(Get.param(params, Constants.ID)));
				break;
			case Constants.CSS_SELECTOR:
				foundElements = Driver.findElements(By.cssSelector(Get.param(params, Constants.ID)));
				break;
			case Constants.ID:
				foundElements = Driver.findElements(By.id(Get.param(params, Constants.ID)));
				break;
			case Constants.LINK_TEXT:
				foundElements = Driver.findElements(By.linkText(Get.param(params, Constants.ID)));
				break;
			case Constants.XPATH:
				foundElements = Driver.findElements(By.xpath(Get.param(params, Constants.ID)));
				break;
			case Constants.NAME:
				foundElements = Driver.findElements(By.name(Get.param(params, Constants.ID)));
				break;
			case Constants.PARTIAL_LINK_TEXT:
				foundElements = Driver.findElements(By.partialLinkText(Get.param(params, Constants.ID)));
				break;
			case Constants.TAG_NAME:
				foundElements = Driver.findElements(By.tagName(Get.param(params, Constants.ID)));
				break;
			default:
				foundElements = Driver.findElements(By.id(Get.param(params, Constants.ID)));
			}

			return foundElements;
		}
	}

}
