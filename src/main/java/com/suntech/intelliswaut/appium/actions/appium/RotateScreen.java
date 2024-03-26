package com.suntech.intelliswaut.appium.actions.appium;

/**
 * Created by dinkark on 05-Oct-2016
 */
import java.util.HashMap;

import org.openqa.selenium.ScreenOrientation;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.utils.Constants;

public class RotateScreen {
	public void run(HashMap<String, Object> params) throws Exception {
	try{
		if (Driver.driver != null) {
			switch (Get.param(params,Constants.ORIENTATION)) {
			case Constants.LANDSCAPE:
				Driver.driver.rotate(ScreenOrientation.LANDSCAPE);
				break;
			case Constants.PORTRAIT:
				Driver.driver.rotate(ScreenOrientation.PORTRAIT);
				break;
			default:
				Driver.driver.rotate(ScreenOrientation.PORTRAIT);
				break;
			}

		}
		
	Log.passed("Screen rotated");
}
    catch (Exception e) {
		Log.failed(e.getMessage());
		throw e;
		}

}
}
