package com.suntech.intelliswaut.selenium.actions.restapi;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public class InvokeRestDeleteRequestWithBody {
    public void run(HashMap<String, Object> params) throws Exception{
        String strCon =  Get.param(params,"Connection Name").toString();
        String strFile =  Get.param(params,"JSON FileName").toString();

        RequestSpecification connection= null;

        if (RestAPI.Rest.containsKey(strCon)) {
            connection = RestAPI.Rest.get(strCon);
        }else{
            Log.error( "No Rest API object is created with provided Connection string : "+strCon);
        }

        String str = null;
        try{
            Response response = null;
            if( Get.param(params,"DELETE URL")==null){
                Log.error("Delete Rest url is not provided ");
            }else{
                //response = connection.contentType(ContentType.JSON).body( Get.param(params,"Body").toString()).post( Get.param(params,"URL").toString());
                response = connection.contentType(ContentType.JSON).body(new File(strFile)).delete( Get.param(params,"DELETE URL").toString());
            }
            Log.passed("Rest response for the Delete request with url "+  Get.param(params,"DELETE URL").toString() + " is as below" );
            RestAPI.Response.put( Get.param(params,"Reference").toString(),response);
            Log.jsonInfo(response.getBody().asString());
            System.out.println("Response for Delete operaion of Reference string "+ Get.param(params,"Reference").toString() + " is : " + response.getBody().asString());
        }catch(Exception e){
            Log.error("Exception caught in InvokeRestPostRequest Action, Message is "+e.getMessage());
            Log.error("Exception caught in InvokeRestPostRequest Action, Message is "+ Arrays.toString(e.getStackTrace()));

            throw e;
        }
    }


}



