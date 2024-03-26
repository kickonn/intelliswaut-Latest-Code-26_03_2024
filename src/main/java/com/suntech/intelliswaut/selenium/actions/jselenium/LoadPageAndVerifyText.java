package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.apache.commons.lang3.time.StopWatch;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class LoadPageAndVerifyText {
	public void run(HashMap<String, Object> params) throws Exception {
	//String text = null;
	try{
	    //WebDriver driver;
	    StopWatch pageLoad = new StopWatch();
            pageLoad.start();
           
            String url =  Get.param(params, "Page URL");
	    Browser.Driver.navigate().to(url);
	    //driver.get(url);
            String text = params.get("Text").toString();
           
            WebDriverWait wait = new WebDriverWait(Browser.Driver, Duration.ofSeconds(30));
            if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+text+"']"))) != null)
	        
            pageLoad.stop();
            
            long pageLoadTime_ms = pageLoad.getTime();
            long pageLoadTime_Seconds = pageLoadTime_ms / 1000;

            Log.passed("Navigated to the URL : "+ url + " successfully and total Page Load Time: " + pageLoadTime_ms + " milliseconds /" + pageLoadTime_Seconds + " seconds");
           // Log.passed("Navigated to the URL : "+ url + " successfully and total Page Load Time: " + pageLoadTime_Seconds + " seconds");
			
			
		}catch (Exception e) {	
			Log.failed("Exception caught in PageLoad Action " + e.getMessage());
			throw e;
		}
	}
}
