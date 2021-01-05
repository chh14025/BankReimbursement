package com.rev.util;

import java.sql.*;


public class ConnectionCenter {
	
//	private static Connection conn;
//	
//	public static Connection getConnection() {
//		
//		Connection con = null;
//	    if (System.getenv("planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com") != null) {
//	      try {
//	      Class.forName("org.postgresql.Driver");
//	      String dbName = "";
//	      String userName = System.getenv("postgres");
//	      String password = System.getenv("jowill7!");
//	      String hostname = System.getenv("planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com");
//	      String port = System.getProperty("5432");
//	      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//	      System.out.println("Getting remote connection with connection string from environment variables.");
//	      con = DriverManager.getConnection(jdbcUrl);
//	      System.out.println("Remote connection successful.");
//	      conn = con;
//	    }
//	    catch (ClassNotFoundException e) { System.out.println(e.toString());}
//	    catch (SQLException e) { System.out.println(e.toString());}
//	    }
//	    return conn;
//	  }
//		
//		public static Connection getConnection() {
//		    if (System.getenv("planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com") != null) {
//		      try {
//		      Class.forName("org.postgresql.Driver");
//		      String dbName = "";
//		      String userName = System.getenv("postgres");
//		      String password = System.getenv("jowill7!");
//		      String hostname = System.getenv("planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com");
//		      String port = System.getenv("6543");
//		      String jdbcUrl = "jdbc:postgresql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password;
//		      System.out.println("Getting remote connection with connection string from environment variables.");
//		      Connection con = DriverManager.getConnection(jdbcUrl);
//		      System.out.println("Remote connection successful.");
//		      conn = con;
//		    }
//		    catch (ClassNotFoundException e) { System.out.println(e.toString());}
//		    catch (SQLException e) { System.out.println(e.toString());}
//		    }
//		    return conn;
//		  }
	
//	private static final String URL = "jdbc:postgresql://planet-db.cajbwopfnhwq.us-east-2.rds.amazonaws.com/postgres";
//	private static final String USERNAME = "postgres";
//	private static final String PASSWORD = "jowill7!";
	
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return conn;
	}
}
