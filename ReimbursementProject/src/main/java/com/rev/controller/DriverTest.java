package com.rev.controller;

import java.sql.Timestamp;
import java.util.Date;

import com.rev.dao.ReimbursementDao;
import com.rev.dao.ReimbursementDaoImpl;
import com.rev.pojo.Tickets;
import com.rev.service.ReimbursementManagement;

public class DriverTest {

	public static void main(String[] args) {
		ReimbursementManagement rService = new ReimbursementManagement();
		ReimbursementDaoImpl rDao = new ReimbursementDaoImpl();
//		Tickets t= new Tickets(1, 1, 1, "desc", 1, 1);
		
		
//		rDao.createNewTicket(t);
		
//		System.out.println(rDao.getAllTickets());
//		System.out.println(rService.updateTicket(2, 5));
//		System.out.println(rDao.getTicketByTicketId(1));
//		System.out.println(rDao.ticketApproval(1, 5));
//		System.out.println(rDao.signIn("newuser", "123"));
//		System.out.println(rService.getTickeByUserId(8));
		System.out.println(rService.getAllUser());
	}

}