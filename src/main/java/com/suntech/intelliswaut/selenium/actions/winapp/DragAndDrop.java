package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;

import io.appium.java_client.windows.WindowsDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.suntech.intelliswaut.selenium.actions.reports.Log;



public class DragAndDrop {
	public void run(HashMap<String, Object> params) throws Exception {
		
		WebElement element1 = Elements2.find1(params, (WindowsDriver<WebElement>) WindowApp.driver);
		WebElement element2 = Elements2.find2(params, (WindowsDriver<WebElement>) WindowApp.driver);
		try{
			if(!isElementPresent(element1)){
				Log.failed("Unable to perform DragAndDrop ,Source element is not displayed");
				return;
			}
			if(!isElementPresent(element2)){
				Log.failed("Unable to perform DragAndDrop, Destination element is not displayed");
				return;
			}
			
			new Actions(WindowApp.driver).dragAndDrop(element1, element2).perform();
			Log.passed("Dragged Source element and droped on Destination Element Successfully");
		}catch(Exception ex){
			Log.failed("Exception caught in Drag and Drop action "+ex.getMessage());
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
