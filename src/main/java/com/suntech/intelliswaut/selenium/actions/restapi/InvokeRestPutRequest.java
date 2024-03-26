package com.suntech.intelliswaut.selenium.actions.restapi;

import java.io.File;
import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class InvokeRestPutRequest{
    public void run(HashMap<String, Object> params) throws Exception{
        String strCon =  Get.param(params,"Connection Name").toString();
        String strFile =  Get.param(params,"JSON FileName").toString();
        
        RequestSpecification connection= null;
        
        if (RestAPI.Rest.containsKey(strCon)) {
        	connection = RestAPI.Rest.get(strCon);
        }else{
        	Log.error("No Rest API object is created with provided Connection string : "+strCon);
        }
        
        String str = null;
        try{
            Response response = null;
            if( Get.param(params,"PUT URL")==null){
                Assert.assertTrue(false, "Post Rest url is not provided ");
            }else{
                response = connection.contentType(ContentType.JSON).body(new File(strFile)).put( Get.param(params,"PUT URL").toString());              
            } 
            Log.passed("Rest response for the PUT request with url "+  Get.param(params,"PUT URL").toString() + " is as below" );
            RestAPI.Response.put( Get.param(params,"Reference").toString(),response);            
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for POST operaion of Reference string "+ Get.param(params,"Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception e){			
        	Log.error("Exception caught in InvokeRestPutRequest Action, Message is "+e.getMessage());		
        	throw e;
        }
    }
}