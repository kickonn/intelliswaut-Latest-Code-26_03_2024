package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyApplicationInCorrectPage {
	String homepageTitle = "";

	public void run(HashMap<String, Object> params) throws Exception {

		try {
			homepageTitle = Get.param(params,"HOME_PAGE_TITLE");
			if (!isValidPage()) {
				Log.failed("The application is not in the expected page , current page: "
						+ Browser.Driver.getTitle() + " Page.");
			}else{
				Log.passed("Application is in the valid page with title "+homepageTitle);
			}
		} catch (Exception ex) {
			Log.failed("Exception caught in VerifyApplicationInCorrectPage Action " + ex.getMessage());
			throw ex;
		}
	}

	public boolean isValidPage() {
		try{
			if (Browser.Driver.getTitle().trim().contains(homepageTitle)) {
				Log.passed("The application is in the expected page , current page: " + Browser.Driver.getTitle()
						+ " Page.");
				return true;
			}
		}catch(Exception e){
			return false;	
		}
		return false;
	}

}
