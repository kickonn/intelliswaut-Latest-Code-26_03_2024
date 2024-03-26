package com.suntech.intelliswaut.appium.actions.restapi;

import java.io.File;
import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class InvokeRestPostRequest{
    public void run(HashMap<String, Object> params){
         String strCon = params.get("Connection Name").toString();
        String strFile = params.get("JSON FileName").toString();
        
        RequestSpecification connection= null;
        
        if (RestAPI.Rest.containsKey(strCon)) {
        	connection = RestAPI.Rest.get(strCon);
        }else{
            Assert.assertTrue(false, "No Rest API object is created with provided Connection string : "+strCon);
        }
        
        String str = null;
        try{
            Response response = null;
            if(params.get("POST URL")==null){
                Assert.assertTrue(false, "Post Rest url is not provided ");
            }else{
                //response = connection.contentType(ContentType.JSON).body(params.get("Body").toString()).post(params.get("URL").toString());              
            	response = connection.contentType(ContentType.JSON).body(new File(strFile)).post(params.get("POST URL").toString());
            } 
            Log.passed("Rest response for the POST request with url "+ params.get("POST URL").toString() + " is as below" );
            RestAPI.Response.put(params.get("Reference").toString(),response); 
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for POST operaion of Reference string "+params.get("Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception ex){			
			throw ex;			
		}	
    }
}