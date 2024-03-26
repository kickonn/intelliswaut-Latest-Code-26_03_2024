package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class DoubleClick {
		public void run(HashMap<String, Object> params) throws Exception {
			try {
				Wait.waitForElement(params);
				WebElement element = Elements.find(params, Browser.Driver);
				String elementName = Get.param(params, "Element Name");
				((JavascriptExecutor) Browser.Driver).executeScript("arguments[0].scrollIntoView();", element);

				doubleClick(element,elementName);

			} catch (Exception e) {
				Log.failed("Exception caught in Double click Action " + e.getMessage());
				throw e;
			}
		}

		public void doubleClick(WebElement element,String elementName) throws Exception {
			try {
				Actions action = new Actions(Browser.Driver).doubleClick(element);
				action.build().perform();
				Log.passed("Successfully double clicked on element : "+elementName );
			} catch (Exception e) {
				Log.failed("Exception caught in Double click Action " + e.getMessage());
				throw e;
			}
		}
	}

