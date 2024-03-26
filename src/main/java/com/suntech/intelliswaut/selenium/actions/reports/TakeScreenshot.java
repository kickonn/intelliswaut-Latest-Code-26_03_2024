package com.suntech.intelliswaut.selenium.actions.reports;

import com.relevantcodes.extentreports.LogStatus;
import com.suntech.intelliswaut.selenium.actions.jselenium.Browser;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashMap;
import javax.imageio.ImageIO;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class TakeScreenshot {
	public static int strCount = 0;

	public TakeScreenshot() {
	}

	public void run(HashMap<String, Object> params) {
		++strCount;
		captureScreenshot("Screenshot" + strCount);
		String path = "./Screenshots/Screenshot" + strCount + ".png";
		if (StartReport.parent != null) {
			StartReport.parent.log(LogStatus.INFO, "Manual Verification Point: " + StartReport.parent.addScreenCapture(path));
		}

	}

	public static void takeScreenshot() {
		++strCount;
		captureScreenshot("Screenshot" + strCount);
		String path = "./Screenshots/Screenshot" + strCount + ".png";
		if (StartReport.parent != null) {
			StartReport.parent.log(LogStatus.INFO, "Manual Verification Point: " + StartReport.parent.addScreenCapture(path));
		}

	}

	public static void captureScreenshot(String filename) {
		File scrFile = null;
		String scrPath = "../../../../public/TestResults/" + StartReport.timeStamp + "/Screenshots";
		File file = new File(scrPath);
		file.mkdir();

		try {
			scrFile = (File)((TakesScreenshot)Browser.Driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(scrFile, new File(scrPath + "\\" + filename + ".png"));
			return;
		} catch (Exception var14) {
			try {
				Robot robot = new Robot();
				Rectangle captureSize = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
				BufferedImage bufferedImage = robot.createScreenCapture(captureSize);
				File outputfile = new File(scrPath + "\\" + filename + ".png");
				ImageIO.write(bufferedImage, "png", outputfile);
			} catch (Exception var13) {
				return;
			}
		} finally {
			if (scrFile == null) {
				System.out.println("This WebDriver does not support screenshots");
				return;
			}

		}

	}
}