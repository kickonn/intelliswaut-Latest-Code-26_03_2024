package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SetText {
		public void run(HashMap<String, Object> params) throws Exception {
			try {
				WebElement element = Elements.find(params, Browser.Driver);
				String eleName = Get.param(params,"ElementName");
				element.clear();
				element.sendKeys(Get.param(params,"Text"));
				Log.passed("Entered the text " + Get.param(params,"Text") + " to element " + eleName);
			} catch (Exception e) {
				Log.failed("Exception caught in Set text method" + e.getMessage());
				throw e;
			}

		}
	}