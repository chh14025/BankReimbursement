package com.rev.pojo;

public class Users {
	

	private int userId;
	private String username;
	private String pass;
	private int userStatus;
	private String firstName;
	private String lastName;
	private String email;
	
	public Users() {
		super();
	}
	public Users(int userId, String username, String pass, int userStatus, String firstName, String lastName,
			String email) {
		super();
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userStatus = userStatus;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public int getUserStatus() {
		return userStatus;
	}
	public void setUserStatus(int userStatus) {
		this.userStatus = userStatus;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", pass=" + pass + ", userStatus=" + userStatus
				+ ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
	
	
	

}
