package com.suntech.intelliswaut.selenium.actions.restapi;

import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetNodeFromJSONFile{
    public String run(HashMap<String, Object> params) throws Exception{
        String strPath =  Get.param(params,"File Path").toString();
        String strJsonPath =  Get.param(params,"JSON Path").toString();
       
		try{
			JSONParser parser = new JSONParser();
	        JSONObject data = (JSONObject) parser.parse(
	              new FileReader(strPath));//path to the JSON file.
	        String[] arr = strJsonPath.split("\\.");
	        
	        for(int i=0;i<arr.length-1;i++){
	        	data = (JSONObject)data.get(arr[i]);
	        }
	        String json = data.get(arr[arr.length-1]).toString();
	
		Log.passed("Node value for "+strJsonPath  + " is : "+ json);
            return json;
        }catch(Exception e){
        	Log.error("Exception caught in Get Node From JSON File Action, Message is "+e.getMessage());
        	throw e;
        }
    }
}