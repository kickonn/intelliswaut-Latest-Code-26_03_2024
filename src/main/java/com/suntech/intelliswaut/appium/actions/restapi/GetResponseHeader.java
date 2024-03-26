package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetResponseHeader{
    public String run(HashMap<String, Object> params){
        
        String strRef = params.get("Reference").toString();
        String strHeader = params.get("HeaderName").toString();
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
            Assert.assertTrue(false, "No Rest API Response Reference is created with provided Reference : "+strRef);
        }
        
        Headers allHeaders = reference.headers();
       
        if(strHeader!=null){
         	// Iterate over all the Headers
            boolean blnFound = false;
             for(Header header : allHeaders)
             {
                System.out.println("Key: " + header.getName() + " Value: " + header.getValue());
                 if(header.getName().equalsIgnoreCase(strHeader)){
                     blnFound = true;
                     System.out.println("-----------------------------------");
                     System.out.println(" Value: " + header.getValue());
                     return header.getValue();
                 }
             }   
            if(!blnFound){
                Assert.assertTrue(false, "Header with name : "+strHeader + " is not found for the reference : "+strRef);
            }
        }else{
            Assert.assertTrue(false, "Header  name paramter is required, Please pass the header name as parameter to the action");
        }
         return null;
    }
}