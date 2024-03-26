package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class GetResponseHeader{
	public String run(HashMap<String, Object> params) throws Exception{
		try{
			String strRef =  Get.param(params,"Reference").toString();
			String strHeader =  Get.param(params,"HeaderName").toString();
			Response reference = null;
			if (RestAPI.Response.containsKey(strRef)) {
				reference = RestAPI.Response.get(strRef);
			}else{
				Log.error("No Rest API Response Reference is created with provided Reference : "+strRef);
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
						return header.getValue();
					}
				}   
				if(!blnFound){
					Log.error( "Header with name : "+strHeader + " is not found for the reference : "+strRef);
				}
			}else{
				Log.error( "Header  name paramter is required, Please pass the header name as parameter to the action");
			}
			return null;
		}catch(Exception e){
			Log.error("Exception caught in GetResponseHeader Action, Message is "+e.getMessage());
			throw e;
		}
	}
}