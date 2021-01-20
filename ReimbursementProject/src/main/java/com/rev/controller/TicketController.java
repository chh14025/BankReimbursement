package com.rev.controller;

import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rev.pojo.Tickets;
import com.rev.pojo.Users;
import com.rev.service.ReimbursementManagement;
import com.rev.util.JavaMailUtil;

public class TicketController {
	
	private static ReimbursementManagement rService = new ReimbursementManagement();
	private static Logger loggy = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	
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
			double d = Double.parseDouble(req.getParameter("amount"));
			rService.newTicket(i, req.getParameter("comment"), u.getUserId(), d);
			try {
				JavaMailUtil.sendMail(u.getEmail());
			} catch (Exception e) {
				e.printStackTrace();
			}
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
