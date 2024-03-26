package com.suntech.intelliswaut.appium.actions.appium;

//import java.io.IOException;
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Constants;

/**
 * Created by dinkark on 26-Oct-2016
 */
 public class AndroidInterruption {
	public void run(HashMap<String, Object> params) throws Exception{
		try {
		String udid = (Get.param(params,Constants.UDID));
		String ADB_PATH = (Get.param(params,Constants.ANDROID_HOME)) + "/platform-tools/adb";
		String callScript = ADB_PATH + " -s " + udid + " shell am start -a android.settings.SETTINGS";
		Runtime.getRuntime().exec(callScript);
		Thread.sleep(3000);
		Runtime.getRuntime().exec(ADB_PATH + " -s " + udid + " shell input keyevent 4");
		Log.passed("Android Intrupption ");
		return;
	}catch(Exception e){
       e.printStackTrace();
       throw e;
}
	}
}
