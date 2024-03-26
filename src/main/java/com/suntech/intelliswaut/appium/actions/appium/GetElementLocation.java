package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import org.openqa.selenium.Point;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;


public class GetElementLocation {
	public Point run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			Point location=element.getLocation();
			Log.passed("Element Located in " + location);
			return location;	
			
		} catch (Exception e) {

			Log.failed("Exception caught " + e.getMessage());
			return null;
		}
	}
}
