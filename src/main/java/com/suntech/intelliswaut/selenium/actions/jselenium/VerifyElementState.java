package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class VerifyElementState {
		public void run(HashMap<String, Object> params) throws Exception {
			try {
				WebElement element = Elements.find(params, Browser.Driver);
				String elemName = Get.param(params,"Element Name").toString();
				String VerifyElementState = Get.param(params,"Is Enabled").toString();
				Boolean boolState = Boolean.parseBoolean(VerifyElementState);
				Boolean ElementState = element.isEnabled();
				int b3 = Boolean.compare(boolState, ElementState);
				if (b3 == 0)
					Log.passed("Expected enabled state  match with current element state : " + elemName);
				else
					Log.failed("Expected enabled state  match with current element state: " + elemName);
			} catch (Exception e) {
				Log.failed("Exception caught in element state, Message is " + e.getMessage());
				throw e;
			}
		}
	}