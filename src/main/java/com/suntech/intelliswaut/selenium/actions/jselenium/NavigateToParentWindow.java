package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class NavigateToParentWindow {
		public void run(HashMap<String, Object> params) throws Exception {			
			try {
				String parentWindow = Get.param(params, "parentWindow");
				if(parentWindow==""){
					Log.failed("NavigateToParentWindow Action : parentWindow parameter value cant be null, Please provide the value in action");
				}else{
					Browser.Driver.switchTo().window(parentWindow);
					Log.passed("Navigated to parent Window");
				}
			} catch (Exception e) {
				Log.failed("Exception caught in NavigateToParentWindow Action " + e.getMessage());	
				throw e;
			}
		}
	}