package com.fog.computing.helper;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;

import com.fog.computing.pojo.User;

public class UserHelper extends HttpServlet {
	private static final long serialVersionUID = -1587554750559654016L;
	private Connection conn = null;
	private boolean noUsers = false;
	public Connection getConn() {
		return conn;
	}

	public boolean isNoUsers() {
		return noUsers;
	}

	public String getInsert_user_record() {
		return insert_user_record;
	}

	public String getGet_last_user_id() {
		return get_last_user_id;
	}

	public String getIs_user_valid() {
		return is_user_valid;
	}

	public String getIs_combination_existing() {
		return is_combination_existing;
	}

	public String getGet_all_users() {
		return get_all_users;
	}

	private String insert_user_record = "insert into user_table(user_id,user_name,pword,email_id,mobile_no,address,start_hh,start_mm,end_hh,end_mm,security_question,security_answer,user_type,creation_date)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String get_last_user_id = "select user_id from user_table order by user_id desc";
	private String is_user_valid = "select user_id, user_name, user_type from user_table where user_name = ? and pword = ?";
	private String is_combination_existing = "select user_id from user_table where user_name = ? or email_id = ? or mobile_no = ?";
	private String get_all_users = "select * from user_table where user_type = ?";
	private String get_select_user = "select * from user_table where user_id = ?";
	private String update_user = "update user_table set start_hh = ?, start_mm = ?, end_hh = ?, end_mm = ?, security_question = ? , security_answer = ? where user_id = ?";

