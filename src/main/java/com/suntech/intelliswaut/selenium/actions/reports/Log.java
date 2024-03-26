package com.suntech.intelliswaut.selenium.actions.reports;

import com.cedarsoftware.util.io.JsonWriter;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;

public class Log {
	public static String errorMsg = "Find the below steps to reproduce the issue" + System.lineSeparator();
	public static boolean strFail = false;

	public Log() {
	}

	public static void passed(String msg) {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.PASS, "<font color=green>" + msg + "</font><br/>");
		errorMsg = errorMsg + msg + System.lineSeparator();
	}
	public static void fail(String msg){
		if(StartReport.parent==null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}
		StartReport.parent.log(LogStatus.FAIL, "<font color=red>" + msg + "</font><br/>");
		errorMsg = errorMsg +System.lineSeparator() +"Test Case failed due to below reasons"+ msg + System.lineSeparator();
		strFail = true;
	}
	public static void failed(String msg) throws Exception {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.FAIL, "<font color=red>" + msg + "</font><br/>");
		errorMsg = errorMsg + System.lineSeparator() + "Test Case failed due to below reasons" + msg + System.lineSeparator();
		strFail = true;
		TakeScreenshot.takeScreenshot();
		Assert.fail("Error Descripton: " + msg);
		throw new Exception("msg");
	}

	public static void error(String msg) throws Exception {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.FAIL, "<font color=red>" + msg + "</font><br/>");
		strFail = true;
		errorMsg = errorMsg + System.lineSeparator() + "Test Case failed due to below reasons" + msg + System.lineSeparator();
		Assert.fail("Error Descripton: " + msg);
		throw new Exception("msg");
	}

	public static void setConfig(String browser, String url) {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.extent.addSystemInfo("Browser", browser);
		StartReport.extent.addSystemInfo("URL", url);
	}

	public static void info(String msg) {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.INFO, "<font color=blue>" + msg + "</font><br/>");
		errorMsg = errorMsg + msg + System.lineSeparator();
	}

	public static void warning(String msg) {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.WARNING, "<font color=blue>" + msg + "</font><br/>");
	}

	public static void jsonInfo(String msg) {
		if (StartReport.parent == null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}

		StartReport.parent.log(LogStatus.INFO, "<font color=black><pre>" + JsonWriter.formatJson(msg).replace("\t", "&nbsp;&nbsp;").replace(" ", "&nbsp;&nbsp;") + "<pre></font><br/>");
		errorMsg = errorMsg + msg + System.lineSeparator();
	}
}