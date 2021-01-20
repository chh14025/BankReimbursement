package com.rev.util;

import java.sql.*;


public class ConnectionCenter {
	
	
	private static Connection conn;
	private static final String URL = "jdbc:postgresql://planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com/postgres";
	private static final String USERNAME = "postgres";
	private static final String PASSWORD = "jowill7!";
	
	
	public static Connection getConnection() {
		
		try {
		      Class.forName("org.postgresql.Driver");

			if(conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
