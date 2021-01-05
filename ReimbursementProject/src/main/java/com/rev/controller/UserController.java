package com.rev.controller;

import java.io.IOException;
import java.util.Enumeration;
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

public class UserController {
	
	private static ReimbursementManagement rService = new ReimbursementManagement();
	
	public static void postNewUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			if(req.getMethod().equals("POST")) {
				System.out.println("inside postnewuser");
				String username = req.getParameter("username");
				System.out.println(username);
				System.out.println(req.getAttribute("username"));
				Users u = new ObjectMapper().readValue(req.getReader(), com.rev.pojo.Users.class);
				System.out.println(u);
				rService.newEmp(u.getUsername(),u.getPass());

			} else {
				resp.setStatus(400);
			}
			
		}
	
	public static void postSignin(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			if(req.getMethod().equals("POST")) {
				System.out.println("inside sign in post page");
				
			    String uname = req.getParameter("username");
			    String upass = req.getParameter("password");
			    System.out.println(uname +" " +upass);
			    
				Users u = new Users();
				u = rService.signIn(uname,upass);
				if(u != null) {
					HttpSession session = req.getSession();
					if (u.getUserStatus() == 1) {
						System.out.println("inside first user validation");
						System.out.println("User id valid");
						session.setAttribute("EmpAccess", true);
						session.setAttribute("user", u);
						resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank/empLanding");
						
					}else if (u != null && (u.getUserStatus() == 2)){
						session.setAttribute("ManagerAccess", true);
						session.setAttribute("user", u);
						resp.setStatus(200);
					}else{
						resp.setStatus(403);
					}
				}else {
					resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank/login");
				}

			} else {
				resp.setStatus(405);
			}
			
		}
	
	public static void getUserTicket(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
			if(req.getMethod().equals("GET")) {
				System.out.println("inside sign in user ticket page");
				resp.setContentType("application/json");
				
				HttpSession session = req.getSession(true);
				Users u = (Users) session.getAttribute("user");
			    int uId = u.getUserId();
			    System.out.println(uId +" <- user id");

				List<Tickets> listTicket = rService.getTickeByUserId(u.getUserId());
				session.setAttribute("userList", listTicket);

//				resp.sendRedirect("http://localhost:8080/ReimbursementProject/bank/ticketLanding");
			    
				ObjectMapper om = new ObjectMapper();
				resp.getWriter().write(om.writeValueAsString(listTicket));
			    
			}
	}
	
	public static void getAllUser(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		if(req.getMethod().equals("GET")) {
			System.out.println("inside get all user page");
			resp.setContentType("application/json");
			
			List<Users> uAll = rService.getAllUser();
			System.out.println(uAll);
			
			ObjectMapper om = new ObjectMapper();
			resp.getWriter().write(om.writeValueAsString(uAll));
		}
			
		
	}
	
	
				
		
}

