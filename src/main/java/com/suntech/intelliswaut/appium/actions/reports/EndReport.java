package com.suntech.intelliswaut.appium.actions.reports;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;

import org.testng.Assert;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.filter.HTTPBasicAuthFilter;
import  com.suntech.intelliswaut.selenium.actions.jselenium.Get;

public class EndReport {
	public void run(HashMap<String, Object> params){
		
		String testcasename = StartReport.testcasename;
		String error = Log.errorMsg;
		
		if(StartReport.extent==null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}
		
		if(StartReport.parent==null) {
			Assert.assertTrue(false, "Extent report is not started. Please call the Start Report action before the start of test");
		}
		try{
			String browser = Get.Global("Browser");
			String jira = Get.Global("JIRA_INTEGRATION");
			if(Log.strFail){
				if(jira.equalsIgnoreCase("yes")){
					String jiraUrl = Get.Global("JIRA_URL") + "rest/api/2/issue/";
					String jiraUsername =  Get.Global("JIRA_Username");
					String jiraPassword =  Get.Global("JIRA_Password");
					String jiraProjectKey =  Get.Global("JIRA_Project_Key");		
					createJiraTicket(jiraUrl,jiraUsername,jiraPassword,jiraProjectKey,"Falied  "+testcasename,error);
				}
			}
		} catch (Exception e) {
			StartReport.parent.fail("Failed while creating JIRA Call: Exception Caught, Message is->"+e.getMessage());	        
			throw e;
		}
		StartReport.parent.info( "########### End of Test Case :  ###########");		
		StartReport.extent.flush();
		StartReport.parent = null;
		
	}
	
	
	
	
	public static void createJiraTicket(String url,String username,String password,String projectKey,String strSummary,String strDescription) {
		try {
			
			Client client = Client.create();
			client.addFilter(new HTTPBasicAuthFilter(username, password));
			String input = "{\"fields\":{\"project\":{\"key\":\""+projectKey+"\"},\"summary\":\""+strSummary+"\",\"description\": \""+strDescription+"\",\"issuetype\":{\"name\":\"Bug\"}}}";
			StartReport.parent.info( "JIRA Info "+url+ " : "+ input);
			WebResource resource = client.resource(url);
			ClientResponse response = resource.type("application/json").accept("application/json").post(ClientResponse.class,input);

			if (response.getStatus() != 201) {
				StartReport.parent.fail("Failed while creating JIRA : HTTP error code :"+ response.getStatus());
			}else{
				BufferedReader inputStream = new BufferedReader(new InputStreamReader(response.getEntityInputStream()));
				  String line = null;		  
				  while ((line = inputStream.readLine()) != null) {
					  StartReport.parent.info( "Successfully logged JIRA ticket,Please review the JIRA TICKET Number : " + line.split("\"")[7]);					  
				  }
			}	     
			
		} catch (Exception e) {
			StartReport.parent.fail("Failed while creating JIRA : Exception Caught, Message is->"+e.getMessage());	        
			
		}
	}
}
