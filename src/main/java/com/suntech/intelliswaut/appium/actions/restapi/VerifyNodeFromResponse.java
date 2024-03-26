package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.response.Response;


public class VerifyNodeFromResponse{
    public void run(HashMap<String, Object> params) throws Exception{
        String strRef = params.get("Reference").toString();
        String strPath = params.get("Path").toString();
        String strExpValue = params.get("Value").toString();
        
        
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
               // System.out.println("Value of the node path "+strPath+" is  as expected :"+accounts); 
            }else{
                Log.failed("Value of the node path "+strPath+" is not as expected, Actual is :"+accounts + " But expected is : "+strExpValue);
               // Assert.assertTrue(false, "Value of the node path "+strPath+" is not as expected, Actual is :"+accounts + " But expected is : "+strExpValue);
            }
            
        }catch(Exception ex){
            Assert.assertTrue(false, "Exception caught : "+ex.getMessage());
            throw ex;
        }
    }
}