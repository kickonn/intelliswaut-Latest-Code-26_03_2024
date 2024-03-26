package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;



public class NavigateURL {

	public void run(HashMap<String, Object> params) throws Exception {
		try{
			if(Browser.Driver!=null) {
				String url = Get.param(params, "URL");
				if(url!="") {
					Browser.Driver.navigate().to(url);
					Log.passed("Navigated to the URL : "+url + " successfully");
				}else {
					Log.failed("URL Passed to the action Navigate to URL is empty, Please pass the valid URL as parameter");					
				}
			}
		}catch (Exception e) {	
			Log.failed("Exception caught in NavigateURL Action " + e.getMessage());
			throw e;
		}
		}
	}
