package com.suntech.intelliswaut.selenium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class Join {

	public String run(HashMap<String, Object> params) throws Exception {
		try {
			String text1 = Get.param(params,"Text1");
			String text2 = Get.param(params,"Text2");
			String delimiter = Get.param(params,"Delimiter");

			if(delimiter.equals("")){
				Log.error("Join Action , Parameter Delimiter cant be null");
				return null;
			}
			String strJoined = String.join(delimiter, text1, text2);
			Log.info("Join Action, Text1 is "+text1 +"Text 2 is "+ text2 + " Delemiter is "+ delimiter +" and joined string is "+strJoined);
			return strJoined;

		} catch (Exception e) {
			Log.error("Exception caught in Join Action, Message is " + e.getMessage());
			throw e;

		}

	}

}
