package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.ElementOption;

public class ZoomOnElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			MobileElement map = Elements.find(params, Driver.driver);

			Thread.sleep(4000);

			final int x1 = map.getLocation().getX();
			final int y1 = map.getLocation().getY();

			System.out.println("x is " + x1 + "y1 is " + y1);

			final int x = map.getLocation().getX() + map.getSize().getWidth() / 2;
			final int y = map.getLocation().getY() + map.getSize().getHeight() / 2;

			//Log.info("Now zooming");
			final TouchAction finger1 = new TouchAction(Driver.driver);
			finger1.press(ElementOption.element(map, x, y - 10)).moveTo(ElementOption.element(map, x, y - 100));

			final TouchAction finger2 = new TouchAction(Driver.driver);

			finger2.press(ElementOption.element(map, x, y + 10)).moveTo(ElementOption.element(map, x, y + 100));

			final MultiTouchAction action = new MultiTouchAction(Driver.driver);
			action.add(finger1).add(finger2).perform();

			Log.info("Zoom Done");
			Thread.sleep(3000);
		} catch (Exception e) {

			Log.failed("Element not found");
			throw e;
		}
	}
}
