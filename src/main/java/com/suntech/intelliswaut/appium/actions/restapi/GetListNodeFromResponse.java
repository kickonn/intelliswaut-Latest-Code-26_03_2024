package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;

import io.restassured.response.Response;

public class GetListNodeFromResponse{
    public List<Map<String, String>> run(HashMap<String, Object> params){
        
        String strRef = params.get("Reference").toString();
        String strPath = params.get("Path").toString();
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
            Assert.assertTrue(false, "No Rest API Response Reference is created with provided Reference : "+strRef);
        }
		try{
            List<Map<String, String>> accounts = reference.jsonPath().getList(strPath);
            System.out.println(accounts);
            
            return accounts;
        }catch(Exception ex){
            Assert.assertTrue(false, "Exception caught : "+ex.getMessage());
            return null;
        }
    }
}