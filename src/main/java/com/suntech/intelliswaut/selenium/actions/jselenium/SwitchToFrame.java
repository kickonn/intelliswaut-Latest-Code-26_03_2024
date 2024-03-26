package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class SwitchToFrame {


	public void run(HashMap<String, Object> params) throws Exception {
		boolean blnNavigate = false;
		try{
			switch (Get.param(params, "Visible Text").toString()) {
			case "ID":
				Browser.Driver.switchTo().frame(Get.param(params, "ID Value").toString());	
				break;
			case "Name":
				Browser.Driver.switchTo().frame(Get.param(params, "ID Value").toString());	
				break;
			case "Index":
				Browser.Driver.switchTo().frame(Integer.parseInt(Get.param(params, "ID Value").toString()));
				break;
			case "XPATH":
				WebElement we = Browser.Driver.findElement(By.xpath(Get.param(params, "ID Value").toString()));
				Browser.Driver.switchTo().frame(we);
				break;
			default:
				Browser.Driver.switchTo().frame(Get.param(params, "ID Value").toString());
			}
		} catch (Exception e) {
			Log.failed("Exception caught in SwitchToFrame Action, Message is "+e.getMessage());
			throw e;
		}
	}
}
