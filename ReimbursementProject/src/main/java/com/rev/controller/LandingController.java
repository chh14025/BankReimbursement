package com.rev.controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;

import com.rev.pojo.Users;
//import com.rev.util.Loggy;

public class LandingController {
	
	 private static Logger loggy = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	
	public static void getHomePage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		
		RequestDispatcher redis = req.getRequestDispatcher("/index.html");
		redis.forward(req, resp);
		
	}
	
	public static void getLogin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{		
		
		RequestDispatcher redis = req.getRequestDispatcher("/login.html");
		redis.forward(req, resp);

	}
	
	public static void getSignup(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{		
		RequestDispatcher redis = req.getRequestDispatcher("/signup.html");
		redis.forward(req, resp);
			
	}	
	
	public static void AdminSignup(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		RequestDispatcher redis = req.getRequestDispatcher("/adminsignup.html");
		redis.forward(req, resp);
		
	}
	
	public static void getTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{		
		RequestDispatcher redis = req.getRequestDispatcher("/allticket.html");
		redis.forward(req, resp);
			
	}	
	
	public static void getEmpPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{	
			
		if(req.getSession(false) != null) {
			HttpSession session = req.getSession(true);
			Users u = (Users) session.getAttribute("user");
			if (u.getUserStatus() == 1) {
				loggy.info(u + "in employee html");
				RequestDispatcher redis = req.getRequestDispatcher("/employee.html");
				redis.forward(req, resp);
			}else if (u.getUserStatus() ==2 ) {
				loggy.info(u + "in admin html");

				RequestDispatcher redis = req.getRequestDispatcher("/manager.html");
				redis.forward(req, resp);
			}
		}else {
			resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank/login");
		}
	
	}
	

	public static void logout(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		req.getSession().invalidate();
		loggy.info("session invalidated");
		resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank");
		return; 
	}
	
	public static void postNewTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{		
		RequestDispatcher redis = req.getRequestDispatcher("/newticket.html");
		redis.forward(req, resp);			
	}	
	
	public static void ticketLanding(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{		
		RequestDispatcher redis = req.getRequestDispatcher("/vewuserticket.html");
		redis.forward(req, resp);
			
	}	
	public static void successPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		RequestDispatcher redis = req.getRequestDispatcher("/success.html");
		redis.forward(req, resp);
		
	}
	
	public static void failPage(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		
		RequestDispatcher redis = req.getRequestDispatcher("/fail.html");
		redis.forward(req, resp);
		
	}
	
	

}
