package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.response.Response;

public class VerifyStatusCodeFromResponse{
    public void run(HashMap<String, Object> params) throws Exception{
        String strRef = params.get("Reference").toString();
        int strStatusCode = Integer.parseInt(params.get("Status Code").toString());
        
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
        	Log.error("No Rest API Response Reference is created with provided Reference : "+strRef);
        }
        
        if(reference.getStatusCode()==strStatusCode){
           Log.passed("Status Code of the response with Reference name : "+strRef + " is as expected : "+ reference.getStatusCode()); 
        }else{
        	Log.error("Status Code of the response with Reference name : "+ strRef + " is not as expected, Actual "+ Integer.toString(reference.getStatusCode()) + " , Expected is "+ Integer.toString(strStatusCode));
        }
        
    }
}