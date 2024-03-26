 package com.suntech.intelliswaut.appium.actions.restapi;

import java.util.HashMap;

import com.suntech.intelliswaut.appium.actions.reports.Log;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAPI{
        
    public static HashMap<String, RequestSpecification> Rest = new HashMap<String, RequestSpecification>();
    public static HashMap<String, Response> Response = new HashMap<String, Response>();
    
    public void run(HashMap<String, Object> params){
        if(params.get("Username")==null){
            RestAssured.baseURI = params.get("URL").toString();
            Rest.put(params.get("Connection Name").toString(),RestAssured.given());
            Log.passed("Created the Rest API Connection "+params.get("URL").toString());
         }else{
            String userName = params.get("Username").toString();
            String password = params.get("Password").toString();
            RestAssured.baseURI = params.get("URL").toString();
            Rest.put(params.get("Connection Name").toString(),RestAssured.given().auth().basic(userName, password));            
            Log.passed("Created the Rest API Connection "+params.get("URL").toString());
        }
    }
}