package com.rev.util;

import java.sql.*;


public class ConnectionCenter {
	
	
	private static Connection conn;
	private static final String URL = "";
	private static final String USERNAME = "";
	private static final String PASSWORD = "";
	
	
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
