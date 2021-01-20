package com.rev.service;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.rev.dao.ReimbursementDao;
import com.rev.dao.ReimbursementDaoImpl;
import com.rev.pojo.Tickets;
import com.rev.pojo.Users;

public class ReimbursementManagement {
	private static Logger loggy = Logger.getLogger(MethodHandles.lookup().lookupClass().getSimpleName());

	
	public ReimbursementDao rDao = new ReimbursementDaoImpl();
	
	public ReimbursementManagement() {};
	
	public ReimbursementManagement(ReimbursementDao rDao) {
		this.rDao = rDao;
	}

	
	public List<Tickets> getTickeByUserId(int userId) {
		List<Tickets> t = rDao.getTicketsByUser(userId);
		return t;
	}
	
	public void newEmp(String username, String pass, int stat, String first, String last, String email) {
		loggy.info("create new employee");

			Users u = new Users();
			u.setUserId(0);
			u.setUsername(username);
			u.setPass(pass);
			u.setUserStatus(stat);
			u.setFirstName(first);
			u.setLastName(last);
			u.setEmail(email);
			
			
			rDao.createNewUser(u);
	}
	
	protected Users getUsers(String username) {
		loggy.info("create new users");
		Users u = rDao.getUserByUsername(username);
		Users validate;
		if (u == null) {
			validate = null;
		}else {
			validate = u;
		}
		return validate;
	}
	
	
	
	public List<Users> getAllEmp(){
		List<Users> u = rDao.getAllEmployee();
		return u;
	}
	
	public List<Tickets> getAllTickets(){
		List<Tickets> t = rDao.getAllTickets();
		return t;
	}
	
	public void newTicket(int ticketType, String description, int employeeId, double amount) {
		System.out.println("create new ticket");
		Tickets t= new Tickets();
		t.setTicketStatus(1);
		t.setTicketType(ticketType);
		t.setDescription(description);
		t.setEmployeeId(employeeId);
		t.setAmount(amount);
		rDao.createNewTicket(t);
	}
	
	public boolean updateTicket(int approval, int ticketnum) {
		boolean bool = false;
		Tickets t;
		t = rDao.ticketApproval(approval, ticketnum);
		
		if (t != null) {
			loggy.info("updated correctly");
			bool = true;
		}else {
			loggy.warn("didn't update correctly");
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
		List<Users> u;
		u = rDao.getAllUsers();
		return u;
	}
	
	

}
