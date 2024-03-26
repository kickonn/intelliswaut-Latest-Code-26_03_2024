package com.suntech.intelliswaut.selenium.actions.jselenium;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetRadio {

		public String run(HashMap<String, Object> params) throws Exception {
			String radiotextvalue = "";
			try {

				List<WebElement> radiobuttons = Elements.findAll(params, Browser.Driver);
				for (WebElement radiobutton : radiobuttons) {
					if (radiobutton.isSelected()) {
						radiotextvalue = radiobutton.getAttribute("value");
						if(radiotextvalue.trim().equals("")) {
							radiotextvalue = radiobutton.findElement(By.xpath("/following-sibling::label")).getText();
						}
						Log.passed("The value of selected radiobutton is : " + radiotextvalue);
						break;
					}
				}
			}catch (Exception e) {
				Log.failed("Exception caught in GetRadio Action " + e.getMessage());
				throw e;
			}
			return radiotextvalue;

		}

	}