package com.suntech.intelliswaut.appium.actions.string;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;
import com.suntech.intelliswaut.selenium.actions.jselenium.Get;

public class CharAt {

	public char run(HashMap<String, Object> params) throws Exception {
		try {
			String text = Get.param(params, "Text");
			String strIndex = Get.param(params, "Index");

			if (text.equals("")) {
				Log.error("CharAt Action , Paramter Text cant be null");
				return (Character) null;
			}

			if (strIndex.equals("")) {
				Log.error("CharAt Action , Paramter Index cant be null");
				return (Character) null;
			}

			Integer index = Integer.parseInt(strIndex);
			if (index < text.length()) {
				Log.info("Text is " + text + " , Character at the index " + strIndex + " is " + text.charAt(index));
				return text.charAt(index);
			} else {
				Log.error(
						"Text length is " + text.length() + ", But index passed as paramter to action is " + strIndex);
				return (Character) null;
			}
		} catch (Exception e) {
			Log.error("Exception caught in CharAt Action, Message is " + e.getMessage());
			return (Character) null;
		}
	}

}
