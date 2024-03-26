package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyTableCellText {

		public boolean run(HashMap<String, Object> params) throws Exception {
			boolean result = false;
			try {

				int rowIndex = Integer.parseInt(Get.param(params,"Row No").toString());
				int ColIndex = Integer.parseInt(Get.param(params,"Column No").toString());
				WebElement wexpath = Browser.Driver.findElement(
				By.xpath(Get.param(params,"ID").toString() + "/tr[" + rowIndex + "]/td[" + ColIndex + "]"));
				String getValue=wexpath.getText();
				String expectedStr=Get.param(params,"Expected Value").toString();
				if (getValue.equalsIgnoreCase(expectedStr)) {
					Log.passed("Expected value "+expectedStr+" match with the current value " +getValue);
					result = true;
				} else {
					Log.failed("Expected value "+expectedStr+" does not match with the current value " +getValue);
					result = false;
				}

			} catch (Exception e) {
				Log.failed("Exception caught in VerifyTableCellText Action , Message is " + e.getMessage());
				result = false;

			}
			return result;
		}

	}
