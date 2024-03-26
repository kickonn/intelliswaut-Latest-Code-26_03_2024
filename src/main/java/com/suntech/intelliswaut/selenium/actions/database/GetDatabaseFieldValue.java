package com.suntech.intelliswaut.selenium.actions.database;

import java.util.HashMap;
import java.util.List;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class GetDatabaseFieldValue {



	public String run(HashMap<String, Object> params) throws Exception {

		String colValue = null;

		try {
			String strDatabaseRef =  Get.param(params,"Database Ref Name").toString();
			int rowNumber = Integer.parseInt( Get.param(params,"RowNumber").toString());
			String colType =  Get.param(params,"Column Type").toString();
			String column =  Get.param(params,"Column").toString();
			
			if(ExecuteQuery.ResultSet.containsKey(strDatabaseRef)) {
				List<HashMap<String, Object>> ResultSet = ExecuteQuery.ResultSet.get(strDatabaseRef);
				Log.info("ResultSet size is : "+ResultSet.size());

				if(rowNumber<=ResultSet.size()) {
                   
					if(colType.contains("index")) {
						
                        colValue = ResultSet.get(rowNumber).get(Integer.parseInt(column)).toString();


						Log.passed("Data Retrived from DB is  "+colValue);						
						//colValue =ResultSet.get(Integer.parseInt(column)).toString();
						//System.out.println("value"+colValue);
                        
					}else{
                       
						 colValue = ResultSet.get(rowNumber).get(column).toString();
                      	 Log.passed("Data Retrived from DB is   "+colValue);						  
					}								
				}else{									
                    Log.error("Number of records in the Resultset  is less than the requested row ");
				}			
			}
		} catch (Exception e) {
            Log.error("Database Field Not Fetched "+e.getMessage());	
            throw e;
		}
		return colValue.toString();
	}
}
