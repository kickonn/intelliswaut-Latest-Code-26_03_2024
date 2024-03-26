package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.TimeZone;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class EnterDate {
	public String run(HashMap<String, Object> params) throws Exception {
		try{
			WebElement element = Elements.find(params, Browser.Driver);
			String date = Get.param(params, "Date");
			String dateExpression = Get.param(params, "Add");
			if(dateExpression.trim()=="") {
				dateExpression = "0";
			}
			int addDate = 0;
			Calendar c = null;
			try {
				addDate = Integer.parseInt(dateExpression);
			} catch (NumberFormatException e) {
				Log.failed("Add parameter : Only Integer should be passed in Add parameter" + e.getMessage());				
			}
			if(date.toLowerCase().contains("today")) {
				c = Calendar.getInstance();
				c.setTime(new Date());
			}else {
				try {
					c = Calendar.getInstance(TimeZone.getTimeZone("CST"));
					c.setTime(new Date(date));
				} catch (Exception e) {
					Log.failed("Date paramter : Only valid date should be passed as an argument in this field");
					return "";
				} 
			}
			
			c.add(Calendar.DATE, addDate);
			SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
			format.setTimeZone(TimeZone.getTimeZone("CST"));
			String dateToEnter = format.format(c.getTime());			
			element.clear();
			element.sendKeys(dateToEnter);
			Log.passed("Entered the date in the input box successfully : "+dateToEnter);
			return dateToEnter;
		} catch (Exception e) {
			Log.failed("Exception caught in SendKeys method" + e.getMessage());
			return "";
		}
	}
}

