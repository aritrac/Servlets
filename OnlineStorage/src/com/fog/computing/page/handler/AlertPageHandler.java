package com.fog.computing.page.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AlertPageHandler {
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
	public AlertPageHandler(HttpServletRequest request,
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

		if (actionId.equalsIgnoreCase("doFileUpload")) {
			doFileUpload();
		}

		if (actionId.equalsIgnoreCase("doChangePassword")) {
			doChangePassword();
		}

		if (actionId.equalsIgnoreCase("doSignout")) {
			doSignout();
		}

		if (actionId.equalsIgnoreCase("doShowAboutUs")) {
			doShowAboutUs();
		}

		if (actionId.equalsIgnoreCase("doShowContactUs")) {
			doShowContactUs();
		}
	}

	// ACTION ID -> doFileUpload
	public void doFileUpload() throws IOException {
		FileDetailsPageHandler fdpHandler = new FileDetailsPageHandler(request,
				response);
		fdpHandler.show();
	}

	// ACTION ID -> doChangePassword
	public void doChangePassword() throws IOException {
		ChangePasswordPageHandler cppHandler = new ChangePasswordPageHandler(
				request, response);
		cppHandler.show();
	}

	// ACTION ID -> doSignout
	public void doSignout() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		request.getSession().invalidate();
		lpHandler.show();
	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "userhomepage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "userhomepage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/alert_page.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
