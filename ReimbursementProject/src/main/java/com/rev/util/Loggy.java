package com.rev.util;

import java.util.List;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rev.pojo.Users;
import com.rev.service.ReimbursementManagement;

public class Loggy {
	
	final static Logger loggy = Logger.getLogger(ReimbursementManagement.class);

	
	 public static void startLogger() {
	        loggy.setLevel(Level.ALL);
	     }
	    
	    public static void info(String action) {
	        loggy.info(action);
	    }
	    public static void warn(String warning) {
	        loggy.warn(warning);
	    }
	    public static void infoList(List<Users> list) {
	        loggy.info(list);
	    }

}
