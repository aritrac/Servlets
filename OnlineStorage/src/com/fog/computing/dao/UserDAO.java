package com.fog.computing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import com.fog.computing.helper.PasswordHelper;
import com.fog.computing.pojo.User;

public class UserDAO {
	// CRUD on User Table
	private String find_user = "select * from user_table where user_name = ? and pword = ?";
	private String get_last_user_id = "select user_id from user_table order by user_id desc";
	private String create_new_user = "insert into user_table(user_id,unique_code,creation_date,email_id,end_hh,mobile_no,pword,security_answer,security_answer2,security_answer3,security_answer4,security_answer5,security_question,security_question2,security_question3,security_question4,security_question5,start_hh,user_name,user_type,state,city,zipcode) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private String get_registered_users = "select * from user_table where user_type=?";
	private String get_user_by_userid = "select * from user_table where user_id = ?";
	private String validate_unique_code = "select * from user_table where user_id = ? and unique_code = ?";
	private String update_password = "update user_table set pword = ? where user_id = ?";
	private String is_email_existing = "select email_id from user_table where email_id = ?";
	private String is_mobile_number_existing = "select mobile_no from user_table where mobile_no = ?";
	private Connection conn = null;
	private ServletContext context;

	public UserDAO(ServletContext context) {
		this.context = context;
	}

	public String createUser(User user) {
		user.setUserId(getNextUserId()); // GETTING THE NEXT USER ID FOR THE
											// USER_ID ATTRTIBUTE IN THE
											// USER_TABLE
		user.setUniqueCode(generateUniqueCode(user));

		connect(context);
		try {
			PreparedStatement pStmt = conn.prepareStatement(create_new_user);

			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, user.getUniqueCode());
			pStmt.setDate(3, user.getCreationDate());
			pStmt.setString(4, user.getEmailId());
			pStmt.setInt(5, user.getEndHH());
			pStmt.setString(6, user.getMobileNo());
			pStmt.setString(7, new PasswordHelper().encrypt(user.getPassword()));
			pStmt.setString(8, user.getSecurityAnswer());
			pStmt.setString(9, user.getSecurityAnswer2());
			pStmt.setString(10, user.getSecurityAnswer3());
			pStmt.setString(11, user.getSecurityAnswer4());
			pStmt.setString(12, user.getSecurityAnswer5());
			pStmt.setString(13, user.getSecurityQuestion());
			pStmt.setString(14, user.getSecurityQuestion2());
			pStmt.setString(15, user.getSecurityQuestion3());
			pStmt.setString(16, user.getSecurityQuestion4());
			pStmt.setString(17, user.getSecurityQuestion5());
			pStmt.setInt(18, user.getStartHH());
			pStmt.setString(19, user.getUserName());
			pStmt.setString(20, user.getUserType());
			pStmt.setString(21, user.getState());
			pStmt.setString(22, user.getCity());
			pStmt.setString(23, user.getZipCode());

			pStmt.executeUpdate();

			disconnect();
			return user.getUniqueCode();
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {

		}
		return null;
	}

