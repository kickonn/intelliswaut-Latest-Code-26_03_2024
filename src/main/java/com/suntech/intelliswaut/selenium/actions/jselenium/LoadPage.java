package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.apache.commons.lang3.time.StopWatch;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class LoadPage {
	public void run(HashMap<String, Object> params) throws Exception {
	
	try{
	    StopWatch pageLoad = new StopWatch();
            pageLoad.start();
            String url =  Get.param(params, "Page URL");
	    Browser.Driver.navigate().to(url);    
            pageLoad.stop();
            long pageLoadTime_ms = pageLoad.getTime();
            long pageLoadTime_Seconds = pageLoadTime_ms / 1000;
	    Log.passed("Navigated to the URL : "+ url + " successfully and total Page Load Time: " + pageLoadTime_ms + " milliseconds /" + pageLoadTime_Seconds + " seconds");
           // Log.passed("Total Page Load Time: " + pageLoadTime_ms + " milliseconds");

	}catch (Exception e) {	
	    Log.failed("Exception caught in PageLoad Action " + e.getMessage());
		throw e;	
		}
	}
}
