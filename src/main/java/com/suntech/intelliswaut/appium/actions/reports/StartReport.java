package com.suntech.intelliswaut.appium.actions.reports;

import java.util.Calendar;
import java.util.HashMap;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class StartReport {

	public static ExtentReports extent ;
	public static ExtentTest parent;
	public static String timeStamp;
	public static String basePath;
	public static String testcasename = "";
	private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	public void run(HashMap<String, Object> params){

		try {
			if(extent == null) {
				String executionId = params.get("ExecutionId").toString();
				basePath = params.get("basePath").toString();
				timeStamp =  createOutputDirectory(executionId,basePath);
				System.out.println(timeStamp);
				
//				extent = new ExtentReports("D://Results.html");
				System.out.println("calling extent report::::::");	
				ExtentSparkReporter spark = new ExtentSparkReporter(basePath+"/TestResults/"+timeStamp+"/Results.html");
				spark.config().setReportName("ISWAUT Automation");
				spark.config().setDocumentTitle("Intelli SWAUT Automation Report");			
				extent.attachReporter(spark);	
				System.out.println(" after calling extent report::::::");
				//extent.loadConfig(new File("./bin/extent-config.xml"));	
			}
			System.out.println("1");
			if(parent==null) {
				System.out.println("2");
				String strName = params.get("TestCaseName").toString();
				testcasename =  strName;
				System.out.println("3");
				if(strName==null) {
					strName = "Test Case";
				}
				parent = extent.createTest(strName,"<font size=4 color=black> "+strName+" </font><br/>");
				extentTest.set(parent);
				parent.info("########### Start of Test Case :  ###########");			
			}
		} catch (Exception e) {            
			System.out.println("Report Exception "+e);
			throw e;
		}
	}
	
	public static synchronized ExtentTest getTest() 
	{ 
		return extentTest.get(); 
	}
	
 
	public static String createOutputDirectory(String ExecutionId,String basePath)
	{
        // volatile int i=0;
		String am_pm;
		String min;
		String hr;
		String sec;
		int yr;
		String mon;
		String day;
		java.io.File curdir = new java.io.File(basePath+"/TestResults");
		curdir.mkdirs();
		System.out.println("Path is :"+curdir.getAbsolutePath());
		Calendar calendar = new java.util.GregorianCalendar();
		hr = "0" + calendar.get(10);
		hr = hr.substring(hr.length() - 2);
		min = "0" + calendar.get(12);
		min = min.substring(min.length() - 2);
		sec = "0" + calendar.get(13);
		sec = sec.substring(sec.length() - 2);
		yr = calendar.get(1);
		mon = "0" + (calendar.get(2) + 1);
		mon = mon.substring(mon.length() - 2);
		day = "0" + calendar.get(5);
		day = day.substring(day.length() - 2);

		if (calendar.get(9) == 0) {
			am_pm = "AM";
		} else {
			am_pm = "PM";
		}    
		String timeStamp = ExecutionId +"_"+ yr + "_" + mon + "_" + day + "_" + hr + "_" + min + "_" + sec;
		// String timeStamp = ExecutionId;
		String outputDirectory = null;
		try{
			java.io.File outputdir = new java.io.File(basePath+"/TestResults/"+timeStamp);
			 outputdir.mkdir();
			
		}catch (Exception e){
			System.out.println("IO Error while creating Output Directory : " + outputDirectory);
			throw e;
		}	

		return timeStamp;
	}
}