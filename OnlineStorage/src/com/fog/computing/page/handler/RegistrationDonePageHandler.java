package com.fog.computing.page.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationDonePageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public RegistrationDonePageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
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

		if (actionId.equalsIgnoreCase("doShowLogin")) {
			doShowLogin();
		}
	}

	// ACTION ID -> doShowLogin
	public void doShowLogin() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		lpHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/registration_done.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
