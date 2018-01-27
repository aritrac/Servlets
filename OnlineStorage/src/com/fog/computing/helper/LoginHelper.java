package com.fog.computing.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginHelper{
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	
	private boolean hasErrored = false;
	private String errorMessage = null;
	
	public LoginHelper(HttpServletRequest request, HttpServletResponse response){
		this.request = request;
		this.response = response;
		doLogin();
	}
	
	public void doLogin(){
		
		UserHelper dbHelper = new UserHelper(request.getServletContext());
		if(dbHelper.isUserRegistered(request)){
			//Everything is fine, so create a user session
			HttpSession session = request.getSession();
			session.setAttribute("username", "Aritra");
			session.setMaxInactiveInterval(10); //Time is in seconds
		}else{
			hasErrored = true;
			errorMessage = "Username does not exist.";
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorType", "login_error");
		}
	}
	
	public boolean hasErrored(){
		return hasErrored;
	}
}
