package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SetRadiobutton {
		public boolean run(HashMap<String, Object> params) throws Exception {
			boolean flg = false;
			try {

				List<WebElement> radiobuttons = Elements.findAll(params, Browser.Driver);
				int radioCount = radiobuttons.size();

				for (int i = 0; i < radioCount; i++) {
					String radiotextvalue = radiobuttons.get(i).getAttribute("value");

					if (Get.param(params,"Text").equalsIgnoreCase(radiotextvalue)) {
						radiobuttons.get(i).click();
						Log.passed("The value of selected radiogroup is " + radiotextvalue );
						flg = true;
					}
				}
			} catch (Exception e) {
				Log.failed("Exception caught while Setting the Radiobutton, Message is " + e.getMessage());
				return false;
			}
			return flg;
		}
		public boolean isElementPresent(WebElement we) {
		try {
			Thread.sleep(1000);
			we.isDisplayed();
			Log.passed("Element is displayed");
			return true;
		}catch(Exception ex){
			return false;
		}	
	}
	}