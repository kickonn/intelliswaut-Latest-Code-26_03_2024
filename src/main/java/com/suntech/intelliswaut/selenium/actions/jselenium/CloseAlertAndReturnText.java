package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class CloseAlertAndReturnText {
	public String run(HashMap<String, Object> params) throws Exception {
		String alertMessage=null;
		boolean blnAlert = false;
		try{	
			try{
				WebDriverWait wait = new WebDriverWait(Browser.Driver, Duration.ofSeconds(30));
				wait.until(ExpectedConditions.alertIsPresent());
				blnAlert = true;
			}catch(Exception Ex){
				blnAlert = false;
				throw Ex;
			}
			if(blnAlert){
				Alert alert = Browser.Driver.switchTo().alert();
				alertMessage=alert.getText();			
				alert.accept();
				Log.passed("Closed the alert successfully with text->"+alertMessage);
			}
		}catch(Exception Ex){
			Log.failed("Exception Caught while accepting the alert, Message is->"+Ex.getMessage());
			throw Ex;
		}
		return alertMessage;
	}
}
