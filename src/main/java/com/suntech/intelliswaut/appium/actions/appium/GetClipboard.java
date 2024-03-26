package com.suntech.intelliswaut.appium.actions.appium;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.appium.java_client.clipboard.ClipboardContentType;
import io.appium.java_client.clipboard.HasClipboard;

public class GetClipboard {
	public void run(HashMap<String,Object> params) throws Exception {
		try {
		((HasClipboard) Driver.driver).getClipboard(ClipboardContentType.PLAINTEXT);
		Log.info("Clipboard is " + ((HasClipboard) Driver.driver).getClipboardText());
		
		
	}catch (Exception e) {

		Log.failed(e.getMessage());
		throw e;
}
		//return "";
		
	}
}
