package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.DownloadDAO;
import com.fog.computing.dao.FileDAO;
import com.fog.computing.pojo.Download;
import com.fog.computing.pojo.User;

public class FileDetailsPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String filename = null;
	String fileid = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES
	String combinationExists = null;

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public FileDetailsPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		filename = request.getParameter("filename");
		fileid = request.getParameter("fileid");
	}

	// SET SESSION ATTRIBUTES FOR THE PAGE
	private void setSessionAttributes() {
		request.getSession().setAttribute("fileid", fileid);
		request.getSession().setAttribute("filename", filename);
	}

	// SET ERROR ATTRIBUTES FOR PAGE
	private void setErrorAttributes() {
		request.setAttribute("combinationExists", combinationExists);
	}

	// SET PAGE ATTRIBUTES
	private void setPageAttributes() {

	}

	// CONTROLS THE LOGIC FOR THE RESOURCE
	public void handle() throws IOException, ServletException {
		initParams();

		if (actionId.equalsIgnoreCase("doShowMyFiles")) {
			doShowMyFiles();
		}

		if (actionId.equalsIgnoreCase("doShowAlerts")) {
			doShowAlerts();
		}

		if (actionId.equalsIgnoreCase("doChangePassword")) {
			doChangePassword();
		}

		if (actionId.equalsIgnoreCase("doSignout")) {
			doSignout();
		}

		if (actionId.equalsIgnoreCase("doFileDetailsCheck")) {
			doFileDetailsCheck();
		}

		if (actionId.equalsIgnoreCase("doShowAboutUs")) {
			doShowAboutUs();
		}

		if (actionId.equalsIgnoreCase("doShowContactUs")) {
			doShowContactUs();
		}
	}

	// ACTION ID -> doShowMyFiles
	public void doShowMyFiles() throws IOException {
		UserHomePageHandler uhpHandler = new UserHomePageHandler(request,
				response);
		uhpHandler.show();
	}

	// ACTION ID -> doShowAlerts
	public void doShowAlerts() throws IOException {
		DownloadDAO downloadDao = new DownloadDAO(request.getServletContext());

		User user = (User) request.getSession().getAttribute("user");
		List<Download> entries = downloadDao.getEntriesByUserId(user
				.getUserId());
		request.getSession().setAttribute("entries", entries);
		AlertPageHandler apHandler = new AlertPageHandler(request, response);
		apHandler.show();
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

	// ACTION ID -> doFileDetailsCheck
	public void doFileDetailsCheck() throws IOException, ServletException {
		FileDAO fileDAO = new FileDAO(request.getServletContext());

		// GETTING SESSION DATA SET FROM OTHER PAGES
		String userid = ((User) request.getSession().getAttribute("user"))
				.getUserId();

		if (fileDAO.isFileDetailsDuplicate(filename, fileid, userid)) {
			combinationExists = "true";
			showError();
		} else {
			setSessionAttributes();
			FileUploadPageHandler fupHandler = new FileUploadPageHandler(
					request, response);
			fupHandler.show();
		}
	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "filedetailspage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "filedetailspage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/file_details_page.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {
		setErrorAttributes();
		request.getRequestDispatcher("JSPs/file_details_page.jsp").forward(
				request, response);
	}
}
