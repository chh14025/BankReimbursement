package com.rev.service;

import java.util.ArrayList;
import java.util.List;

import com.rev.dao.ReimbursementDao;
import com.rev.dao.ReimbursementDaoImpl;
import com.rev.pojo.Tickets;
import com.rev.pojo.Users;

public class ReimbursementManagement {
	
	private ReimbursementDao rDao = new ReimbursementDaoImpl();

	
	public List<Tickets> getTickeByUserId(int userId) {
		List<Tickets> t = rDao.getTicketsByUser(userId);
		return t;
	}
	
	public boolean newEmp(String username, String pass, int stat, String first, String last, String email) {
		System.out.println("create new employee");

			Users u = new Users();
			u.setUserId(0);
			u.setUsername(username);
			u.setPass(pass);
			u.setUserStatus(stat);
			u.setFirstName(first);
			u.setLastName(last);
			u.setEmail(email);
			
			
			rDao.createNewUser(u);
			boolean bool = true;
		return bool;
	}
	
	public Users getUsers(String username) {
		Users u = rDao.getUserByUsername(username);
		return u;
	}
	
	public List<Users> getAllEmp(){
		List<Users> u = rDao.getAllEmployee();
		return u;
	}
	
	public List<Tickets> getAllTickets(){
		List<Tickets> t = rDao.getAllTickets();
		return t;
	}
	
	public boolean newTicket(int ticketType, String description, int employeeId, double amount) {
		System.out.println("create new ticket");
		Tickets t= new Tickets();
		t.setTicketStatus(1);
		t.setTicketType(ticketType);
		t.setDescription(description);
		t.setEmployeeId(employeeId);
		t.setAmount(amount);
		rDao.createNewTicket(t);
		boolean bool = true;
		return bool;
	}
	
	public boolean updateTicket(int approval, int ticketnum) {
		boolean bool = false;
		Tickets t;
		t = rDao.ticketApproval(approval, ticketnum);
		
		if (t != null) {
			bool = true;
		}else {
			System.out.println("didn't update correctly");
		}
		return bool;
	}
	
	public Users signIn(String username, String password) {
		Users u;
		u = rDao.signIn(username, password);
		return u;
	}
	
	
	
	public boolean removeTicket(int ticNum) {
		boolean bool = false;
		removeTicket(ticNum);
		bool = true;
		return bool;
	}
	
	public List<Users> getAllUser(){
		List<Users> u = new ArrayList<>();
		u = rDao.getAllUsers();
		return u;
	}
	
	

}
