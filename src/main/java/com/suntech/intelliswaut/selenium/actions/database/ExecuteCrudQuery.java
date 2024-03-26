package com.suntech.intelliswaut.selenium.actions.database;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;

public class ExecuteCrudQuery {
	
	public static HashMap<String, List<HashMap<String, Object>>> ResultSet = new HashMap<String, List<HashMap<String, Object>>>();
	
	public void run(HashMap<String, Object> params) throws Exception {
		
		try {
			String strReference =  Get.param(params,"MYSQL Ref Name").toString();
			String strDatabaseRef =  Get.param(params,"Database Ref Name").toString();
			String strQuery =  Get.param(params,"Query").toString();
			
			if(MySQL.MySqlDB.containsKey(strReference)) {
				Statement stmt = MySQL.MySqlDB.get(strReference);
				
				stmt.execute(strQuery);
				
                Log.passed("Query '"+strQuery+"' Executed Successfully");
				
			}else{				
                Log.error("Query "+strQuery+ " Not Executed");
			}
			
		} catch (Exception e) {
             Log.error("Query Not Executed");	
             throw e;			
		}
	}
}