	private void connect(ServletContext context) {
		String username = context.getInitParameter("dbuser");
		String password = context.getInitParameter("dbpassword");
		String dbURL = context.getInitParameter("dbURL");

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@" + dbURL,
					username, password);

		} catch (Exception ex) {
			System.out
					.println("Something went wrong in the JDBC connect() method :: UserHelper.connect()");
			ex.printStackTrace();
		}
	}

	private void disconnect() {
		try {
			conn.close();
		} catch (SQLException ex) {
			System.out
					.println("Something went wrong while closing the connection :: UserHelper.disconnect()");
			ex.printStackTrace();
		}
	}

	public UserHelper(ServletContext context) {
		connect(context);
	}

	public boolean isUserRegistered(HttpServletRequest request) {
		try {
			PreparedStatement stmt = conn.prepareStatement(is_user_valid);
			stmt.setString(1, request.getParameter("username"));
			stmt.setString(2, new PasswordHelper().encrypt(request.getParameter("password")));
			ResultSet rs = stmt.executeQuery();
			boolean val = rs.next();
			if (val) {
				request.getSession().setAttribute("user_name", rs.getString("user_name"));
				request.getSession().setAttribute("user_id", rs.getString("user_id"));
				request.setAttribute("userType", rs.getString("user_type"));
				if(rs.getString("user_type").equalsIgnoreCase("Admin")){
					request.getSession().setAttribute("userList", getUsers());
				}
			}
			return val;
		} catch (SQLException ex) {
			System.out
					.println("Something went wrong while searching for an user in DB :: UserHelper.isUserRegistered()");
			ex.printStackTrace();
		}catch(Exception ex){
			System.out
			.println("Something went wrong while searching for an user in DB :: UserHelper.isUserRegistered()");
	ex.printStackTrace();
		}
		return false;
	}
	
	public boolean isCombinationExisting(HttpServletRequest request){
		try{
			PreparedStatement stmt = conn.prepareStatement(is_combination_existing);
			stmt.setString(1, request.getParameter("name"));
			stmt.setString(2, request.getParameter("mobile_no"));
			stmt.setString(3,  request.getParameter("email_id"));
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		}catch(SQLException ex){
			System.out.println("Something went wrong while searching for an user in DB :: UserHelper.isCombinationExisting()");
			ex.printStackTrace();
		}
		return false;
	}

	public boolean insertUser(HttpServletRequest request){
		String nextUserId = getNextUserId();
		java.util.Date dt1 = new java.util.Date();
		if (!isCombinationExisting(request)) {
			try {
				PreparedStatement insertUsr = conn
						.prepareStatement(insert_user_record);
				insertUsr.setString(1, nextUserId);
				insertUsr.setString(2, request.getParameter("name"));
				insertUsr.setString(3, new PasswordHelper().encrypt(request.getParameter("password")));
				insertUsr.setString(4, request.getParameter("email_id"));
				insertUsr.setString(5, request.getParameter("mobile_no"));
				insertUsr.setString(6, request.getParameter("address"));
				insertUsr.setString(7, request.getParameter("time_from_hh"));
				insertUsr.setString(8, request.getParameter("time_from_mm"));
				insertUsr.setString(9, request.getParameter("time_to_hh"));
				insertUsr.setString(10, request.getParameter("time_to_mm"));
				insertUsr.setString(11,
						request.getParameter("security_question"));
				insertUsr
						.setString(12, request.getParameter("security_answer"));
				insertUsr.setString(13, "REGISTERED");
				insertUsr.setDate(14, new Date(dt1.getTime()));
				insertUsr.executeUpdate();
				conn.commit();
				disconnect();
			} catch (SQLException ex) {
				System.out
						.println("Something went wrong while inserting an user in DB :: UserHelper.insertUser()");
				ex.printStackTrace();
			}catch(Exception ex){
				System.out.println("Something went wrong while inserting an user in DB :: UserHelper.insertUser()");
				ex.printStackTrace();
			}
		} else {
			return false;
		}
		return true;
	}
	
	public boolean updateUser(HttpServletRequest request){
		String userId = request.getParameter("userid");
		String startHH = request.getParameter("time_from_hh");
		String startMM = request.getParameter("time_from_mm");
		String endHH = request.getParameter("time_to_hh");
		String endMM = request.getParameter("time_to_mm");
		String securityQuestion = request.getParameter("security_question");
		String securityAnswer = request.getParameter("security_answer");
		
		try{
			PreparedStatement stmt = conn.prepareStatement(update_user);
			stmt.setString(1, startHH);
			stmt.setString(2, startMM);
			stmt.setString(3, endHH);
			stmt.setString(4, endMM);
			stmt.setString(5, securityQuestion);
			stmt.setString(6, securityAnswer);
			stmt.setString(7, userId);
			stmt.executeUpdate();
			conn.commit();
			disconnect();
		}catch(SQLException ex){
			System.out.println("Something went wrong while updating an user in DB :: UserHelper.updateUser()");
			ex.printStackTrace();
		}
		return false;
	}

	private String getNextUserId() {
		String userId = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(get_last_user_id);
			if (rs.next()) {
				userId = rs.getString(1);
			}
		} catch (SQLException ex) {
			System.out
					.println("Something went wrong in getting the next user id :: UserHelper.getNextUserId()");
			ex.printStackTrace();
		}

		int user_id = Integer
				.parseInt(userId.substring(userId.indexOf("U") + 1));
		user_id++;
		return "U" + String.format("%04d", user_id);
	}
	
	public List<User> getUsers(){
		try{
			PreparedStatement stmt = conn.prepareStatement(get_all_users);
			stmt.setString(1, "REGISTERED");
			ResultSet rs = stmt.executeQuery();
			List<User> userList = new ArrayList<User>();
			if(rs.next()){
				User tempUser = new User();
				tempUser.setAddress(rs.getString("address"));
				tempUser.setCreationDate(rs.getDate("creation_date"));
				tempUser.setEmailId(rs.getString("email_id"));
				tempUser.setEndHH(rs.getInt("end_hh"));
				tempUser.setEndMM(rs.getInt("end_mm"));
				tempUser.setEndTime(rs.getDate("end_time"));
				tempUser.setMobileNo(rs.getString("mobile_no"));
				tempUser.setPassword(rs.getString("pword"));
				tempUser.setSecurityAnswer(rs.getString("security_answer"));
				tempUser.setSecurityQuestion(rs.getString("security_question"));
				tempUser.setStartHH(rs.getInt("start_hh"));
				tempUser.setStartMM(rs.getInt("start_mm"));
				tempUser.setStartTime(rs.getDate("start_time"));
				tempUser.setUserId(rs.getString("user_id"));
				tempUser.setUserName(rs.getString("user_name"));
				tempUser.setUserType(rs.getString("user_type"));
				
				userList.add(tempUser);
				while(rs.next()){
					User tempUser2 = new User();
					tempUser2.setAddress(rs.getString("address"));
					tempUser2.setCreationDate(rs.getDate("creation_date"));
					tempUser2.setEmailId(rs.getString("email_id"));
					tempUser2.setEndHH(rs.getInt("end_hh"));
					tempUser2.setEndMM(rs.getInt("end_mm"));
					tempUser2.setEndTime(rs.getDate("end_time"));
					tempUser2.setMobileNo(rs.getString("mobile_no"));
					tempUser2.setPassword(rs.getString("pword"));
					tempUser2.setSecurityAnswer(rs.getString("security_answer"));
					tempUser2.setSecurityQuestion(rs.getString("security_question"));
					tempUser2.setStartHH(rs.getInt("start_hh"));
					tempUser2.setStartMM(rs.getInt("start_mm"));
					tempUser2.setStartTime(rs.getDate("start_time"));
					tempUser2.setUserId(rs.getString("user_id"));
					tempUser2.setUserName(rs.getString("user_name"));
					tempUser2.setUserType(rs.getString("user_type"));
					
					userList.add(tempUser2);
				}
				disconnect();
				return userList;
			}else{
				noUsers = true;
			}
		}catch(SQLException ex){
			System.out.println("Something went wrong in getting all the users from DB :: UserHelper.getUsers()");
		}
		return null;
	}
	
	public User getUser(String userId){
		try{
			PreparedStatement stmt = conn.prepareStatement(get_select_user);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				User tempUser = new User();
				tempUser.setAddress(rs.getString("address"));
				tempUser.setCreationDate(rs.getDate("creation_date"));
				tempUser.setEmailId(rs.getString("email_id"));
				tempUser.setEndHH(rs.getInt("end_hh"));
				tempUser.setEndMM(rs.getInt("end_mm"));
				tempUser.setEndTime(rs.getDate("end_time"));
				tempUser.setMobileNo(rs.getString("mobile_no"));
				tempUser.setPassword(rs.getString("pword"));
				tempUser.setSecurityAnswer(rs.getString("security_answer"));
				tempUser.setSecurityQuestion(rs.getString("security_question"));
				tempUser.setStartHH(rs.getInt("start_hh"));
				tempUser.setStartMM(rs.getInt("start_mm"));
				tempUser.setStartTime(rs.getDate("start_time"));
				tempUser.setUserId(rs.getString("user_id"));
				tempUser.setUserName(rs.getString("user_name"));
				tempUser.setUserType(rs.getString("user_type"));
				disconnect();
				return tempUser;
			}else{
				noUsers = true;
			}
		}catch(SQLException ex){
			System.out.println("Something went wrong in getting all the users from DB :: UserHelper.getUsers()");
		}
		return null;
	}
}
