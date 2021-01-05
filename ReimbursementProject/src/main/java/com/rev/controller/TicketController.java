package com.rev.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.Tickets;
import com.rev.pojo.Users;
import com.rev.service.ReimbursementManagement;

public class TicketController {
	
	private static ReimbursementManagement rService = new ReimbursementManagement();
	
	public static void getTicket(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		if(req.getMethod().equals("GET")) {
			resp.setContentType("application/json");

			List<Tickets> tik = rService.getAllTickets();
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(tik));
			
			
		}else {
			resp.setStatus(405);
		}
		
	}
	
	public static void newTicket(HttpServletRequest req, HttpServletResponse resp)
		throws ServletException, IOException{
		
		if(req.getMethod().equals("POST")) {
	
			System.out.println("inside new ticket");
			HttpSession session = req.getSession(true);
			Users u = (Users) session.getAttribute("user");
			int i = Integer.parseInt(req.getParameter("ticketType"));
			rService.newTicket(i, req.getParameter("comment"), u.getUserId());
			resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank/empLanding");
			
		}else {
			resp.setStatus(400);
		}
		
		
	}
	
	public static void putTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			
			if(req.getMethod().equals("PUT")) {
				System.out.println("inside new ticket");
				Tickets t = new ObjectMapper().readValue(req.getReader(), com.rev.pojo.Tickets.class);
				System.out.println(t);	
				rService.updateTicket(t.getTicketStatus(), t.getTicketNumber());
				resp.setStatus(200);
			}else {
				resp.setStatus(400);
			}
			
			
		}
	
	

}
