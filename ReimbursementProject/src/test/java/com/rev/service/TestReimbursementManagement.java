package com.rev.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.rev.dao.ReimbursementDao;
import com.rev.dao.ReimbursementDaoImpl;
import com.rev.pojo.Tickets;
import com.rev.pojo.Users;

public class TestReimbursementManagement {
	
	
	private static ReimbursementManagement rm = null;
	private static ReimbursementDao rDao = mock(ReimbursementDaoImpl.class);
	
	@Before
	public void setUp() {
		rm = new ReimbursementManagement(rDao);
	}
	
	@Test
	public void testGetUsers() {
		Users u = new Users(1, "exist", "pass",1, "first", "last", "email");

		when(rDao.getUserByUsername("exist")).thenReturn(u);
		assertEquals(u , rm.getUsers("exist"));
	}
	
	@Test
	public void testGetTickeByUserId() {
		Tickets t= new Tickets(1, 1, 1, "fromjavaagain", "time", 1,2);
		List<Tickets> tList = new ArrayList<>();
		tList.add(t);
		when(rDao.getTicketsByUser(1)).thenReturn(tList);
		when(rDao.getTicketsByUser(2)).thenReturn(null);
		assertEquals(tList , rm.getTickeByUserId(1));
		assertEquals(null , rm.getTickeByUserId(2));
	}
	
	@Test
	public void testUpdateTicket() {
		Tickets t= new Tickets(1, 1, 1, "fromjavaagain", "time", 1,2);
		when(rDao.ticketApproval(1,1)).thenReturn(t);
		when(rDao.ticketApproval(1,4)).thenReturn(null);

		assertTrue(rm.updateTicket(1,1));
		assertFalse(rm.updateTicket(1,4));
	}
	
	
	@Test
	public void testNewEmp() {
		Users u = new Users(1, "exist", "pass",1, "first", "last", "email");

	    ArgumentCaptor<Users> valueCapture = ArgumentCaptor.forClass(Users.class);

		doNothing().when(rDao).createNewUser(valueCapture.capture());
		rDao.createNewUser(u);
		
		assertEquals(u , valueCapture.getValue());

	}
	
	@Test
	public void testSignin() {
		Users u = new Users(1, "exist", "pass",1, "first", "last", "email");

		when(rDao.signIn("exist","pass")).thenReturn(u);
		
		assertEquals(u, rm.signIn("exist", "pass"));
		assertEquals(null, rm.signIn("doesNotExist", "pass"));

	}
	
	@Test
	public void testNewTicket() {
		
		Tickets t= new Tickets(1, 1, 1, "fromjavaagain", "time", 1,2);
	    ArgumentCaptor<Tickets> valueCapture = ArgumentCaptor.forClass(Tickets.class);

		doNothing().when(rDao).createNewTicket(valueCapture.capture());
		rDao.createNewTicket(t);
		
		assertEquals(t , valueCapture.getValue());

	}
	
	
	

	
	
	
	
	
	
	
	

}
