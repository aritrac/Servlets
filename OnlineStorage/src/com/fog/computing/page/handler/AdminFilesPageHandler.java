package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.FileDAO;
import com.fog.computing.dao.QuestionsDAO;
import com.fog.computing.pojo.File;

public class AdminFilesPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;

	// SESSION ATTRIBUTES
	List<File> fileList = null;

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public AdminFilesPageHandler(HttpServletRequest request,
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
		// RETRIEVE LIST OF FILES TO DISPLAY ON PAGE
		FileDAO fileDAO = new FileDAO(request.getServletContext());
		fileList = fileDAO.getRegisteredUsersFiles();
		request.getSession().setAttribute("fileList", fileList);
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

		if (actionId.equalsIgnoreCase("doShowUsers")) {
			doShowUsers();
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

		if (actionId.equalsIgnoreCase("doEditQuestions")) {
			doEditQuestions();
		}
	}

	// ACTION ID -> doShowUsers
	public void doShowUsers() throws IOException {
		AdminHomePageHandler ahpHandler = new AdminHomePageHandler(request,
				response);
		ahpHandler.show();
	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "adminfilespage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "adminfilespage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// ACTION ID -> doSignout
	public void doSignout() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		request.getSession().invalidate();
		lpHandler.show();
	}

	// ACTION ID -> doEditQuestions
	public void doEditQuestions() throws IOException {
		request.getSession().setAttribute("page", "adminfilespage");
		QuestionsDAO qDao = new QuestionsDAO(request.getServletContext());
		request.getSession().setAttribute("questions", qDao.getQuestions());
		EditQuestionsPageHandler eqpHandler = new EditQuestionsPageHandler(
				request, response);
		eqpHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/admin_files_page.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
