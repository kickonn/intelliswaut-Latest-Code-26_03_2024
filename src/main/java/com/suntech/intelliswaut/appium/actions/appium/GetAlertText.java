package com.suntech.intelliswaut.appium.actions.appium;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class GetAlertText {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement AlertElement = Elements.find(params, Driver.driver);
			Log.info("Alert text is " + AlertElement.getText());
		} catch (Exception e) {

			Log.failed("Exception caught in Alert Text");
			throw e;
		}
	}
}
