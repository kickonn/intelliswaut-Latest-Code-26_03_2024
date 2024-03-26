package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Elements {
	
	public static WebElement findDeskTop(HashMap<String, Object> params,
			WebDriver Driver) throws Exception {
		
		By by = null;
		String idType = Get.param(params, "ID Type");
		String id = Get.param(params, "ID");
		WebElement foundElement = null;
		if(Driver==null){
			Log.failed("Error Desktop Application is not opened.  Use Open Desktop action.");
		}		
		by = getBy(params);
		Assert.assertNotNull(by,
				"Unable to find the element , ID and ID Type cant be null");
		try{			
			foundElement = Driver.findElement(by);
		}catch(Exception ex){			
			Log.failed("Unable to find element with following property "+id);			
			throw ex;
		}
		if(foundElement==null){
			Log.failed("Unable to find element with following property "+id);
		}
		return foundElement;

	}

	public static WebElement find(HashMap<String, Object> params,
			WebDriver Driver) throws Exception {
		
		By by = null;
		String idType = Get.param(params, "ID Type");
		String id = Get.param(params, "ID");
		WebElement foundElement = null;
		if(Driver==null){
			Log.failed("Error browser is not opened.  Use Open Browser action.");
		}		
		by = getBy(params);
		Assert.assertNotNull(by,
				"Unable to find the element , ID and ID Type cant be null");
		try{
			Driver.switchTo().defaultContent();
			foundElement = Driver.findElement(by);
		}catch(Exception ex){
			try{
				SearchByFramesFactory searchFactory = new SearchByFramesFactory(Driver);
				SearchByFrames searchInFrame = searchFactory.search(by);
		        Optional<WebElement> elem = searchInFrame.getElem();
		        if(elem.isPresent()){
		        	Log.info("Element found inside Frames");
		        	foundElement = elem.get();
		        }else{
		        	foundElement = null;
		        }
			}catch(Exception e){
				Log.failed("Unable to find element with following property "+id);
				throw e;
			}
			throw ex;
		}
		if(foundElement==null){
			Log.failed("Unable to find element with following property "+id);
		}
		return foundElement;

	}

	public static List<WebElement> findAll(HashMap<String, Object> params,
			WebDriver Driver) throws Exception {

		List<WebElement> foundElement = null;
		By by = null;
		String idType = Get.param(params, "ID Type");
		String id = Get.param(params, "ID");
		if(Driver==null){
			Log.failed("Error browser is not opened.  Use Open Browser action.");
		}		
		by = getBy(params);
		Assert.assertNotNull(by,
				"Unable to find the element , ID and ID Type cant be null");
		try{
			foundElement = Driver.findElements(by);
		}catch(Exception ex){
			Log.failed("Unable to find element with following property "+id);
			throw ex;
		}
		if(foundElement.size()==0){
			Log.failed("Unable to find element with following property "+id);
		}
		return foundElement;

	}
	
	public static By getBy(HashMap<String, Object> params) throws Exception{
		By by = null;
		String idType = Get.param(params, "ID Type");
		String id = Get.param(params, "ID");
		if(id==null){
			Log.failed("ID parameter cant be empty for Finding element, Please include the same in action");
			return null;
		}
		switch(idType){
		
		case "Class Name":
			by = By.className(id);
			break;
		case "Css Selector":
			by = By.cssSelector(id);
			break;
		case "ID":
			by = By.id(id);
			break;
		case "Link Text":
			by = By.linkText(id);
			break;
		case "XPath":
			by = By.xpath(id);
			break;
		case "Name":
			by = By.name(id);
			break;
		case "Partial Link Text":
			by = By.partialLinkText(id);
			break;
		case "Tag Name":
			by = By.tagName(id);
			break;
			default : 
				by = By.xpath(id);
				break;
		}
		return by;
	}

}
