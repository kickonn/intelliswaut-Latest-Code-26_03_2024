package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class SubstringEndtoEnd {

	public String run(HashMap<String, Object> params) throws Exception {
		try {
			String text = Get.param(params,"Text");			
			String FirstIndex = Get.param(params,"FirstIndex");
			String LastIndex = Get.param(params,"LastIndex");
			if(text.equals("")||FirstIndex.equals("")||LastIndex.equals("")){
				Integer Firstindex = Integer.parseInt(FirstIndex);
				Integer Lastindex = Integer.parseInt(LastIndex);
				return text.substring(Firstindex, Lastindex);
			}
			return null;

		} catch (Exception e) {
			Log.error("Exception caught in Substring with First Index and Last Index Action, Message is " + e.getMessage());
			throw e;
		}

	}

}
