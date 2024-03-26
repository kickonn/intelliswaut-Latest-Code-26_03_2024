package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class InvokeRestGetRequest{    
    public void run(HashMap<String, Object> params) throws Exception{
                                
        String strCon = params.get("Connection Name").toString();
        
        RequestSpecification connection= null;
        
        if (RestAPI.Rest.containsKey(strCon)) {
        	connection = RestAPI.Rest.get(strCon);
        }else{
            Assert.assertTrue(false, "No Rest API object is created with provided Connection string : "+strCon);
        }
        
        String str = null;
        try{
            Response response = null;
            if(params.get("GET URL")==null){
                response = connection.get();                
            }else{
                response = connection.get(params.get("GET URL").toString());                
            } 
            Log.passed("Rest response for the GET request with url "+ params.get("GET URL").toString() + " is as below" );
            RestAPI.Response.put(params.get("Reference").toString(),response); 
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for GET operaion of the Reference string "+params.get("Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception ex){			
            Log.failed("Unable to get the response from get URL  : "+ params.get("GET URL").toString() + " Exception is : "+ex.getMessage() );	
            throw ex;
		}		
    }
}