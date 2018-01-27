package com.fog.computing.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletContext;

import com.fog.computing.pojo.Question;

public class QuestionsDAO {
	// CRUD on File table
	private Connection conn = null;
	private ServletContext context = null;
	private String get_all_questions = "select * from questions_table";
	private String update_all_questions = "update questions_table set security_question = ? where question_id = ?";

	public QuestionsDAO(ServletContext context) {
		this.context = context;
	}
	
	public List<Question> getQuestions(){
		connect(context);
		List<Question> list = new ArrayList<Question>();
		try{
			PreparedStatement pStmt = conn.prepareStatement(get_all_questions);
			ResultSet rs = pStmt.executeQuery();
			
			while(rs.next()){
				Question question = new Question();
				question.setQuestionId(rs.getString("QUESTION_ID"));
				question.setSecurityQuestion(rs.getString("SECURITY_QUESTION"));
				list.add(question);
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
		return list;
	}
	
	public void updateQuestions(List<Question> questions){
		try{
			Iterator<Question> iter = questions.iterator();
			while(iter.hasNext()){
				Question question = iter.next();
				connect(context);
				PreparedStatement pStmt = conn.prepareStatement(update_all_questions);
				pStmt.setString(1, question.getSecurityQuestion());
				pStmt.setString(2, question.getQuestionId());
				pStmt.executeUpdate();
				disconnect();
			}
		}catch(SQLException ex){
			ex.printStackTrace();
		}
	}

	// Connection to DB initiated
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
}
