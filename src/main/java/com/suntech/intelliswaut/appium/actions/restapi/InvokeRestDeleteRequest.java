package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class InvokeRestDeleteRequest{
    public void run(HashMap<String, Object> params){
        
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
            if(params.get("DELETE URL")==null){
                Assert.assertTrue(false, "Delete Rest url is not provided ");
            }else{                
                response = connection.contentType(ContentType.JSON).delete(params.get("DELETE URL").toString());                
            } 
            Log.passed("Rest response for the DELETE request with url "+ params.get("DELETE URL").toString() + " is as below" );
            RestAPI.Response.put(params.get("Reference").toString(),response);    
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for DELETE operaion of Reference string "+params.get("Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception ex){			
			throw ex;			
		}	
    }
}