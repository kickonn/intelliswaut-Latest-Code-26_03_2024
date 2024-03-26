package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyPageTitle {
		public void run(HashMap<String, Object> params) throws Exception {
			try {

				if ((params.get("Title").toString()).equalsIgnoreCase(Browser.Driver.getTitle()))
					Log.passed("Page title " + Browser.Driver.getTitle() + " match expected title of :  "
							+ Get.param(params,"Title"));
				else
					Log.failed("Page title " + Browser.Driver.getTitle() + " does not match expected title of : "
							+ Get.param(params,"Title"));

			} catch (Exception e) {
				Log.failed("Exception caught in verifying page title, Message is " + e.getMessage());
				throw e;
			}
		}
	}

