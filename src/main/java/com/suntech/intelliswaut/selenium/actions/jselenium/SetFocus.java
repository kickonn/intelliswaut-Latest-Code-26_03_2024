package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SetFocus {
		public void run(HashMap<String, Object> params) throws Exception {
			try {
			WebElement element = Elements.find(params, Browser.Driver);
			String elemName = Get.param(params, "Element Name").toString();
			
				if (element.getTagName() == "input") {
					element.sendKeys("");
					Log.passed("Focused on element  " + elemName + " Successfully");
				} else {
					new Actions(Browser.Driver).moveToElement(element).perform();
					Log.passed("Focused on element  " + elemName + " Successfully");

				}

			} catch (Exception e) {
				Log.failed("Exception caught in SetFocus, Message is " + e.getMessage());
				throw e;
			}
		}
	}
