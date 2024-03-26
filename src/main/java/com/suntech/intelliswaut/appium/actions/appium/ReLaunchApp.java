package com.suntech.intelliswaut.appium.actions.appium;
/**
 * Created by dinkark on 03-Oct-2016
 */
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class ReLaunchApp {
	public void run(HashMap<String, Object> params) throws Exception {
		try{
			if (Driver.driver != null) {
			Driver.driver.launchApp();
			Log.passed("Relaunched the Application");
		}

		} catch (Exception e) {
			Log.failed(e.getMessage());
			throw e;
			//e.printStackTrace();
		}
	}
}