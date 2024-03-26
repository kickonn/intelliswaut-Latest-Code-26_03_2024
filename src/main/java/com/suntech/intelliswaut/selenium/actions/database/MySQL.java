package com.suntech.intelliswaut.selenium.actions.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import com.suntech.intelliswaut.selenium.actions.jselenium.Get;
import com.suntech.intelliswaut.selenium.actions.reports.Log;


public class MySQL {

	
	public static HashMap<String, Statement> MySqlDB = new HashMap<String, Statement>();	

	public void run(HashMap<String, Object> params) throws Exception {
   
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String server =  Get.param(params,"Server").toString();
			String port =  Get.param(params,"Port").toString();
			String dbname =  Get.param(params,"DBName").toString();
			//String connString = "jdbc:mysql://"+server+":"+port+"/"+dbname+"";
			String connString = "jdbc:mysql://" + server + ":" + port + "/" + dbname
					+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
			String username =  Get.param(params,"Username").toString();
			String Password =  Get.param(params,"Password").toString();
			con=DriverManager.getConnection(connString,username,Password);  			
			stmt=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
			MySqlDB.put( Get.param(params,"MYSQL Ref Name").toString(),stmt);
			
		} catch (ClassNotFoundException e) {
            Log.error("Database Creation UnSuccessfull"+e.getMessage());		
            throw e;
		} catch (Exception e) {
            Log.error("Database Creation UnSuccessfull"+e.getMessage());		
            throw e;
		} 
	}
}
