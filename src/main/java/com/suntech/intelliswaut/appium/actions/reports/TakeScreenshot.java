package com.suntech.intelliswaut.appium.actions.reports;

import com.suntech.intelliswaut.selenium.actions.jselenium.Browser;
import com.suntech.intelliswaut.selenium.actions.winapp.WindowApp;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;

public class TakeScreenshot {

	public static int strCount = 0; 

	public void run(HashMap<String, Object> params){
		strCount = strCount+1;
		String strBaseImapge = captureScreenshot("Screenshot"+strCount);		
		if(StartReport.parent != null) {
			StartReport.parent.info("Manual Verification Point: " + StartReport.parent.addScreenCaptureFromBase64String(strBaseImapge));
		} 

	}

	public static void takeScreenshot() {
		strCount = strCount+1;
		String strBaseImapge = captureScreenshot("Screenshot"+strCount);		
		if(StartReport.parent != null) {
			StartReport.parent.info( "Manual Verification Point: " + StartReport.parent.addScreenCaptureFromBase64String(strBaseImapge));
		}
	}

	public static String captureScreenshot(String filename) {
		String scrFile = null;
		String scrPath = "./temp/"+StartReport.timeStamp+"/Screenshots";
		File file = new File(scrPath);
		file.mkdir();
		try{
			//scrFile = (File)((RemoteWebDriver) GenericKeywords.driver).getScreenshotAs(OutputType.FILE);
			scrFile =  ((TakesScreenshot) Browser.Driver).getScreenshotAs(OutputType.BASE64);	
			scrFile =  "data:image/png;base64,"+scrFile;	
			return scrFile;

		}catch (Exception e){
			try{
				scrFile =  ((TakesScreenshot) WindowApp.driver).getScreenshotAs(OutputType.BASE64);
				scrFile =  "data:image/png;base64,"+scrFile;	
				return scrFile;
			}catch(Exception ex1){
				try{
					Robot robot = new Robot();
					Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
					BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
					File outputfile = new File(scrPath + "\\" + filename + ".png");
					ImageIO.write(bufferedImage, "png", outputfile);
					return scrFile;
				}catch (Exception ex){
					System.out.println("This WebDriver does not support screenshots");
					return null;
				}
			}
		}finally{
			if (scrFile == null) {
				System.out.println("This WebDriver does not support screenshots");
				return scrFile;
			}
		}
	}
}
