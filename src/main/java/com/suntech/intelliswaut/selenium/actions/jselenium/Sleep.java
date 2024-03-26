package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Sleep {

	public void run(HashMap<String, Object> params) throws Exception {
		int time;
		try{
			if(params.get("Time")!=null) {
				time = Integer.parseInt(Get.param(params,"Time").toString());
			}else {
				time = 5;
			}
			Thread.sleep(time*1000);
		}catch(Exception e){
			Log.failed("Exception caught in waitForElement Action, Message is "+e.getMessage());
			throw e;
		}	
	}

}
