package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.RestAssured;

public class RestAPIOauth {
	public void run(HashMap<String, Object> params){
            String token = params.get("Token").toString();            
            RestAssured.baseURI = params.get("URL").toString();
            RestAPI.Rest.put(params.get("Connection Name").toString(),RestAssured.given().auth().oauth2(token));            
            Log.passed("Created the Rest API Connection "+params.get("URL").toString());
    }
}
