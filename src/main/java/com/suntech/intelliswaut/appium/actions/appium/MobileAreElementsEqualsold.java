package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;

public class MobileAreElementsEqualsold {
	public void run(HashMap<String, Object> params) throws Exception {
		try {		
			MobileElement element1 = Elements.find(params, Driver.driver);
			MobileElement element2 = Elements.find(params, Driver.driver);

			String Text1 = element1.getText();
			String Text2 = element2.getText();

			if (Text1!=null && Text2!=null) {
				
				boolean value = Text1.equals(Text2);
				Log.passed("Elements are equal" + value );
			}
			else {
				Log.failed("Element "+Text1+" does not match with "+Text2 );
			} 
		}
			catch (Exception e) {
			Log.failed("Elements are not equal" + e.getMessage());
        	throw e;
			}
	}
}
