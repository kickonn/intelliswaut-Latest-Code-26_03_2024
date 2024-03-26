package com.suntech.intelliswaut.selenium.actions.jselenium;

import java.util.HashMap;

import  com.suntech.intelliswaut.selenium.actions.reports.Log;
public class If {

	public boolean run(HashMap<String, Object> params) {
		String var1 = params.get("Var1").toString();
		String var2 = params.get("Var2").toString();
		String conditions = params.get("condition").toString();
		boolean var3 = false;
		switch (conditions.toLowerCase()) {
		case "equals":
			var3 = var1.equals(var2);
			Log.passed("Return the text from the element " + var3);
			break;
		case "contains":
			var3 = var1.contains(var2);
			Log.passed("Return the text from the element " + var3);
			break;
		case "equalsignorecase":
			var3 = var1.equalsIgnoreCase(var2);
			Log.passed("Return the text from the element " + var3);
			break;		
		default:
		Log.passed("Return the text from the element " + var3);
			var3 = var1.contains(var2);
			
		}
		Log.passed("Return the text from the element " + var3);
		return var3;
		
	}
}
