package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.response.Response;

public class GetStatusCodeFromResponse{
    public int run(HashMap<String, Object> params) throws Exception{
        try{
	        String strRef =  Get.param(params,"Reference").toString();
	        
	        Response reference = null;
	         if (RestAPI.Response.containsKey(strRef)) {
	        	reference = RestAPI.Response.get(strRef);
	        }else{
	        	Log.error("No Rest API Response Reference is created with provided Reference : "+strRef);
	        }
	        Log.info("Response Status Code:: "+reference.getStatusCode());
	        return reference.getStatusCode();
        }catch(Exception e){
			Log.error("Exception caught in GetStatusCodeFromResponse Action, Message is "+e.getMessage());
			throw e;
		}
    }
}