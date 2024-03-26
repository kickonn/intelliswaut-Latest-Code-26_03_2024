package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public	class Refresh{
	 public void run(HashMap<String, Object> params) throws Exception{
		 
     try{
		Thread.sleep(2000);
		 Browser.Driver.navigate().refresh();
         Log.passed("Page refreshed successfully");		    
	  }catch(Exception e) {
			Log.failed("Exception caught while Refreshing the page, Message is "+e.getMessage());
			throw e;
		}
	}
}