	public User findUser(User user) {
		connect(context);
		try {
			PreparedStatement pStmt = conn.prepareStatement(find_user);

			pStmt.setString(1, user.getUserName());
			pStmt.setString(2, new PasswordHelper().encrypt(user.getPassword()));

			ResultSet rs = pStmt.executeQuery();
			if (rs.next()) {
				return populateUser(rs);
			} else {
				return null;
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public List<User> findUsers(List<User> users) {
		return null;
	}

	public int updateUser(User user) {
		return 0;
	}

	public int updateUsers(List<User> users) {
		return 0;
	}

	public int deleteUser(User user) {
		return 0;
	}

	public int deleteUsers(List<User> users) {
		return 0;
	}

	// Connection to DB initiated
	private void connect(ServletContext context) {
		String username = context.getInitParameter("dbuser");
		String password = context.getInitParameter("dbpassword");
		String dbURL = context.getInitParameter("dbURL");
		
		System.out.println("Context : " + context);
		System.out.println("dbuser : " + username);
		System.out.println("dbpassword : " + password);
		System.out.println("dbURL : " + dbURL);

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

	// Disconnection from DB initiated
	private void disconnect() {
		try {
			conn.close();
		} catch (SQLException ex) {
			System.out
					.println("Something went wrong while closing the connection :: UserHelper.disconnect()");
			ex.printStackTrace();
		}
	}
	
	public User getUserByUserId(String userId){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(get_user_by_userid);
			
			pStmt.setString(1, userId);
			
			ResultSet rs = pStmt.executeQuery();
			User newUser = null;
			
			while(rs.next()){
				newUser = new User();
				newUser.setAddress(rs.getString("ADDRESS"));
				newUser.setCreationDate(rs.getDate("CREATION_DATE"));
				newUser.setEmailId(rs.getString("EMAIL_ID"));
				newUser.setEndHH(rs.getInt("END_HH"));
				newUser.setEndMM(rs.getInt("END_MM"));
				newUser.setEndTime(rs.getDate("END_TIME"));
				newUser.setMobileNo(rs.getString("MOBILE_NO"));
				newUser.setPassword(new PasswordHelper().decrypt(rs
						.getString("PWORD")));
				newUser.setSecurityAnswer(rs.getString("SECURITY_ANSWER"));
				newUser.setSecurityAnswer2(rs.getString("SECURITY_ANSWER2"));
				newUser.setSecurityAnswer3(rs.getString("SECURITY_ANSWER3"));
				newUser.setSecurityAnswer4(rs.getString("SECURITY_ANSWER4"));
				newUser.setSecurityAnswer5(rs.getString("SECURITY_ANSWER5"));
				newUser.setSecurityQuestion(rs.getString("SECURITY_QUESTION"));
				newUser.setSecurityQuestion2(rs.getString("SECURITY_QUESTION2"));
				newUser.setSecurityQuestion3(rs.getString("SECURITY_QUESTION3"));
				newUser.setSecurityQuestion4(rs.getString("SECURITY_QUESTION4"));
				newUser.setSecurityQuestion5(rs.getString("SECURITY_QUESTION5"));
				newUser.setStartHH(rs.getInt("START_HH"));
				newUser.setStartMM(rs.getInt("START_MM"));
				newUser.setStartTime(rs.getDate("START_TIME"));
				newUser.setUniqueCode(rs.getString("UNIQUE_CODE"));
				newUser.setUserId(rs.getString("USER_ID"));
				newUser.setUserName(rs.getString("USER_NAME"));
				newUser.setUserType(rs.getString("USER_TYPE"));
				newUser.setState(rs.getString("STATE"));
				newUser.setCity(rs.getString("CITY"));
				newUser.setZipCode(rs.getString("ZIPCODE"));
			}
			
			disconnect();
			return newUser;
		}catch(SQLException ex){
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
		return null;
	}

	public List<User> getRegisteredUsers() {
		connect(context);
		ArrayList<User> userList = new ArrayList<User>();
		try {
			PreparedStatement pStmt = conn
					.prepareStatement(get_registered_users);
			pStmt.setString(1, "REGISTERED");

			ResultSet rs = pStmt.executeQuery();

			while (rs.next()) {
				User newUser = new User();
				newUser.setAddress(rs.getString("ADDRESS"));
				newUser.setCreationDate(rs.getDate("CREATION_DATE"));
				newUser.setEmailId(rs.getString("EMAIL_ID"));
				newUser.setEndHH(rs.getInt("END_HH"));
				newUser.setEndMM(rs.getInt("END_MM"));
				newUser.setEndTime(rs.getDate("END_TIME"));
				newUser.setMobileNo(rs.getString("MOBILE_NO"));
				newUser.setPassword(new PasswordHelper().decrypt(rs
						.getString("PWORD")));
				newUser.setSecurityAnswer(rs.getString("SECURITY_ANSWER"));
				newUser.setSecurityAnswer2(rs.getString("SECURITY_ANSWER2"));
				newUser.setSecurityAnswer3(rs.getString("SECURITY_ANSWER3"));
				newUser.setSecurityAnswer4(rs.getString("SECURITY_ANSWER4"));
				newUser.setSecurityAnswer5(rs.getString("SECURITY_ANSWER5"));
				newUser.setSecurityQuestion(rs.getString("SECURITY_QUESTION"));
				newUser.setSecurityQuestion2(rs.getString("SECURITY_QUESTION2"));
				newUser.setSecurityQuestion3(rs.getString("SECURITY_QUESTION3"));
				newUser.setSecurityQuestion4(rs.getString("SECURITY_QUESTION4"));
				newUser.setSecurityQuestion5(rs.getString("SECURITY_QUESTION5"));
				newUser.setStartHH(rs.getInt("START_HH"));
				newUser.setStartMM(rs.getInt("START_MM"));
				newUser.setStartTime(rs.getDate("START_TIME"));
				newUser.setUniqueCode(rs.getString("UNIQUE_CODE"));
				newUser.setUserId(rs.getString("USER_ID"));
				newUser.setUserName(rs.getString("USER_NAME"));
				newUser.setUserType(rs.getString("USER_TYPE"));
				newUser.setState(rs.getString("STATE"));
				newUser.setCity(rs.getString("CITY"));
				newUser.setZipCode(rs.getString("ZIPCODE"));
				
				userList.add(newUser);
			}
			
			disconnect();
			return userList;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private User populateUser(ResultSet rs) {
		User newUser = new User();
		try {
			newUser.setAddress(rs.getString("ADDRESS"));
			newUser.setCreationDate(rs.getDate("CREATION_DATE"));
			newUser.setEmailId(rs.getString("EMAIL_ID"));
			newUser.setEndHH(rs.getInt("END_HH"));
			newUser.setEndMM(rs.getInt("END_MM"));
			newUser.setEndTime(rs.getDate("END_TIME"));
			newUser.setMobileNo(rs.getString("MOBILE_NO"));
			newUser.setPassword(new PasswordHelper().decrypt(rs
					.getString("PWORD")));
			newUser.setSecurityAnswer(rs.getString("SECURITY_ANSWER"));
			newUser.setSecurityAnswer2(rs.getString("SECURITY_ANSWER2"));
			newUser.setSecurityAnswer3(rs.getString("SECURITY_ANSWER3"));
			newUser.setSecurityAnswer4(rs.getString("SECURITY_ANSWER4"));
			newUser.setSecurityAnswer5(rs.getString("SECURITY_ANSWER5"));
			newUser.setSecurityQuestion(rs.getString("SECURITY_QUESTION"));
			newUser.setSecurityQuestion2(rs.getString("SECURITY_QUESTION2"));
			newUser.setSecurityQuestion3(rs.getString("SECURITY_QUESTION3"));
			newUser.setSecurityQuestion4(rs.getString("SECURITY_QUESTION4"));
			newUser.setSecurityQuestion5(rs.getString("SECURITY_QUESTION5"));
			newUser.setStartHH(rs.getInt("START_HH"));
			newUser.setStartMM(rs.getInt("START_MM"));
			newUser.setStartTime(rs.getDate("START_TIME"));
			newUser.setUniqueCode(rs.getString("UNIQUE_CODE"));
			newUser.setUserId(rs.getString("USER_ID"));
			newUser.setUserName(rs.getString("USER_NAME"));
			newUser.setUserType(rs.getString("USER_TYPE"));
			newUser.setState(rs.getString("STATE"));
			newUser.setCity(rs.getString("CITY"));
			newUser.setZipCode(rs.getString("ZIPCODE"));
			
			disconnect();

			return newUser;
		} catch (SQLException ex) {
			ex.printStackTrace();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	private String generateUniqueCode(User user) {
		long sum = 0;
		String fullString = "";
		fullString += user.getSecurityAnswer();
		fullString += user.getSecurityAnswer2();
		fullString += user.getSecurityAnswer3();
		fullString += user.getSecurityAnswer4();
		fullString += user.getSecurityAnswer5();

		for (int i = 0; i < fullString.length(); i++) {
			sum += fullString.charAt(0);
		}

		String sumToString = Long.valueOf(sum).toString();
		int digitsToAdd = 10 - sumToString.length();
		if (digitsToAdd > 0) {
			for (int i = 0; i < digitsToAdd; i++) {
				sumToString += Integer.valueOf((int) (Math.random() * 10))
						.toString();
			}
		}
		return sumToString;
	}

	private String getNextUserId() {
		connect(context);
		String userId = null;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(get_last_user_id);
			if (rs.next()) {
				userId = rs.getString(1);
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		int user_id = Integer
				.parseInt(userId.substring(userId.indexOf("U") + 1));
		user_id++;
		disconnect();
		return "U" + String.format("%04d", user_id);
	}
	
	public boolean validateUniqueCode(String unique_code, User user){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(validate_unique_code);
			pStmt.setString(1, user.getUserId());
			pStmt.setString(2, unique_code);
			
			ResultSet rs = pStmt.executeQuery();
			boolean hasRecord = rs.next();
			disconnect();
			
			return hasRecord;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public void updatePassword(String password, User user){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(update_password);
			pStmt.setString(1,  new PasswordHelper().encrypt(password));
			pStmt.setString(2, user.getUserId());
			pStmt.executeUpdate();
			disconnect();
		}catch(SQLException ex){
			ex.printStackTrace();
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
	public boolean isEmailExisting(String emailId){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(is_email_existing);
			pStmt.setString(1, emailId);
			
			ResultSet rs = pStmt.executeQuery();
			boolean hasRecord = rs.next();
			disconnect();
			return hasRecord;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
	
	public boolean isMobileNumberExisting(String mobileNumber){
		connect(context);
		try{
			PreparedStatement pStmt = conn.prepareStatement(is_mobile_number_existing);
			pStmt.setString(1, mobileNumber);
			
			ResultSet rs = pStmt.executeQuery();
			boolean hasRecord = rs.next();
			disconnect();
			return hasRecord;
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return false;
	}
}
