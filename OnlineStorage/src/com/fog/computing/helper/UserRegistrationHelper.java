package com.fog.computing.helper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserRegistrationHelper{
	private HttpServletRequest request = null;
	private HttpServletResponse response = null;
	
	private boolean hasErrored = false;
	private String errorMessage = null;
	
	public UserRegistrationHelper(HttpServletRequest request, HttpServletResponse response) throws Exception{
		this.request = request;
		this.response = response;
		doRegistration();
	}
	
	public void doRegistration() throws Exception{
		UserHelper dbHelper = new UserHelper(request.getServletContext());
		if(dbHelper.insertUser(request)){
			//Everything is fine
		}else{
			hasErrored = true;
			errorMessage = "Same user data already exists";
			request.setAttribute("errorMessage", errorMessage);
			request.setAttribute("errorType", "registration_error");
		}
	}
	
	public boolean hasErrored(){
		return hasErrored;
	}

}
