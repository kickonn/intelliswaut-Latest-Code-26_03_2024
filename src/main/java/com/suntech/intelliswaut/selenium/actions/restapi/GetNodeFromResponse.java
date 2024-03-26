package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.response.Response;

public class GetNodeFromResponse {
	public String run(HashMap<String, Object> params) throws Exception {
		Log.passed("Inside GetNodeFromResponse");
		String strRef = params.get("Reference").toString();
		String strPath = params.get("Path").toString();
		Response reference = null;
		if (RestAPI.Response.containsKey(strRef)) {
			reference = RestAPI.Response.get(strRef);
		} else {
			Assert.assertTrue(false, "No Rest API Response Reference is created with provided Reference : " + strRef);
		}
		try {
			String accounts = reference.jsonPath().get(strPath);
			System.out.println(accounts);
			Log.passed("Node value for " + strPath + " is : " + accounts);
			return accounts;
		} catch (Exception ex) {
			Log.failed("Exception caught : " + ex.getMessage());
			Assert.assertTrue(false, "Exception caught : " + ex.getMessage());
			return null;
		}
	}
}