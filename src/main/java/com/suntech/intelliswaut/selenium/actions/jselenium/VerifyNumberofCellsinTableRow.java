package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyNumberofCellsinTableRow {

		public boolean run(HashMap<String, Object> params) throws Exception {
			try {
				WebElement element = Elements.find(params, Browser.Driver);
				List<WebElement> weTablerows=element.findElements(By.tagName("tr"));
				
				List<WebElement> TotalcellsList = weTablerows.get(Integer.parseInt(Get.param(params,"RowIndex").toString())).findElements(By.tagName("td"));
				int totalcells = TotalcellsList.size();
				Log.passed("Total number of Cells in the table row are : " + TotalcellsList.size());
				int expectedCount = Integer.parseInt(Get.param(params,"CellsCount").toString());
				if (totalcells == expectedCount) {
					Log.passed("Expected cells count of a row " + expectedCount + " match cells count of row in UI " + totalcells);
					return true;
				} else
					Log.failed("Expected cells count of a row " + expectedCount + " does not match cells count of a row in UI " + totalcells);
				return false;

			} catch (Exception e) {
				Log.failed("Exception caught in VerifyNumberofCellsinTableRow Action , Message is " + e.getMessage());
				return false;
			}

		}

	}