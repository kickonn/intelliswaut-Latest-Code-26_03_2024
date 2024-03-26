package com.suntech.intelliswaut.selenium.actions.reports;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import java.io.File;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;

public class StartReport {
	public static ExtentReports extent;
	public static ExtentTest parent;
	public static String timeStamp;
	public static String basePath;
	public static String testcasename = "";

	public StartReport() {
	}

	public void run(HashMap<String, Object> params) {
		try {
			String strName;
			if (extent == null) {
				strName = params.get("ExecutionId").toString();
				basePath = params.get("basePath").toString();
				timeStamp = createOutputDirectory(strName, basePath);
				System.out.println(timeStamp);
				System.out.println("calling extent report::::::");
				extent = new ExtentReports(basePath + "/TestResults/" + timeStamp + "/Results.html", true);
				System.out.println(" after calling extent report::::::");
			}

			System.out.println("1");
			if (parent == null) {
				System.out.println("2");
				strName = params.get("TestCaseName").toString();
				testcasename = strName;
				System.out.println("3");
				if (strName == null) {
					strName = "Test Case";
					System.out.println("4");
				}

				parent = extent.startTest(strName, "<font size=4 color=black> " + strName + " </font><br/>");
				System.out.println("5");
				parent.log(LogStatus.INFO, "########### Start of Test Case :  ###########");
				System.out.println("6");
			}

		} catch (Exception var3) {
			System.out.println("Report Exception " + var3);
			throw var3;
		}
	}

	public static String createOutputDirectory(String ExecutionId, String basePath) {
		File curdir = new File(basePath + "/TestResults");
		curdir.mkdirs();
		System.out.println("Path is :" + curdir.getAbsolutePath());
		Calendar calendar = new GregorianCalendar();
		String hr = "0" + calendar.get(10);
		hr = hr.substring(hr.length() - 2);
		String min = "0" + calendar.get(12);
		min = min.substring(min.length() - 2);
		String sec = "0" + calendar.get(13);
		sec = sec.substring(sec.length() - 2);
		int yr = calendar.get(1);
		String mon = "0" + (calendar.get(2) + 1);
		mon = mon.substring(mon.length() - 2);
		String day = "0" + calendar.get(5);
		day = day.substring(day.length() - 2);
		String var2;
		if (calendar.get(9) == 0) {
			var2 = "AM";
		} else {
			var2 = "PM";
		}

		String timeStamp = ExecutionId + "_" + yr + "_" + mon + "_" + day + "_" + hr + "_" + min + "_" + sec;
		Object outputDirectory = null;

		try {
			File outputdir = new File(basePath + "/TestResults/" + timeStamp);
			outputdir.mkdir();
			return timeStamp;
		} catch (Exception var14) {
			System.out.println("IO Error while creating Output Directory : " + outputDirectory);
			throw var14;
		}
	}
}
