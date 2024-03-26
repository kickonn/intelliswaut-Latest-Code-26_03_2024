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

public class ExecuteQuery {

    public static HashMap<String, List<HashMap<String, Object>>> ResultSet = new HashMap<String, List<HashMap<String, Object>>>();

    public int run(HashMap<String, Object> params) throws Exception {

        try {
            String strReference = Get.param(params, "MYSQL Ref Name").toString();
            String strDatabaseRef = Get.param(params, "Database Ref Name").toString();
            String strQuery = Get.param(params, "Query");

            if (MySQL.MySqlDB.containsKey(strReference)) {
                Statement stmt = MySQL.MySqlDB.get(strReference);


                ResultSet rs = stmt.executeQuery(strQuery);

                Log.passed("Query '" + strQuery + "' Executed Successfully");
                List<HashMap<String, Object>> Result = resultSetToList(rs);

                try {
                    ResultSet.put(strDatabaseRef, Result);
                } catch (ClassCastException e) {

                }

                return Result.size();


            } else {
                Log.error("Query " + strQuery + " Not Executed");

                return 0;
            }

        } catch (Exception e) {
            Log.error("Query Not Executed");
            throw e;
        }

    }

    List<HashMap<String, Object>> rows = new ArrayList<HashMap<String, Object>>();

    private List<HashMap<String, Object>> resultSetToList(ResultSet rs) {

        while (true) {
            try {
                if (!rs.next()) break;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            try {
                ResultSetMetaData md = rs.getMetaData();
                int columns = md.getColumnCount();
                HashMap<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    if (rs.getObject(i) instanceof Integer) {
                        row.put(md.getColumnName(i), rs.getObject(i).toString());
                    } else {
                        row.put(md.getColumnName(i), rs.getObject(i).toString());
                    }
                }
                rows.add(row);
            } catch (ClassCastException e) {

            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return rows;
    }

}
