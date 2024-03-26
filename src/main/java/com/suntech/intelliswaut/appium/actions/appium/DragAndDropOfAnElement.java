package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class DragAndDropOfAnElement{
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement element1 = Elements.find(params, Driver.driver);
			MobileElement element2 = Elements.find(params, Driver.driver);
			TouchAction action = new TouchAction(Driver.driver);
			 action.longPress(ElementOption.element(element1))
	   		 .waitAction()
		         .moveTo(ElementOption.element(element2))
		         .release()
		         .perform();
					
			Log.passed("Drag and drop is performed on element");

		} catch (Exception e) {
			
			Log.failed("Drag and drop is not performed on element" + e.getMessage());
			throw e;
			//e.printStackTrace();
		}
	}
}
