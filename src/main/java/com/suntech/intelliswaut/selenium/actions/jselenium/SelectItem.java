package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SelectItem {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
			WebElement element = Elements.find(params, Browser.Driver);
			if(Get.param(params, "Visible Text")!=""){
		    	new Select(element).selectByVisibleText(Get.param(params, "Visible Text")); 
		    	Log.passed("Selected the Element with visible text from dropdown : "+Get.param(params, "Visible Text"));
		    }
		    else if(Get.param(params, "Value")!=""){
		    	new Select(element).selectByValue(Get.param(params, "Value"));
		    	Log.passed("Selected the Element with value from dropdown : "+Get.param(params, "Value"));
		    }
		    else if(Get.param(params, "Index")!=""){
		    	new Select(element).selectByIndex(Integer.parseInt(Get.param(params, "Index")));
		    	Log.passed("Selected the Element by index from dropdown : "+Get.param(params, "Index"));
		    }
		} catch (Exception e) {
			Log.failed("Exception caught in SelectItem Action, Message is "+e.getMessage());
			throw e;
		}
		
	}
}
