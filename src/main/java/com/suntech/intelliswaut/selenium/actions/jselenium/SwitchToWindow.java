package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.Set;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class SwitchToWindow {


	public boolean run(HashMap<String, Object> params) throws Exception {
		boolean blnNavigate = false;
		try{
			if(Browser.Driver!=null) {
				String mainWindowsHandle; 
				mainWindowsHandle = Browser.Driver.getWindowHandle();
				Set<String> handles = Browser.Driver.getWindowHandles(); 			
				for(String handle : handles)
				{
					Browser.Driver.switchTo().window(handle); 
					if(Get.param(params,"Title")!=""){
						if(Browser.Driver.getTitle().equals(Get.param(params,"Title")!="")) {
							Log.passed("Navigated to the new window with title "+Get.param(params,"Title"));
							blnNavigate= true; 
						}else{
							blnNavigate = false;
						}
					}else if(Get.param(params,"URL").toString()!=""){
						if(Browser.Driver.getCurrentUrl().equals(Get.param(params,"URL").toString())) {
							Log.passed("Navigated to the new window with URL "+Get.param(params,"URL").toString());
							blnNavigate=  true; 
						}else{                        
							blnNavigate = false;
						}
					}else if(Get.param(params,"Handle").toString()!=null){
						if(Browser.Driver.getWindowHandle().equals(Get.param(params,"Handle").toString())) {
							Log.passed("Navigated to the new window with Window handle "+Get.param(params,"Handle").toString());
							blnNavigate=  true; 
						}else{                        
							blnNavigate = false;
						}
					}else{
						Log.failed("Parameters passed to the action is not valid, Valid parameters are URL or Title or Handle");						
					}
				}			
			}
			if(!blnNavigate){				
				Log.failed("Unable to navigate to the window with provided URl/title/Handle");				
				return false;
			}
		} catch (Exception e) {
			Log.failed("Exception caught in SwitchToWindow Action, Message is "+e.getMessage());
			throw e;
		}
		return blnNavigate;
	}
}
