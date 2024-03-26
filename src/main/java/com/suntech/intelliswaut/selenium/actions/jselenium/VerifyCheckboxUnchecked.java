package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyCheckboxUnchecked {
		public boolean run(HashMap<String, Object> params) throws Exception {
			boolean chkStatus = false;
			try {
			WebElement eleCheckbox = Elements.find(params, Browser.Driver);
				if (!eleCheckbox.isSelected()) {
					Log.passed("Checkbox is  unchecked as expected");
					chkStatus = true;
				}else{
					Log.passed("Checkbox is  not unchecked as expected");
					chkStatus = false;
				}

			} catch (Exception e) {
				Log.failed("Exception caught while VerifyCheckboxUnchecked, Message is "+e.getMessage());
				chkStatus = false;
			}
			return chkStatus;
		}
	}