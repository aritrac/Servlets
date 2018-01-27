package com.fog.computing.page.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.UserDAO;
import com.fog.computing.pojo.User;

public class ChangePasswordPageHandler {
	// REQUEST AND RESPONSE OBJECTS
		private HttpServletRequest request;
		private HttpServletResponse response;

		// PAGE PARAMETERS
		String pageId = null;
		String actionId = null;
		String unique_code = null;
		String password = null;
		String confirm_password = null;

		// SESSION ATTRIBUTES

		// ERROR ATTRIBUTES
		String uniqueCodeError = "false";
		String passwordsNotMatch = "false";
		
		// PAGE ATTRIBUTES

		// PAGE HANDLER CONSTRUCTOR
		public ChangePasswordPageHandler(HttpServletRequest request,
				HttpServletResponse response) {
			this.request = request;
			this.response = response;
		}

		// GET ALL PARAMS FROM PAGE
		private void initParams() {
			pageId = request.getParameter("pageid");
			actionId = request.getParameter("actionid");
			unique_code = request.getParameter("unique_code");
			password = request.getParameter("password");
			confirm_password = request.getParameter("confirm_password");
		}

		// SET SESSION ATTRIBUTES FOR THE PAGE
		private void setSessionAttributes() {
			
		}

		// SET ERROR ATTRIBUTES FOR PAGE
		private void setErrorAttributes() {
			request.getSession().setAttribute("uniqueCodeError", uniqueCodeError);
			request.getSession().setAttribute("passwordsNotMatch", passwordsNotMatch);
		}
		
		// SET PAGE ATTRIBUTES
		private void setPageAttributes(){
			
		}

		// CONTROLS THE LOGIC FOR THE RESOURCE
		public void handle() throws IOException,ServletException {
			initParams();
			
			if (actionId.equalsIgnoreCase("doShow")) {
				doShow();
			}
			
			if (actionId.equalsIgnoreCase("doChangePassword")) {
				doChangePassword();
			}
		}
		
		// ACTION ID -> doShow
		public void doShow() throws IOException {
			UserHomePageHandler uhpHandler = new UserHomePageHandler(request, response);
			uhpHandler.show();
		}
		
		// ACTION ID -> doChangePassword
		public void doChangePassword() throws IOException, ServletException {
			UserDAO userDAO = new UserDAO(request.getServletContext());
			if(userDAO.validateUniqueCode(unique_code,(User)request.getSession().getAttribute("user"))){
				if(password.equalsIgnoreCase(confirm_password)){
					userDAO.updatePassword(password, (User)request.getSession().getAttribute("user"));
					UserHomePageHandler uhpHandler = new UserHomePageHandler(request, response);
					uhpHandler.show();
				}else{
					passwordsNotMatch = "true";
					showError();
				}
			}else{
				uniqueCodeError = "true";
				showError();
			}
		}

		// SHOW THE PAGE
		public void show() throws IOException {
			setSessionAttributes();
			response.sendRedirect("JSPs/change_password.jsp");
		}

		// SHOW PAGE WITH ERROR
		public void showError() throws IOException, ServletException {
			setErrorAttributes();
			response.sendRedirect("JSPs/change_password.jsp");
		}
}
