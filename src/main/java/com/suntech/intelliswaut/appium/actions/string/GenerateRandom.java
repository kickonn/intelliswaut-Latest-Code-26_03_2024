package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GenerateRandom {

	public String run(HashMap<String, Object> params) throws Exception {
		try {
			String txt = Get.param(params, "Type");
			String size = Get.param(params, "Size");
			int n= 5;
			if(!size.equals("")) {
				n = Integer.parseInt(size);
			}
			String upperAlphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		    String lowerAlphabet = "abcdefghijklmnopqrstuvwxyz";
		    String numbers = "0123456789";
		    StringBuilder sb = new StringBuilder(n);	
			switch(txt.toLowerCase()) {			
				case "alphabets":
					 String alpha = upperAlphabet + lowerAlphabet;					 					  
				        for (int i = 0; i < n; i++) {
				            int index
				                = (int)(alpha.length()
				                        * Math.random());
				            sb.append(alpha
				                          .charAt(index));
				        }
				        break;
				case "alphanumeric":
					String alphaNumeric = upperAlphabet + lowerAlphabet + numbers;									 
				        for (int i = 0; i < n; i++) {
				            int index
				                = (int)(alphaNumeric.length()
				                        * Math.random());
				            sb.append(alphaNumeric
				                          .charAt(index));
				        }
				        break;
				case "numeric":
					String numeric = numbers;									 
				        for (int i = 0; i < n; i++) {
				            int index
				                = (int)(numeric.length()
				                        * Math.random());
				            sb.append(numeric
				                          .charAt(index));
				        }
				        break;
				default:
					 String alpha1 = upperAlphabet + lowerAlphabet;					 					  
				        for (int i = 0; i < n; i++) {
				            int index
				                = (int)(alpha1.length()
				                        * Math.random());
				            sb.append(alpha1
				                          .charAt(index));
				        }
				        break;					
			}
			Log.info("Random String generated is " + sb.toString());
			return sb.toString();								
		} catch (Exception e) {
			Log.error("Exception caught in Generate Random Action, Message is " + e.getMessage());
			return null;

		}
	}

}
