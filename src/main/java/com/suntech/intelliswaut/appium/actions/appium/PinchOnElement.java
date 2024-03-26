package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class PinchOnElement {
	
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement map = Elements.find(params, Driver.driver);
			Thread.sleep(40000);

			final int x1 = map.getLocation().getX();
			final int y1 = map.getLocation().getY();

			final int x = map.getLocation().getX() + map.getSize().getWidth() / 2;
			final int y = map.getLocation().getY() + map.getSize().getHeight() / 2;

			
			final TouchAction finger1= new TouchAction(Driver.driver);
			
			finger1.press(ElementOption.element(map, x, y-100)).moveTo(ElementOption.element(map, x, y-10));

			final TouchAction finger2= new TouchAction(Driver.driver);
			
			finger2.press(ElementOption.element(map, x, y+100)).moveTo(ElementOption.element(map, x, y+10));

			final MultiTouchAction action2= new MultiTouchAction(Driver.driver);
			action2.add(finger1).add(finger2).perform();
			Thread.sleep (3000);
			Log.passed("Pinching Done");
			Thread.sleep(3000);
		} catch (Exception e) {

			Log.failed(e.getMessage());
			throw e;
		}
	}
}
