package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public  class JS_DragFromToForDuration{

	public void run(HashMap<String, Object> params) throws Exception {

		try {
			HashMap<String, Object> args = new HashMap<String, Object> ();
		
			int FromX=Integer.parseInt(Get.param(params,"FromX"));
			int FromY=Integer.parseInt(Get.param(params,"FromY"));
			
			int ToX=Integer.parseInt(Get.param(params,"ToX"));
			int ToY=Integer.parseInt(Get.param(params,"ToY"));
			
			int Duration=Integer.parseInt(Get.param(params,"Duration"));
			
			args.put("fromX", FromX);
			args.put("fromY", FromY);
			args.put("toX", ToX);
			args.put("toY", ToY);
			args.put("duration", Duration);
			
			Driver.driver.executeScript("mobile: dragFromToForDuration", args);
			Log.passed("successfully Drag From To For Duration" );

		} catch (Exception e) {
			Log.failed("Not successfully Drag From To For Duration " + e.getMessage());
			e.printStackTrace();
			throw e;
		}

	}

}
