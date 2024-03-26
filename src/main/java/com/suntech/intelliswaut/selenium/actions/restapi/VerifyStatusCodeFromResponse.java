package com.suntech.intelliswaut.selenium.actions.restapi;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;
import io.restassured.response.Response;
import java.util.HashMap;

public class VerifyStatusCodeFromResponse {
	public VerifyStatusCodeFromResponse() {
	}

	public void run(HashMap<String, Object> params) throws Exception {
		try {
			String strRef = Get.param(params, "Reference").toString();
			int strStatusCode = Integer.parseInt(Get.param(params, "Status Code").toString());
			Response reference = null;
			if (RestAPI.Response.containsKey(strRef)) {
				reference = (Response)RestAPI.Response.get(strRef);
			} else {
				Log.error("No Rest API Response Reference is created with provided Reference : " + strRef);
			}

			if (reference.getStatusCode() == strStatusCode) {
				Log.passed("Status Code of the response with Reference name : " + strRef + " is as expected : " + reference.getStatusCode());
			} else {
				Log.error("Status Code of the response with Reference name : " + strRef + " is not as expected, Actual " + Integer.toString(reference.getStatusCode()) + " , Expected is " + Integer.toString(strStatusCode));
			}

		} catch (Exception var5) {
			Log.error("Exception caught in VerifyStatusCodeFromResponse Action, Message is " + var5.getMessage());
			throw var5;
		}
	}
}