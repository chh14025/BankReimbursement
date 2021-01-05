package com.rev.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {
	
	public static void process (HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException{
		String endpoint = req.getRequestURI();
		System.out.println(endpoint);
		
		switch(endpoint) {	
		case "/ReimbursementProject/bank/employee":
			System.out.println("Inside employee");
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
			System.out.println("Inside confirm");
			switch(req.getMethod()) {
			case "POST":
				UserController.postNewUser(req, resp);
				break;
			case "GET":
				UserController.getAllUser(req, resp);
			}
			break;
			
		case "/ReimbursementProject/bank/login":
			System.out.println("Inside login");
			LandingController.getLogin(req, resp);
			break;
			
		case "/ReimbursementProject/bank/signup":
			System.out.println("Inside signup");
			LandingController.getSignup(req, resp);
			break;
			
		case "/ReimbursementProject/bank/getTicket":
			System.out.println("Inside getTicket");
			LandingController.getTicket(req, resp);
			break;
			
		case "/ReimbursementProject/bank/empLanding":
			System.out.println("Inside empLanding");
			LandingController.getEmpPage(req, resp);
			break;
			
		case "/ReimbursementProject/bank/newTicket":
			System.out.println("Inside empLanding");
			LandingController.postNewTicket(req, resp);
			break;
		case "/ReimbursementProject/bank/logout":
			System.out.println("In the home page");
			LandingController.logout(req, resp);
			break;
			
		case "/ReimbursementProject/bank/ticketLanding":
			System.out.println("In the ticket landing page");
			LandingController.ticketLanding(req, resp);
			break;
		case "/ReimbursementProject/bank/success":
			System.out.println("In the ticket landing page");
			LandingController.successPage(req, resp);
			break;
			
		case "/ReimbursementProject/bank":
			System.out.println("In the home page");
			LandingController.getHomePage(req, resp);
			break;
			




		default:
			System.out.println("Nothing here");
			break;
			
		}
	}
}
