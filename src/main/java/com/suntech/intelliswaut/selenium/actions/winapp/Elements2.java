package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.appium.java_client.windows.WindowsDriver;

public class Elements2 {

	public static WebElement find1(HashMap<String, Object> params,
			WindowsDriver<WebElement> Driver) throws Exception {

		By by = null;
		String idType = Get.param(params, "ID Type1");
		String using = Get.param(params, "ID1");
		WebElement foundElement = null;
		if(Driver==null){
			Log.failed("Error Desktop Application is not opened.  Use Open Desktop action.");
		}		
		try{switch(idType){

		case "Class Name":
			foundElement = Driver.findElementByClassName(using);
			break;
		case "Accessibility ID":
			foundElement = Driver.findElementByAccessibilityId(using);
			break;
		case "ID":
			foundElement = Driver.findElementById(using);
			break;
		case "Name":
			foundElement = Driver.findElementByName(using);
			break;
		case "XPath":
			foundElement = Driver.findElementByXPath(using);
			break;
		case "Tag Name":
			foundElement = Driver.findElementByTagName(using);
			break;
		default : 
			foundElement = Driver.findElementByXPath(using);
			break;
		}			

		}catch(Exception ex){			
			Log.failed("Unable to find element with following property "+using);
			throw ex;
		}
		if(foundElement==null){
			Log.failed("Unable to find element with following property "+using);
		}
		return foundElement;

	}
	
	
	public static WebElement find2(HashMap<String, Object> params,
			WindowsDriver<WebElement> Driver) throws Exception {

		By by = null;
		String idType = Get.param(params, "ID Type2");
		String using = Get.param(params, "ID2");
		WebElement foundElement = null;
		if(Driver==null){
			Log.failed("Error Desktop Application is not opened.  Use Open Desktop action.");
		}		
		try{switch(idType){

		case "Class Name":
			foundElement = Driver.findElementByClassName(using);
			break;
		case "Accessibility ID":
			foundElement = Driver.findElementByAccessibilityId(using);
			break;
		case "ID":
			foundElement = Driver.findElementById(using);
			break;
		case "Name":
			foundElement = Driver.findElementByName(using);
			break;
		case "XPath":
			foundElement = Driver.findElementByXPath(using);
			break;
		case "Tag Name":
			foundElement = Driver.findElementByTagName(using);
			break;
		default : 
			foundElement = Driver.findElementByXPath(using);
			break;
		}			

		}catch(Exception ex){			
			Log.failed("Unable to find element with following property "+using);
			throw ex;
		}
		if(foundElement==null){
			Log.failed("Unable to find element with following property "+using);
		}
		return foundElement;

	}

	public static List<WebElement> findAll(HashMap<String, Object> params,
			WindowsDriver<WebElement> Driver) throws Exception {

		List<WebElement> foundElement = null;
		By by = null;
		String idType = Get.param(params, "ID Type");
		String using = Get.param(params, "ID");
		if(Driver==null){
			Log.failed("Error Desktop Application is not opened.  Use Open Desktop action.");
		}		
		try{switch(idType){

		case "Class Name":
			
			foundElement = Driver.findElementsByClassName(using);
			break;
		case "Accessibility ID":
			foundElement = Driver.findElementsByAccessibilityId(using);
			break;
		case "ID":
			foundElement = Driver.findElementsById(using);
			break;
		case "Name":
			foundElement = Driver.findElementsByName(using);
			break;
		case "XPath":
			foundElement = Driver.findElementsByXPath(using);
			break;
		case "Tag Name":
			foundElement = Driver.findElementsByTagName(using);
			break;
		default : 
			foundElement = Driver.findElementsByXPath(using);
			break;
		}			

		}catch(Exception ex){			
			Log.failed("Unable to find element with following property "+using);	
			throw ex;
		}
		if(foundElement==null){
			Log.failed("Unable to find element with following property "+using);
		}
		return foundElement;

	}

}
