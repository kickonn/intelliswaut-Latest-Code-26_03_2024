package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyRadioValue {
		public boolean run(HashMap<String, Object> params) throws Exception{
			try{
			 List<WebElement> radiobuttons=Elements.findAll(params, Browser.Driver);
			 int radioCount = radiobuttons.size();

				for (int i = 0; i < radioCount; i++) {
					
			     if (radiobuttons.get(i).isSelected()) 
			     {
	     			String radiotextvalue=radiobuttons.get(i).getAttribute("value");
	     			Log.passed("The value of selected radiobutton is : " + radiotextvalue);
	
	     				if(params.get("ExpectedValue").toString().equalsIgnoreCase(radiotextvalue))
	     				{
	     				Log.passed("The value of selected radiogroup value and expected radiogroup values are Matching  " + radiotextvalue);
						break;
	     				}
						else
							Log.failed("Elements are  not matching,expected "+radiotextvalue);
	     					
	     			}
				}
		}
		catch(Exception e) {
				Log.failed("Exception caught in Radiobutton, Message is "+e.getMessage());
				return false;
		}
		return true;
	}
 }
