package com.suntech.intelliswaut.appium.actions.appium;

/**
 * Created by dinkark on 01-Oct-2016
 */
import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Elements;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class ClickElement {
	public void run(HashMap<String, Object> params) throws Exception {
		try {
		String strElemName = (Get.param(params,"Element Name"));
		if(strElemName.contains("Login")){
			AndroidDriver dr = (AndroidDriver) Driver.driver;
				dr.pressKey(new KeyEvent(AndroidKey.ENTER));
		}else{
			MobileElement element = Elements.find(params, Driver.driver);
			element.click();
		}
		Log.passed("Clicked on element "+ strElemName );
	}catch(Exception e){
		Log.failed(e.getMessage());
		throw e;
}
	}
}