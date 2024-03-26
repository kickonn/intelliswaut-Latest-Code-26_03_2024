package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.response.Response;


public class VerifyNodeFromResponse{
    public void run(HashMap<String, Object> params) throws Exception{
        String strRef =  Get.param(params,"Reference").toString();
        String strPath =  Get.param(params,"Path").toString();
        String strExpValue =  Get.param(params,"Value").toString();
        
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
        	Log.error("No Rest API Response Reference is created with provided Reference : "+strRef);
        }
		try{
            String accounts = reference.jsonPath().get(strPath);            
            if(accounts.equalsIgnoreCase(strExpValue)){
                Log.passed("Value of the node path "+strPath+" is  as expected :"+accounts); 
            }else{
            	Log.error("Value of the node path "+strPath+" is not as expected, Actual is :"+accounts + " But expected is : "+strExpValue);
            }
            
        }catch(Exception e){
        	Log.error("Exception caught in VerifyNodeFromResponse Action, Message is "+e.getMessage());            
        	throw e;
        }
    }
}