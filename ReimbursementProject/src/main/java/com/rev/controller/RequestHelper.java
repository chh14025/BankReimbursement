package com.rev.controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;


public class RequestHelper {
	
	private static Logger loggy = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());
	
	  	
	public static void process (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		loggy.setLevel(Level.ALL);
		String endpoint = req.getRequestURI();
		loggy.info(endpoint);
		
		switch(endpoint) {	
		case "/ReimbursementProject/bank/employee":
			loggy.info("Inside bank employee");
			switch(req.getMethod()) {
			case "POST":
				UserController.postSignin(req,resp);
				break;
			case "GET":
				UserController.getUserTicket(req, resp);
				break;
			case "DELETE":
				break;
			case "PUT":
				break;
			
			}
			break;
			
		case "/ReimbursementProject/bank/ticket":
			loggy.info("Inside bank ticket");
			switch(req.getMethod()) {
			case "POST":
				TicketController.newTicket(req,resp);
				break;
			case "GET":
				TicketController.getTicket(req, resp);
				break;
			case "DELETE":
				break;
			case "PUT":
				TicketController.putTicket(req, resp);
				break;
			
			}
			break;
			
		case "/ReimbursementProject/bank/confirm":
			loggy.info("Inside user confirmation");
			switch(req.getMethod()) {
			case "POST":
				UserController.postNewUser(req, resp);
				break;
			case "GET":
				UserController.getAllUser(req, resp);
				break;
			}
			break;
			
		case "/ReimbursementProject/bank/login":
			loggy.info("Inside login");
			LandingController.getLogin(req, resp);
			break;
			
		case "/ReimbursementProject/bank/signup":
			loggy.info("Inside signup");
			LandingController.getSignup(req, resp);
			break;
			
		case "/ReimbursementProject/bank/getTicket":
			loggy.info("Inside getTicket");
			LandingController.getTicket(req, resp);
			break;
			
		case "/ReimbursementProject/bank/empLanding":
			loggy.info("Inside empLanding");
			LandingController.getEmpPage(req, resp);
			break;
			
		case "/ReimbursementProject/bank/newTicket":
			loggy.info("Inside empLanding");
			LandingController.postNewTicket(req, resp);
			break;
		case "/ReimbursementProject/bank/logout":
			loggy.info("In the home page");
			LandingController.logout(req, resp);
			break;
			
		case "/ReimbursementProject/bank/ticketLanding":
			loggy.info("In the ticket landing page");
			LandingController.ticketLanding(req, resp);
			break;
		case "/ReimbursementProject/bank/success":
			loggy.info("In the ticket landing page");
			LandingController.successPage(req, resp);
			break;
		case "/ReimbursementProject/bank/fail":
			loggy.info("In the ticket landing page");
			LandingController.failPage(req, resp);
			break;
			
		case "/ReimbursementProject/bank/check":
			loggy.info("In the ticket landing page");
			UserController.SigninCheck(req, resp);
			break;
		case "/ReimbursementProject/bank/adminSignup":
			loggy.info("In the admin signup page");
			LandingController.AdminSignup(req, resp);
			break;
			
		case "/ReimbursementProject/bank":
			loggy.info("In the home page");
			LandingController.getHomePage(req, resp);
			break;
		default:
			loggy.info("In default home page");
			LandingController.getHomePage(req, resp);
			break;
			
		}
	}
}
