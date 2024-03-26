package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import org.testng.Assert;

import io.restassured.response.Response;

public class GetStatusCodeFromResponse{
    public int run(HashMap<String, Object> params){
        
        String strRef = params.get("Reference").toString();
        
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
            Assert.assertTrue(false, "No Rest API Response Reference is created with provided Reference : "+strRef);
        }
        System.out.println("Response Status Code:: "+reference.getStatusCode());
        return reference.getStatusCode();
    }
}