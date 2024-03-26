package com.suntech.intelliswaut.selenium.actions.database;

import java.util.HashMap;
import java.util.List;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class VerifyDatabaseFieldValue {



	public String run(HashMap<String, Object> params) throws Exception {

		String colValue = null;

		try {
			String strDatabaseRef =  Get.param(params,"Database Ref Name").toString();
			int rowNumber = Integer.parseInt( Get.param(params,"RowNumber").toString());
			String colType =  Get.param(params,"Column Type").toString();
			String column =  Get.param(params,"Column").toString();
			String expValue =  Get.param(params,"Expected Value").toString();

			
			if(ExecuteQuery.ResultSet.containsKey(strDatabaseRef)) {
				List<HashMap<String, Object>> ResultSet = ExecuteQuery.ResultSet.get(strDatabaseRef);

				if(rowNumber<=ResultSet.size()) {
					if(colType.contains("index")) {
						colValue = ResultSet.get(rowNumber).get(Integer.parseInt(column)).toString();	
					}else {
						colValue = ResultSet.get(rowNumber).get(column).toString();
					}			
					if(colValue.equalsIgnoreCase(expValue)) {
						Log.passed("Expected column value exists in the database in row "+rowNumber +" and column "+column+" column value is "+colValue);
					}else {
						Log.error("Expected column value does not exists in the database in row "+rowNumber +" and column "+column + ": Expected is -"+expValue + ", But actual is - "+colValue);
					}
				}else{
                    Log.error("Number of records in the Resultset  is less than the requested row , Total records is :"+ResultSet.size() +", requested Row number is "+rowNumber);								
				}			
			}
		} catch (Exception e) {
             Log.error("Database Fields Not Fetched");
             throw e;
		}
		return colValue;
	}
}
