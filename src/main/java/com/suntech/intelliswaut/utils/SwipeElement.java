package com.suntech.intelliswaut.utils;

import java.time.Duration;

import org.openqa.selenium.Dimension;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;

public class SwipeElement {
	public static void swipe(int startX, int startY, int endX, int endY, AppiumDriver<MobileElement> driver) throws InterruptedException {

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			
		}
		TouchAction touchAction = new TouchAction(driver);
		touchAction.press(ElementOption.point(startX,startY)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(3))).moveTo(ElementOption.point(endX,endY)).release().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			throw e1;
			
		}
	}

	public static void swipeScreen(Dimension size,String direction, AppiumDriver<MobileElement> driver) throws InterruptedException {
		
		int startX = 0;
		int endX = 0;
		int startY = 0;
		int endY = 0;
		if(direction==""){
			direction = "DOWN";
		}
		switch (direction.toUpperCase()){
			case "RIGHT":
				startY = (int) (size.height /2);
				startX = (int) (size.width * 0.90);
				endX = (int) (size.width * 0.05);
				break;

			case "LEFT":
				startY = (int) (size.height /2);
				startX = (int) (size.width * 0.05);
				endX = (int) (size.width * 0.90);
				break;

			case "UP":
				endY= (int) (size.height * 0.70);
				startY  = (int) (size.height * 0.30);
				startX = (size.width / 2);
				break;


			case "DOWN":
				startY = (int) (size.height * 0.70);
				endY = (int) (size.height * 0.30);
				startX = (size.width / 2);

				break;

		}
		swipe(startX, startY, endX, endY, driver);

	}

	
}
	