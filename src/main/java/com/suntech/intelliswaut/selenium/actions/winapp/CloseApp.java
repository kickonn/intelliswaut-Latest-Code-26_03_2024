package com.suntech.intelliswaut.selenium.actions.winapp;

import java.util.HashMap;

public class CloseApp {
	
	public void run(HashMap<String, Object> params) {
		if(WindowApp.driver!=null) {
			WindowApp.driver.quit();
		}
	}
}
