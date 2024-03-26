package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.time.Duration;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Wait {

	public static boolean waitForElement(HashMap<String, Object> params){
		try{
			WebDriverWait wait = new WebDriverWait(Browser.Driver, Duration.ofSeconds(5));
			switch (Get.param(params, "ID Type")) {
			case "Class Name":
				wait.until(ExpectedConditions.elementToBeClickable(By.className(Get.param(params, "Class Name"))));	
				break;
			case "Css Selector":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.cssSelector(Get.param(params, "Css Selector"))));	
				break;
			case "ID":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.id(Get.param(params, "ID"))));
				break;
			case "Link Text":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.linkText(Get.param(params, "Link Text"))));
				break;
			case "XPath":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(Get.param(params, "XPath"))));
				break;
			case "Name":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.name(Get.param(params, "Name"))));
				break;
			case "Partial Link Text":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.partialLinkText(Get.param(params, "Partial Link Text"))));
				break;
			case "Tag Name":
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.tagName(Get.param(params, "Tag Name"))));
				break;
			default:
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(5)).until(ExpectedConditions.elementToBeClickable(By.xpath(Get.param(params, "XPath"))));
				return true;
			}
		}catch(Exception e){
			//Log.failed("Exception caught in method waitForElement"+e.getMessage());
			return false;
		}
		return true;
	}
	
	
	public static boolean waitForAlert(){
		try{
			new WebDriverWait(Browser.Driver, Duration.ofSeconds(10)).until(ExpectedConditions.alertIsPresent());			
			return true;
		}catch(Exception Ex){
			return false;
		}
	}
}
