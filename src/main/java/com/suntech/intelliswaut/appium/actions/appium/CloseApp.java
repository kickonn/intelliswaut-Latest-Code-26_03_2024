package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

public class CloseApp {
	public void run(HashMap<String, Object> params) {
		if (Driver.driver != null) {
			Driver.driver.quit();
		}
	}
}