package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SelectItemInTableCell {

		public void run(HashMap<String, Object> params) throws Exception {

			try {

				int rowIndex = Integer.parseInt(Get.param(params,"Row Number"));
				int ColIndex = Integer.parseInt(Get.param(params,"Column Number"));
				WebElement wexpath = Browser.Driver.findElement(By.xpath(params.get("ID").toString() + "/tr[" + rowIndex + "]/td[" + ColIndex + "]/select"));
				Select dropdown = new Select(wexpath);
				dropdown.selectByVisibleText(params.get("Text").toString());
				Log.passed("Selected value from dropdown in webtable is :  " + params.get("Text").toString());

			} catch (Exception e) {
				Log.failed("Exception caught in SelectItemInTableCell Action, Message is "+e.getMessage());
				throw e;
			}

		}

	}