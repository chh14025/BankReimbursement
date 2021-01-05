package com.rev.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.rev.pojo.Tickets;
import com.rev.pojo.Users;
import com.rev.util.ConnectionCenter;

public class ReimbursementDaoImpl implements ReimbursementDao{
	
	public void createNewUser(Users u) {
		System.out.println("Creating new user");
		
		try(Connection conn = ConnectionCenter.getConnection();){
			System.out.println("Connection");
			System.out.println(conn);
			
	
			String sql = "insert into users(Username, Pass, Status) "
					+ "values(?,?,?);";
			PreparedStatement ps = conn.prepareStatement(sql);
			
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPass());
			ps.setInt(3, u.getUserStatus());
	
	
			ps.execute();
	
		} catch (SQLException e) {
			e.printStackTrace();
		
		}
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	
	public void createNewTicket(Tickets t) {
		try(Connection conn = ConnectionCenter.getConnection()){
			System.out.println(conn);
			String sql = "insert into tickets(TicketStatus, TicketType,Description,EmployeeId) values(?,?,?,?);";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, t.getTicketStatus());
			ps.setInt(2, t.getTicketType());
			ps.setString(3, t.getDescription());
			ps.setInt(4, t.getEmployeeId());
			
			ps.execute();

			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	public List<Tickets> getAllTickets() {
		List<Tickets> tickets = new ArrayList<>();
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "select * from tickets;";
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(sql); //We are executing our SQL statement
			
			while(rs.next()) {
				Tickets t = new Tickets();
				t.setTicketNumber(rs.getInt(1));
				t.setTicketStatus(rs.getInt(2));
				t.setTicketType(rs.getInt(3));
				t.setDescription(rs.getString(4));
				t.setSubmitTime(rs.getString(5));
				t.setEmployeeId(rs.getInt(6));
				tickets.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	/*--------------------------------------------------------------------------------------------------------------------*/
	public List<Tickets> getTicketByStatus(int ticketStatus){
		List<Tickets> tickets = new ArrayList<>();
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "select * from tickets where ticketStatus = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketStatus);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				Tickets t = new Tickets();
				t.setTicketNumber(rs.getInt(1));
				t.setTicketStatus(rs.getInt(2));
				t.setTicketType(rs.getInt(3));
				t.setDescription(rs.getString(4));
				t.setSubmitTime(rs.getString(5));
				t.setEmployeeId(rs.getInt(6));
				tickets.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Tickets> getTicketByType(int ticketType) {
		List<Tickets> tickets = new ArrayList<>();
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "select * from tickets where TicketType = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketType);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				Tickets t = new Tickets();
				t.setTicketNumber(rs.getInt(1));
				t.setTicketStatus(rs.getInt(2));
				t.setTicketType(rs.getInt(3));
				t.setDescription(rs.getString(4));
				t.setSubmitTime(rs.getString(5));
				t.setEmployeeId(rs.getInt(6));
				tickets.add(t);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tickets;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Tickets> getTicketsByUser(int userId) {
		Tickets tickets = null;
		List<Tickets> t = new ArrayList<>();
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "select * from tickets where EmployeeId = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, userId);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				tickets = new Tickets();
				tickets.setTicketNumber(rs.getInt(1));
				tickets.setTicketStatus(rs.getInt(2));
				tickets.setTicketType(rs.getInt(3));
				tickets.setDescription(rs.getString(4));
				tickets.setSubmitTime(rs.getString(5));
				tickets.setEmployeeId(rs.getInt(6));
				t.add(tickets);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Tickets getTicketByTicketId(int ticketId) {
		Tickets tickets = null;
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "select * from tickets where ticketnumber = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketId);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				tickets = new Tickets();
				tickets.setTicketNumber(rs.getInt(1));
				tickets.setTicketStatus(rs.getInt(2));
				tickets.setTicketType(rs.getInt(3));
				tickets.setDescription(rs.getString(4));
				tickets.setSubmitTime(rs.getString(5));
				tickets.setEmployeeId(rs.getInt(6));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return tickets;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Users signIn(String username, String pass) {
		Users user = null;

		try(Connection conn = ConnectionCenter.getConnection()){

			
			String sql = "select * from users where username = ? AND pass = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setUserStatus(rs.getInt(4));
			}
			return user;
			
		}catch(SQLException e) {
			user = null;
			e.printStackTrace();
		}
		
		return user;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Users> getAllEmployee() {
		List<Users> users = new ArrayList<>();

		
		try(Connection conn = ConnectionCenter.getConnection()){

			
			String sql = "select * from users where status = 1;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setUserStatus(rs.getInt(4));
				users.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Users> getAllManager() {
	List<Users> users = new ArrayList<>();
	
		try(Connection conn = ConnectionCenter.getConnection()){

			
			String sql = "select * from users where status = 2;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				Users user = new Users();
				user.setUsername(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setUserStatus(rs.getInt(3));
				users.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public List<Users> getAllUsers() {
	List<Users> users = new ArrayList<>();
	
		try(Connection conn = ConnectionCenter.getConnection()){

			
			String sql = "select * from users;";
			PreparedStatement ps = conn.prepareStatement(sql);

			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				Users user = new Users();
				user.setUserId(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setPass(rs.getString(3));
				user.setUserStatus(rs.getInt(4));
				users.add(user);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	}
	/*--------------------------------------------------------------------------------------------------------------------*/

	
	public Users getUserByUsername(String username) {
		
		Users user = null;

		try(Connection conn = ConnectionCenter.getConnection()){

			
			String sql = "select * from users where username = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, username);

			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				user = new Users();
				user.setUsername(rs.getString(1));
				user.setPass(rs.getString(2));
				user.setUserStatus(rs.getInt(3));
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;		
	}

	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Tickets ticketApproval(int approval, int ticketnum) {
		Tickets t;


		try(Connection conn = ConnectionCenter.getConnection()){

			String sql = "update tickets set ticketstatus = ? where ticketnumber = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, approval);
			ps.setInt(2, ticketnum);
			
			int rs = ps.executeUpdate(); //We are executing our SQL statement
			
			t = getTicketByTicketId(ticketnum);

		} catch (SQLException e) {
			t = null;
		}
		return t;
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public Tickets addTicketDescription(String message, int ticketnum) {
		Tickets t = null;
		
		try(Connection conn = ConnectionCenter.getConnection()){
			
			String sql = "update tickets set description = ? where ticketnumber = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, message);
			ps.setInt(2, ticketnum);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
			while(rs.next()) {
				t = new Tickets();
				t.setTicketNumber(rs.getInt(1));
				t.setTicketStatus(rs.getInt(2));
				t.setTicketType(rs.getInt(3));
				t.setDescription(rs.getString(4));
				t.setSubmitTime(rs.getString(5));
				t.setEmployeeId(rs.getInt(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return t;
		
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

	@Override
	public void removeTicket(int ticketNumber) {
		try(Connection conn = ConnectionCenter.getConnection()){
			String sql = "DELETE FROM tickets WHERE ticketnumber = ?;";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, ticketNumber);
			
			ResultSet rs = ps.executeQuery(); //We are executing our SQL statement
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/*--------------------------------------------------------------------------------------------------------------------*/

//	@Override
//	public boolean removeUser(int UserId) {
//		// TODO Auto-generated method stub
//		return false;
//	}

	

}