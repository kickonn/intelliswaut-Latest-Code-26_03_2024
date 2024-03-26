package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;


public class DeleteCookie{
	public void run(HashMap<String, Object> params) throws Exception{
		try{
			String strCookie = Get.param(params, "Cookie Name");
			if(strCookie == "ALL"){
				Browser.Driver.manage().deleteAllCookies();
				Log.passed("Cookies deleted succesfully");
			}else{
				Browser.Driver.manage().deleteCookieNamed(strCookie);
				Log.passed("Cookies deleted succesfully : "+strCookie);
			}
		}catch(Exception ex){
			Log.failed("Exception caught " + ex.getMessage());
			throw ex;
		}
	}
}