package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class EnterText {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
		WebElement element = Elements.find(params, (WindowsDriver<WebElement>) WindowApp.driver);
		String text =  Get.param(params, "Text");	
			if(params.get("Text") != null) {
				element.clear();//newly inserted
				element.sendKeys(text);
				Log.passed("Entered the text in the input box successfully "+text);
			}
		} catch (Exception e) {
			Log.failed("Exception caught while entering text " + e.getMessage());
			throw e;
		}
	}
}

 