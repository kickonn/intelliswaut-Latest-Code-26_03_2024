package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class RightClick {
	public void run(HashMap<String, Object> params) throws Exception {		
			try {
				Wait.waitForElement(params);
				WebElement element = Elements.find(params, Browser.Driver);	
				Actions actions = new Actions(Browser.Driver);
				actions.moveToElement(element);
				actions.contextClick(element);
				actions.perform();
				Log.passed("Right Clicked on the Element");				
			} catch (Exception e) {
				Log.failed("Exception caught in RightClick Action, Message is "+e.getMessage());
				throw e;
			}
	}
}
