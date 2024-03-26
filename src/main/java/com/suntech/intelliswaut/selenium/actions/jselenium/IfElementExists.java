package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

public class IfElementExists {
	public boolean run(HashMap<String, Object> params) {		
		try{			
			WebElement element1 = Elements.find(params, Browser.Driver);
			Thread.sleep(1000);
			element1.isDisplayed();			
			return true;
		}catch(Exception ex){			
			return false;
		}	
	}

}
