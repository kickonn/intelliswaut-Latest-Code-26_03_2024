package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;
import com.suntech.intelliswaut.selenium.actions.reports.TakeScreenshot;

public class ScrollToElement{

	public void run(HashMap<String, Object> params) throws Exception{
		try{
			Wait.waitForElement(params);
			if(Browser.Driver!=null){
				WebElement Element = Elements.find(params, Browser.Driver);
				JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
				js.executeScript("arguments[0].scrollIntoView();", Element);
				Log.passed("Scrolled the browser successfully to the visibility of element");
				TakeScreenshot.takeScreenshot();
			}else{
				Log.failed("Exception caught in ScrollByCoordinates Action. Driver is Null");  
			}
		}catch(Exception e) {
			Log.failed("Exception caught in ScrollByCoordinates Action, Message is "+e.getMessage());
			throw e;
		}
	}
}
