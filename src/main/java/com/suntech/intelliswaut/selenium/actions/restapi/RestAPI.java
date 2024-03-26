package com.suntech.intelliswaut.selenium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI{

	public static HashMap<String, RequestSpecification> Rest = new HashMap<String, RequestSpecification>();
	public static HashMap<String, Response> Response = new HashMap<String, Response>();

	public void run(HashMap<String, Object> params) throws Exception{
		try{
			if( Get.param(params,"Username")==null){
				RestAssured.baseURI =  Get.param(params,"URL").toString();
				Rest.put( Get.param(params,"Connection Name").toString(),RestAssured.given());
				Log.passed("Created the Rest API Connection "+ Get.param(params,"URL").toString());
			}else{
				String userName =  Get.param(params,"Username").toString();
				String password =  Get.param(params,"Password").toString();
				RestAssured.baseURI =  Get.param(params,"URL").toString();
				Rest.put( Get.param(params,"Connection Name").toString(),RestAssured.given().auth().basic(userName, password));            
				Log.passed("Created the Rest API Connection "+ Get.param(params,"URL").toString());
			}
		}catch(Exception e){			
			Log.error("Exception caught in RestAPI Action, Message is "+e.getMessage());		
			throw e;
		}
	}
}