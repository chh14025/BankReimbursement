package com.rev.pojo;

public class Users {
	

	private int userId;
	private String username;
	private String pass;
	private int userStatus;
	
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(int userId, String username, String pass, int userStatus) {
		super();
		this.userId = userId;
		this.username = username;
		this.pass = pass;
		this.userStatus = userStatus;
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

	@Override
	public String toString() {
		return "Users [userId=" + userId + ", username=" + username + ", pass=" + pass + ", userStatus=" + userStatus
				+ "]";
	}
	
	

}
