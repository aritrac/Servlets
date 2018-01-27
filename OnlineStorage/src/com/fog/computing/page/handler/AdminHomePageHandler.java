package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.QuestionsDAO;
import com.fog.computing.dao.UserDAO;
import com.fog.computing.pojo.User;

public class AdminHomePageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;

	// SESSION ATTRIBUTES
	List<User> userList = null; // LIST OF ALL REGISTERED USER FILES WHICH WAS
								// UPLOADED
	User userToEdit = null; // USER ID TO EDIT IN THE USER EDIT PAGE

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public AdminHomePageHandler(HttpServletRequest request,
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
		// RETRIEVE LIST OF USERS TO DISPLAY ON PAGE
		UserDAO userDAO = new UserDAO(request.getServletContext());
		userList = userDAO.getRegisteredUsers();
		request.getSession().setAttribute("userList", userList);
		request.getSession().setAttribute("userIdToEdit", userToEdit);
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

		if (actionId.equalsIgnoreCase("doShowUploads")) {
			doShowUploads();
		}

		if (actionId.equalsIgnoreCase("doShowAboutUs")) {
			doShowAboutUs();
		}

		if (actionId.equalsIgnoreCase("doShowContactUs")) {
			doShowContactUs();
		}

		if (actionId.equalsIgnoreCase("doSignout")) {
			doSignout();
		}

		if (actionId.equalsIgnoreCase("doUserEdit")) {
			doUserEdit();
		}

		if (actionId.equalsIgnoreCase("doEditQuestions")) {
			doEditQuestions();
		}
	}

	// ACTION ID -> doShowUploads
	public void doShowUploads() throws IOException {
		AdminFilesPageHandler afpHanlder = new AdminFilesPageHandler(request,
				response);
		afpHanlder.show();
	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "adminhomepage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "adminhomepage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// ACTION ID -> doSignout
	public void doSignout() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		request.getSession().invalidate();
		lpHandler.show();
	}

	// ACTION ID -> doUserEdit
	public void doUserEdit() throws IOException {
		UserDAO userDAO = new UserDAO(request.getServletContext());
		userToEdit = userDAO.getUserByUserId(request.getParameter("userid"));
		setSessionAttributes();
		EditUserPageHandler eupHandler = new EditUserPageHandler(request,
				response);
		eupHandler.show();
	}

	// ACTION ID -> doEditQuestions
	public void doEditQuestions() throws IOException {
		request.getSession().setAttribute("page", "adminhomepage");
		QuestionsDAO qDao = new QuestionsDAO(request.getServletContext());
		request.getSession().setAttribute("questions", qDao.getQuestions());
		EditQuestionsPageHandler eqpHandler = new EditQuestionsPageHandler(
				request, response);
		eqpHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/admin_home_page.jsp");
	}
}
