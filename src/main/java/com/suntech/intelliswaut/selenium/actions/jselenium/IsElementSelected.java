package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;


public class IsElementSelected {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			WebElement element = Elements.find(params, Browser.Driver);
			Log.passed("Element is selected " +  element.isSelected());
		} catch (Exception e) {

			Log.failed(e.getMessage());
			//return (Boolean) null;
			throw e;
		}
	}
}
