package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.Set;

public class CloseCurrentBrowser {


	public void run(HashMap<String, Object> params) {
		if(Browser.Driver!=null) {
			Browser.Driver.close();
		}
		Set<String> handles = Browser.Driver.getWindowHandles(); 			
		for(String handle : handles)
		{
			Browser.Driver.switchTo().window(handle); 
		}
	}
}
