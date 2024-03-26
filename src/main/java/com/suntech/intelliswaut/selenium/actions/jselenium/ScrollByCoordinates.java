package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;

import org.openqa.selenium.JavascriptExecutor;

import com.suntech.intelliswaut.selenium.actions.reports.Log;
import com.suntech.intelliswaut.selenium.actions.reports.TakeScreenshot;

public class ScrollByCoordinates{

	public void run(HashMap<String, Object> params) throws Exception{
		try{
			String x = Get.param(params, "x");
			String y = Get.param(params, "y");
			if(x==""){
				x="0";
			}
			if(y==""){
				y="800";
			}
			if(Browser.Driver!=null){
				JavascriptExecutor js = (JavascriptExecutor) Browser.Driver;
				js.executeScript("window.scrollBy("+x+","+y+")", "");
				Log.passed("Scroll browser successfull to the coordinates ("+x+","+y+")");
				TakeScreenshot.takeScreenshot();
			}else{
				Log.failed("Exception caught in ScrollByCoordinates Action. Driver is Null");  
			}
		}catch(Exception e) {
			Log.failed("Exception caught in ScrollByCoordinates Action, Message is "+e.getMessage());
			throw e;
		}
	}
}
