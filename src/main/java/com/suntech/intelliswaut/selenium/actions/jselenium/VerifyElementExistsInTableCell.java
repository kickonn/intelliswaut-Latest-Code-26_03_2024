package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyElementExistsInTableCell {

		public boolean run(HashMap<String, Object> params) throws Exception {
			boolean result = false;
			try {

				int rowIndex = Integer.parseInt(Get.param(params,"Row No").toString());
				int ColIndex = Integer.parseInt(Get.param(params,"Column No").toString());
				WebElement wexpath = Browser.Driver.findElement(By.xpath(params.get("ID").toString() + "/tr[" + rowIndex + "]/td[" + ColIndex + "]"));
				String getValue=wexpath.getText();
				String expectedStr=Get.param(params,"Expected Value").toString();
				if (getValue.equalsIgnoreCase(expectedStr)) {
					Log.passed("Element "+expectedStr+" displayed in " + rowIndex + " row " + ColIndex + " column of webtable");
					result = true;
				} else {
					Log.failed("Element "+expectedStr+" not displayed in " + rowIndex + " row " + ColIndex + " column of webtable");
					result = false;
				}

			} catch (Exception e) {
				Log.failed("Exception caught in VerifyElementExistsInTableCell Action , Message is " + e.getMessage());
				result = false;

			}
			return result;
		}

	}
