package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class WaitforPageText {


	public boolean run(HashMap<String, Object> params) throws Exception {
		try{
			int waitTime = Integer.parseInt(params.get("Time").toString());
			String text = params.get("Text").toString();
			WebDriverWait wait=new WebDriverWait(Browser.Driver,Duration.ofSeconds(waitTime) );
			if(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='"+text+"']"))) != null){
	            return true;
	        }else{
	        	return false;
	        }
		}catch(Exception e){
			Log.failed("Exception caught in WaitforPageText Action, Message is "+e.getMessage());	
			return false;
		}	
		
	}
}	
