package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SelectDropDown {
	public void run(HashMap<String, Object> params) throws Exception {		
		WebElement element1 = Elements2.find1(params, (WindowsDriver<WebElement>) WindowApp.driver);
		try{
			String strMain = element1.toString();			
			if(isElementPresent(element1)){
				Actions action = new Actions(WindowApp.driver);
				action.moveToElement(element1).click().perform();			
				Log.passed("Clicked on the dropdown ");
			}else{
				Log.failed("Unable to Click on dropdown(Element is not displayed), Expected Property of element is->"+strMain);
			}
		}catch(Exception Ex){
			Log.failed("Exception Caught while Clicking on dropdwon,Message is->"+Ex.getMessage());
			throw Ex;
		}
		WebElement element2 = Elements2.find2(params, (WindowsDriver<WebElement>) WindowApp.driver);
		try{
			String strSub = element2.toString();
			
			if(isElementPresent(element2)){				
				element2.click();
				Log.passed("Selected the dropdown successfully");
			}else{
				Log.failed("Dropdown element is not displayed, Expected Property of element is->"+strSub);
			}
		}catch(Exception ex){
			Log.failed("Unable to select the dropdown,Exception is->"+ex.getMessage());
			throw ex;
		}	
	}
	
	public boolean isElementPresent(WebElement we) {
		try {
			Thread.sleep(1000);
			we.isDisplayed();
			return true;
		}catch(Exception ex){
			return false;
		}	
	}
}
