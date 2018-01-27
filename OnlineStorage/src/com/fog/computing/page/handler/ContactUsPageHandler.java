package com.fog.computing.page.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ContactUsPageHandler {
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
	public ContactUsPageHandler(HttpServletRequest request,
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

		if (actionId.equalsIgnoreCase("doShow")) {
			doShow();
		}
	}

	// ACTION ID -> doShow
	public void doShow() throws IOException {
		String page = (String) request.getSession().getAttribute("page");
		if (page.equalsIgnoreCase("adminfilespage")) {
			AdminFilesPageHandler afpHanlder = new AdminFilesPageHandler(
					request, response);
			afpHanlder.show();
		}
		if(page.equalsIgnoreCase("adminhomepage")){
			AdminHomePageHandler afpHanlder = new AdminHomePageHandler(request, response);
			afpHanlder.show();
		}
		if(page.equalsIgnoreCase("loginpage")){
			LoginPageHandler lpHanlder = new LoginPageHandler(request, response);
			lpHanlder.show();
		}
		if(page.equalsIgnoreCase("userhomepage")){
			UserHomePageHandler uhpHanlder = new UserHomePageHandler(request, response);
			uhpHanlder.show();
		}
		if(page.equalsIgnoreCase("filedetailspage")){
			FileDetailsPageHandler fdpHanlder = new FileDetailsPageHandler(request, response);
			fdpHanlder.show();
		}
		if(page.equalsIgnoreCase("fileuploadpage")){
			FileUploadPageHandler fdpHanlder = new FileUploadPageHandler(request, response);
			fdpHanlder.show();
		}
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/contacts_page.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
