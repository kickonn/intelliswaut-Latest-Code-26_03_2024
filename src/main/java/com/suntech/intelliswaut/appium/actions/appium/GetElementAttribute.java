package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class GetElementAttribute {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element = Elements.find(params, Driver.driver);
			String attributeName=(Get.param(params,"Attribute Name"));
			Log.info("Attribute name is" +  element.getAttribute(attributeName));
		} catch (Exception e) {

			Log.failed(e.getMessage());
			//return null;
			throw e;
		}
	}
}
