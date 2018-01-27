package com.fog.computing.page.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.QuestionsDAO;
import com.fog.computing.dao.UserDAO;
import com.fog.computing.pojo.User;

public class LoginPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;
	private User foundUser;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String username = null; // Required for session detection, please add this
							// to the redirecting page
	String password = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES
	String credentialsInvalid = null;

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public LoginPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		username = request.getParameter("username");
		password = request.getParameter("password");
	}

	// SET SESSION ATTRIBUTES FOR THE PAGE
	private void setSessionAttributes() {
		request.getSession().setAttribute("username", username);
		request.getSession().setAttribute("user", foundUser);
	}

	// SET ERROR ATTRIBUTES FOR PAGE
	private void setErrorAttributes() {
		request.setAttribute("credentialsInvalid", credentialsInvalid);
	}

	// SET PAGE ATTRIBUTES
	private void setPageAttributes() {

	}

	// CONTROLS THE LOGIC FOR THE RESOURCE
	public void handle() throws IOException, ServletException {
		initParams();

		if (actionId.equalsIgnoreCase("doLogin")) {
			doLogin();
		}
		if (actionId.equalsIgnoreCase("doRegister")) {
			doRegister();
		}
		if (actionId.equalsIgnoreCase("doShowLogin")) {
			doShowLogin();
		}
		if (actionId.equalsIgnoreCase("doShowAboutUs")) {
			doShowAboutUs();
		}
		if (actionId.equalsIgnoreCase("doShowContactUs")) {
			doShowContactUs();
		}
	}

	// ACTION ID -> doLogin
	public void doLogin() throws IOException, ServletException {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);

		UserDAO userDAO = new UserDAO(request.getServletContext());

		foundUser = userDAO.findUser(user);

		if (foundUser != null) { // LOGIN SUCCESSFUL
			// DETERMINING WHETHER ADMIN OR NORMAL USER
			if (foundUser.getUserType().equalsIgnoreCase("ADMIN")) {
				setSessionAttributes();
				AdminHomePageHandler adminHomePageHandler = new AdminHomePageHandler(
						request, response);
				adminHomePageHandler.show();
			}
			if (foundUser.getUserType().equalsIgnoreCase("REGISTERED")) {
				setSessionAttributes();
				UserHomePageHandler userHomePageHandler = new UserHomePageHandler(
						request, response);
				userHomePageHandler.show();
			}
		} else {
			credentialsInvalid = "true";
			showError();
		}
	}

	// ACTION ID -> doRegister
	public void doRegister() throws IOException {
		RegistrationPageHandler registrationPageHandler = new RegistrationPageHandler(
				request, response);
		QuestionsDAO qDao = new QuestionsDAO(request.getServletContext());
		request.getSession().setAttribute("questions", qDao.getQuestions());
		registrationPageHandler.show();
	}

	// ACTION ID -> doShowLogin
	public void doShowLogin() throws IOException {
		show();
	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "loginpage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "loginpage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/login.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {
		// ON UNSUCCESSFUL LOGIN SHOW ERROR
		setErrorAttributes();
		request.getRequestDispatcher("JSPs/login.jsp").forward(request,
				response);
	}
}
