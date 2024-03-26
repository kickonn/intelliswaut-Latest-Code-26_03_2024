package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class Sleep {
	public void run(HashMap<String, Object> params) throws InterruptedException {

		String sleep = Get.param(params,"millis");

		Thread.sleep(Integer.parseInt(sleep));
		Log.passed("sleep at "+sleep+" milliseconds");
		
	}
}
