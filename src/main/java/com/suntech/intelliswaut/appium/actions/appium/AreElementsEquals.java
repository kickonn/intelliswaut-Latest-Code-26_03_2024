package com.suntech.intelliswaut.appium.actions.appium;
import static org.testng.Assert.assertEquals;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class AreElementsEquals {
	public void run(HashMap<String, Object> params) throws Exception {
		try {		
			MobileElement element1 = Elements.find(params, Driver.driver);
			MobileElement element2 = Elements.find(params, Driver.driver);

			if (element1!=null && element2!=null) {
				String elText1 = element1.getText();
				String elText2 = element2.getText();
				boolean value = elText1.equals(elText2);
				System.out.println(value);
				assertEquals(elText1, elText2);
				Log.passed("Elements are equal" + value);
			}
			
		} 
		
catch (Exception e) {
         	//e.printStackTrace();
		Log.failed("Elements are not equal" + e.getMessage());
        	throw e;
		}
	}


}
