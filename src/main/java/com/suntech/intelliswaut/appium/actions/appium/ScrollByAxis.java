package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;

public class ScrollByAxis{

	public void run(HashMap<String, Object> params) throws Exception {

		try {
	
			TouchAction touch = new TouchAction(Driver.driver);
			
			int srcXOffset=Integer.parseInt(Get.param(params,"srcXOffset"));
			int srcYOffset=Integer.parseInt(Get.param(params,"srcYOffset"));
			
			int desXOffset=Integer.parseInt(Get.param(params,"desXOffset"));
			int desYOffset=Integer.parseInt(Get.param(params,"desYOffset"));
			
			touch.longPress(PointOption.point(srcXOffset,srcYOffset)).moveTo(PointOption.point(desXOffset,desYOffset)).release().perform();
			Log.passed("Scrolled by axis");
		
			}

		catch (Exception e) {
			Log.failed("exception caught in the action");
			e.printStackTrace();
			throw e;
		}

	}
}