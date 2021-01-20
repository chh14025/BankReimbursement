//package com.rev.util;
//
//import java.lang.invoke.MethodHandles;
//import java.util.List;
//
//import org.apache.log4j.Level;
//import org.apache.log4j.Logger;
//
//import com.rev.pojo.Users;
//public class Loggy {
//	
//	  private static Logger loggy = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
//	  
//	  public static void startLogger() {
//	        loggy.setLevel(Level.ALL);
//	     }
//	    
//	    public static void info(String action) {
//	        loggy.info(action);
//	    }
//	    public static void warn(String warning) {
//	        loggy.warn(warning);
//	    }
//	    public static void infoList(List<Users> list) {
//	        loggy.info(list);
//	    }
//
//}
