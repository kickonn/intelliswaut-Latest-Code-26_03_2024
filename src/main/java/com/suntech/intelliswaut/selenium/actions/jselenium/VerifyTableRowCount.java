package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

	 public class VerifyTableRowCount {

		public boolean run(HashMap<String, Object> params) throws Exception {
			try {
				List<WebElement> TotalRowsList = Elements.findAll(params, Browser.Driver);
				int totalrows = TotalRowsList.size();
				Log.passed("Total number of Rows in the table are : " + TotalRowsList.size());
				int expectedCount = Integer.parseInt( Get.param(params,"RowsCount").toString());
				if (totalrows == expectedCount) {
					Log.passed("Expected row count " + expectedCount + " match rows count in UI " + totalrows);
					return true;
				} else
					Log.failed("Expected row count " + expectedCount + " does not match rows count in UI " + totalrows);
					return false;

			} catch (Exception e) {
				Log.failed("Exception caught in VerifyTableRowCount Action, Message is " + e.getMessage());
				return false;
			}

		}

	}