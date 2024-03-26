package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import org.openqa.selenium.Dimension;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Constants;
import com.suntech.intelliswaut.utils.SwipeElement;


public class Swipe {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			
		}
		try{
        int noOfTimes = Integer.parseInt((Get.param(params,Constants.NO_OF_TIMES)));
		String Direction = (Get.param(params,"Direction"));
		Dimension size = Driver.driver.manage().window().getSize();
		
        for (int i = 0; i < noOfTimes; i++) {
			SwipeElement.swipeScreen(size,Direction, Driver.driver);
			int j=i+1;
			Log.passed("Swipe Screen , Direction "+Direction+ " : "+ j);
        }

		} catch (Exception e){
			Log.failed("Swipe of direction " + e.getMessage());
			throw e;
		}

	}
}
