package com.suntech.intelliswaut.appium.actions.appium;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.suntech.intelliswaut.appium.actions.reports.Log;

public class TakeScreenShot {

	public void run(HashMap<String, Object> params) throws Exception {
		try {
			String destDir;
			
			if(!(Get.param(params,"path").isEmpty())) {
			destDir=(Get.param(params,"Path"));
			}else {
				destDir="screnshots";
			}
			File scrFile = ((TakesScreenshot) Driver.driver).getScreenshotAs(OutputType.FILE);
			  
			DateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy__hh_mm_ssaa");
			  
			  new File(destDir).mkdirs();
			  
			  String destFile = dateFormat.format(new Date()) + ".png";

			 
			   try {
				FileUtils.copyFile(scrFile, new File(destDir + "/" + destFile));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  Log.passed("Screenshot has taken Successfully");
		} catch (NumberFormatException e) {
			Log.failed("Taking ScreenShot has failed");
			e.printStackTrace();
			throw e;
		}
	
}
}
