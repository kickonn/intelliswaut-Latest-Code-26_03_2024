package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

public class CloseBrowser {
	
	public void run(HashMap<String, Object> params) {
		if(Browser.Driver!=null) {
			Browser.Driver.quit();
		}
	}
}
