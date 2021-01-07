package com.rev.pojo;

import java.sql.Timestamp;

public class Tickets {
	
	private int ticketNumber;
	private int ticketStatus;
	private int ticketType;
	private String description;
	private String submitTime;
	private int employeeId;
	private double amount;
	
	public Tickets() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tickets(int ticketNumber, int ticketStatus, int ticketType, String description, String submitTime,
			int employeeId, double amount) {
		super();
		this.ticketNumber = ticketNumber;
		this.ticketStatus = ticketStatus;
		this.ticketType = ticketType;
		this.description = description;
		this.submitTime = submitTime;
		this.employeeId = employeeId;
		this.amount = amount;
	}

	public int getTicketNumber() {
		return ticketNumber;
	}

	public void setTicketNumber(int ticketNumber) {
		this.ticketNumber = ticketNumber;
	}

	public int getTicketStatus() {
		return ticketStatus;
	}

	public void setTicketStatus(int ticketStatus) {
		this.ticketStatus = ticketStatus;
	}

	public int getTicketType() {
		return ticketType;
	}

	public void setTicketType(int ticketType) {
		this.ticketType = ticketType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSubmitTime() {
		return submitTime;
	}

	public void setSubmitTime(String submitTime) {
		this.submitTime = submitTime;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Tickets [ticketNumber=" + ticketNumber + ", ticketStatus=" + ticketStatus + ", ticketType=" + ticketType
				+ ", description=" + description + ", submitTime=" + submitTime + ", employeeId=" + employeeId
				+ ", amount=" + amount + "]";
	}
	

	


}
