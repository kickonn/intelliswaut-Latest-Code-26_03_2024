package com.suntech.intelliswaut.appium.actions.appium;

/**
 * Created by dinkark on 05-Oct-2016
 */
import java.util.HashMap;

import org.openqa.selenium.interactions.Actions;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class SetText {

	public void run(HashMap<String, Object> params) {
		MobileElement element = Elements.find(params, Driver.driver);		

		try {
			element.click();
			element.sendKeys(Get.param(params,"Text"));
		} catch (Exception e) {			
			element = Elements.find(params, Driver.driver);
			element.click();
			Actions action = new Actions(Driver.driver);
			action.sendKeys((Get.param(params,"Text"))).perform();
		}
		Log.passed("Entered the text in the input box successfully  "+ (Get.param(params,"Text")));
		Driver.driver.hideKeyboard();
		if((Get.param(params,"Key")).trim()!="") {
			switch((Get.param(params,"Key")).toUpperCase()) {
			case "ENTER" :
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e1) {
					
				}
				AndroidDriver dr = (AndroidDriver) Driver.driver;
				dr.pressKey(new KeyEvent(AndroidKey.SPACE));
				dr.pressKey(new KeyEvent(AndroidKey.ENTER));				
				//dr.pressKeyCode(66);
				Log.passed("Pressed enter key from keyboard");
				break;
			default :
				break;
			}
		}else {
		}
	}
}
