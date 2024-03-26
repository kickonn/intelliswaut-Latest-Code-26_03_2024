package com.suntech.intelliswaut.appium.actions.appium;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

import java.time.Duration;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.TouchAction;

public class TapByCoordinates {

	public void run(HashMap<String,Object> params) throws Exception {
		try {
		TouchAction action = new TouchAction(Driver.driver);
		int x=Integer.parseInt(Get.param(params,"x"));
		int y=Integer.parseInt(Get.param(params,"y"));
		action .tap(point(x,y)).waitAction(waitOptions(Duration.ofMillis(250))).perform();
        Thread.sleep(2000);
	    Log.passed("Tap action performed by coordinates");
	}catch(Exception e){
		Log.failed("exception caught in while swipe by co-ordinates");
		throw e;
		}
	}
}
