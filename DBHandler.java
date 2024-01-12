package shop;
import java.sql.*;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBHandler {
	 static final String dbURL = "jdbc:sqlserver://SHAHZAIB\\SQLEXPRESS;databaseName=LeaveManagement;user=sa;password=123;encrypt=false;";
	   Connection conn;
	    Statement statement;
	    ResultSet rs;
     public void dbconnection(String q) {
    	  	 
        try { 
        	conn = DriverManager.getConnection(dbURL); 
        if (conn != null) {
            statement = conn.createStatement();
            int rows = statement.executeUpdate(q);
            if (rows > 0) {
                System.out.println("Data Inserted Successfully");
            }
            else {
                System.out.println("Error Inserting Data");
            }
        }else {
            System.out.println("Data Did not Reached");
        }
        
        }catch(SQLException e) {
        	e.getStackTrace();
        }
        }
     
     
     public ResultSet getdata(String q) {
         ResultSet rs = null; 
         try {
             conn = DriverManager.getConnection(dbURL);
             if (conn != null) {
                 statement = conn.createStatement();
                 rs = statement.executeQuery(q);
             }
         } catch (SQLException e) {
             e.printStackTrace();
         }
         return rs;
     }

        public void close() {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
}