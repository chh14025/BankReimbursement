package com.rev.dao;

import java.util.List;

import com.rev.pojo.Tickets;
import com.rev.pojo.Users;

public interface ReimbursementDao {
	
	//CRUD
	
	//CREATE
	public void createNewUser(Users u);
	public void createNewTicket(Tickets t);
	
	
	//READ
	public List<Tickets> getAllTickets();
	public List<Tickets> getTicketByStatus(int ticketStatus);
	public List<Tickets> getTicketByType(int ticketType);
	public List<Tickets> getTicketsByUser(int userId);
	public Tickets getTicketByTicketId(int ticketId);
	
	public List<Users> getAllUsers();
	public Users getUserByUsername(String username);
	public Users signIn(String username, String pass);
	public List<Users> getAllEmployee();
	public List<Users> getAllManager();
	
	
	//UPDATE
	public Tickets ticketApproval(int approval, int ticketnum);
	public Tickets addTicketDescription(String message, int ticketnum);
	
	
	
	//DELETE
	public void removeTicket(int ticketNumber);
//	public boolean removeUser(int UserId);

}
