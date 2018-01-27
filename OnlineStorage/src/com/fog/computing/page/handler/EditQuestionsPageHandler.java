package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.QuestionsDAO;
import com.fog.computing.pojo.Question;

public class EditQuestionsPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String question1 = null;
	String question2 = null;
	String question3 = null;
	String question4 = null;
	String question5 = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public EditQuestionsPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		question1 = request.getParameter("question1");
		question2 = request.getParameter("question2");
		question3 = request.getParameter("question3");
		question4 = request.getParameter("question4");
		question5 = request.getParameter("question5");
		
	}

	// SET SESSION ATTRIBUTES FOR THE PAGE
	private void setSessionAttributes() {

	}

	// SET ERROR ATTRIBUTES FOR PAGE
	private void setErrorAttributes() {

	}

	// SET PAGE ATTRIBUTES
	private void setPageAttributes() {

	}

	// CONTROLS THE LOGIC FOR THE RESOURCE
	public void handle() throws IOException {
		initParams();
		
		System.out.println(actionId);

		if (actionId.equalsIgnoreCase("doUpdateQuestions")) {
			doUpdateQuestions();
		}

		if (actionId.equalsIgnoreCase("doBack")) {
			doBack();
		}
	}

	// ACTION ID -> doUpdateQuestions
	public void doUpdateQuestions() throws IOException {
		List<Question> questions = new ArrayList<Question>();
		Question q1 = new Question();
		Question q2 = new Question();
		Question q3 = new Question();
		Question q4 = new Question();
		Question q5 = new Question();
		q1.setSecurityQuestion(question1);
		q1.setQuestionId("Q01");
		questions.add(q1);
		q2.setSecurityQuestion(question2);
		q2.setQuestionId("Q02");
		questions.add(q2);
		q3.setSecurityQuestion(question3);
		q3.setQuestionId("Q03");
		questions.add(q3);
		q4.setSecurityQuestion(question4);
		q4.setQuestionId("Q04");
		questions.add(q4);
		q5.setSecurityQuestion(question5);
		q5.setQuestionId("Q05");
		questions.add(q5);
		
		QuestionsDAO qDao = new QuestionsDAO(request.getServletContext());
		qDao.updateQuestions(questions);
		
		AdminHomePageHandler ahpHandler = new AdminHomePageHandler(request, response);
		ahpHandler.show();
	}

	// ACTION ID -> doBack
	public void doBack() throws IOException {
		String page = (String)request.getSession().getAttribute("page");
		
		if (page.equalsIgnoreCase("adminfilespage")) {
			AdminFilesPageHandler afpHanlder = new AdminFilesPageHandler(
					request, response);
			afpHanlder.show();
		}
		if(page.equalsIgnoreCase("adminhomepage")){
			AdminHomePageHandler afpHanlder = new AdminHomePageHandler(request, response);
			afpHanlder.show();
		}
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/edit_questions.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
