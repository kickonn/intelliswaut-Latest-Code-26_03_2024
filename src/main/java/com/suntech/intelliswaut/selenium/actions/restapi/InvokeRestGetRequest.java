package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class InvokeRestGetRequest{    
    public void run(HashMap<String, Object> params) throws Exception{
                                
        String strCon =  Get.param(params,"Connection Name").toString();
        
        RequestSpecification connection= null;
        
        if (RestAPI.Rest.containsKey(strCon)) {
        	connection = RestAPI.Rest.get(strCon);
        }else{
        	Log.error( "No Rest API object is created with provided Connection string : "+strCon);
        }
        
        String str = null;
        try{
            Response response = null;
            if( Get.param(params,"GET URL")==null){
                response = connection.get();                
            }else{
                response = connection.get( Get.param(params,"GET URL").toString());                
            } 
            Log.passed("Rest response for the GET request with url "+  Get.param(params,"GET URL").toString() + " is as below" );
            RestAPI.Response.put( Get.param(params,"Reference").toString(),response); 
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for GET operaion of the Reference string "+ Get.param(params,"Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception e){			
        	Log.error("Exception caught in InvokeRestGetRequest Action, Message is "+e.getMessage());		
        	throw e;
        }		
    }
}