package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetTableRowCount {
		public String run(HashMap<String, Object> params) throws Exception {
			int RowsCount = 0;
			try {
				List<WebElement> TotalRowsList = Elements.findAll(params, Browser.Driver);
				int totalrows = TotalRowsList.size();
				Log.passed("Total number of Rows in the table are : " + TotalRowsList.size());
				RowsCount = totalrows;
			} catch (Exception e) {
				Log.failed("Exception caught in GetTableRowCount Action " + e.getMessage());
				throw e;
			}
			return String.valueOf(RowsCount);
		}
	}