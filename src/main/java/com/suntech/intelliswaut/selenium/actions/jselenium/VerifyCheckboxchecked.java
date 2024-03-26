package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyCheckboxchecked {
		public boolean run(HashMap<String, Object> params) throws Exception {
			boolean chkStatus = false;			
			try {
				WebElement eleCheckbox = Elements.find(params, Browser.Driver);
				if (eleCheckbox.isSelected()) {
					Log.passed("Checkbox is  checked as expected");
					chkStatus = true;
				}else{
					Log.failed("Checkbox is  not checked as expected");
					chkStatus = false;
				}

			} catch (Exception e) {
				Log.failed("Exception caught while VerifyCheckboxchecked, Message is "+e.getMessage());
				chkStatus = false;
			}
			return chkStatus;
		}
	}