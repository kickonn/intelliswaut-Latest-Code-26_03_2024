package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

public class GetWindowHandle {
	public String run(HashMap<String, Object> params) {
			try {
				return Browser.Driver.getWindowHandle();				
			} catch (Exception err) {
				return "";
			}
	}
}
