package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetTableRowContainingText {

		public String run(HashMap<String, Object> params) throws Exception {
			int row = 0;
			try {
				WebElement weTable = Elements.find(params, Browser.Driver);
				List<WebElement> weTablerows = weTable.findElements(By.tagName("tr"));
				int rowsCount = weTablerows.size();
				Log.passed("Total number of rows in the table are : " + rowsCount);
				for (int rowIndex = 1; rowIndex < rowsCount; rowIndex++) {
					List<WebElement> weTableCells = weTablerows.get(rowIndex).findElements(By.tagName("td"));
					int totalcells = weTableCells.size();
					for (int cell = 0; cell < totalcells; cell++) {
						String cellText = weTableCells.get(cell).getText();
						if (cellText.equalsIgnoreCase(Get.param(params, "Text").toString())) {
							Log.passed(Get.param(params, "Text") + " text found in the table row : " + rowIndex);
							row = rowIndex;
							return String.valueOf(row);
						}
					}
					
				}
            
			} catch (Exception e) {
				Log.failed("Exception caught in GetTableRowContainingText Action " + e.getMessage());
				return String.valueOf(row);
			}
			return String.valueOf(row);
		}

	}