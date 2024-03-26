package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.response.Response;

public class GetListNodeFromResponse{
    public List<Map<String, String>> run(HashMap<String, Object> params) throws Exception{
        
        String strRef =  Get.param(params,"Reference").toString();
        String strPath =  Get.param(params,"Path").toString();
        Response reference = null;
         if (RestAPI.Response.containsKey(strRef)) {
        	reference = RestAPI.Response.get(strRef);
        }else{
        	Log.error("No Rest API Response Reference is created with provided Reference : "+strRef);
        }
		try{
            List<Map<String, String>> accounts = reference.jsonPath().getList(strPath);
            System.out.println(accounts);
            
            return accounts;
        }catch(Exception e){
        	Log.error("Exception caught in GetListNodeFromResponse Action, Message is "+e.getMessage());
        	throw e;
        }
    }
}