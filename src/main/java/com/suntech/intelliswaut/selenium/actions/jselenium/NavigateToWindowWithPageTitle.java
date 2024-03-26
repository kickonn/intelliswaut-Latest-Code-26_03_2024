package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.time.Duration;
import java.util.HashMap;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.suntech.intelliswaut.selenium.actions.reports.Log;



public class NavigateToWindowWithPageTitle {
		public void run(HashMap<String, Object> params) throws Exception {

			boolean blnNavigate = false;
			try {
				Set<String> handles = Browser.Driver.getWindowHandles();
				String strNoOfWindows = Get.param(params, "Expected No. of Windows");
				String strPageTitle = Get.param(params, "Page Title");
				int i = Integer.parseInt(strNoOfWindows);
				if(strNoOfWindows==""){
					strNoOfWindows = "2";
				}
				if (waitForNewWindow(i)) {
					for (String windowHandle : handles) {
						String strActTitle = Browser.Driver.switchTo().window(windowHandle).getTitle();
						if (strActTitle.contains(strPageTitle)) {
							blnNavigate = true;
							Browser.Driver.manage().window().maximize();
							Thread.sleep(5000);
							Log.passed("Navigated to the page -" + strPageTitle
									+ "- successfully");
							break;
						}
					}
					if (!blnNavigate) {
						Log.failed("Unable to Navigate to the page -" + strPageTitle);
					}
				} else {
					Log.failed("New window the with page Title " + strPageTitle
							+ " is not loaded");
				}
			} catch (Exception ex) {
				Log.failed("Unable to Navigate to the page -" + (Get.param(params, "Page Title")) + " Exception is->"
						+ ex.getMessage());
			
			}
		}

		public boolean waitForNewWindow(int expectedNoOfWindows) throws Exception {
			boolean blnWindow = false;
			try {
				new WebDriverWait(Browser.Driver, Duration.ofSeconds(30))
						.until(ExpectedConditions.numberOfWindowsToBe(expectedNoOfWindows));
				Log.passed("Total number of windows opened is " + expectedNoOfWindows);
				blnWindow = true;
			} catch (Exception Ex) {
				Log.failed("Expected number of windows are not opened, Expected is " + expectedNoOfWindows);
				blnWindow = false;
				throw Ex;
			}
			return blnWindow;
		}
	}

