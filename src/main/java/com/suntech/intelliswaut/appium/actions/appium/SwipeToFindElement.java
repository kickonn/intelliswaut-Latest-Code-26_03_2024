package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import org.junit.Assert;
import org.openqa.selenium.Dimension;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;
import com.suntech.intelliswaut.utils.SwipeElement;

import io.appium.java_client.MobileElement;


public class SwipeToFindElement {
	public void run(HashMap<String, Object> params) {
		try {
			
		MobileElement element = Elements.find(params, Driver.driver);	
		Assert.assertNotNull(element);
		String ele = (Get.param(params,"Element Name"));
		Dimension size = Driver.driver.manage().window().getSize();
		SwipeElement.swipeScreen(size,ele, Driver.driver);
		Assert.assertTrue(element.isDisplayed());
		Log.passed("Swipe is done to find element");
	}
	catch(Exception e) {
		Log.info(e.getMessage());
}
	
}
	
}
