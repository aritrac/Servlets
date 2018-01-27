package com.fog.computing.page.handler;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.dao.DownloadDAO;
import com.fog.computing.dao.FileDAO;
import com.fog.computing.pojo.Download;
import com.fog.computing.pojo.File;
import com.fog.computing.pojo.User;

public class UserHomePageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String fileId = null;

	// SESSION ATTRIBUTES
	List<File> fileList = null; // LIST OF ALL REGISTERED USER FILES WHICH WAS
								// UPLOADED
	String username = null; // THIS IS FOR SESSION MANAGEMENT

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public UserHomePageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		fileId = request.getParameter("fileid");
	}

	// SET SESSION ATTRIBUTES FOR THE PAGE
	private void setSessionAttributes() {
		// RETRIEVE LIST OF FILES TO DISPLAY ON PAGE
		FileDAO fileDAO = new FileDAO(request.getServletContext());

		// GETTING SESSION DATA SET FROM OTHER PAGES
		String userId = ((User) request.getSession().getAttribute("user"))
				.getUserId();

		// SETTING SESSION DATA FOR CURRENT PAGE
		fileList = fileDAO.findFilesByUserId(userId);
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

		if (actionId.equalsIgnoreCase("doFileUpload")) {
			doFileUpload();
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

		if (actionId.equalsIgnoreCase("doFileDownload")) {
			doFileDownload();
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

	// ACTION ID -> doShowAlerts
	public void doShowAlerts() throws IOException {
		DownloadDAO downloadDao = new DownloadDAO(request.getServletContext());
		
		User user = (User)request.getSession().getAttribute("user");
		List<Download> entries = downloadDao.getEntriesByUserId(user.getUserId());
		request.getSession().setAttribute("entries", entries);
		AlertPageHandler apHandler = new AlertPageHandler(request, response);
		apHandler.show();
	}

	// ACTION ID -> doChangePassword
	public void doChangePassword() throws IOException {
		ChangePasswordPageHandler cppHandler = new ChangePasswordPageHandler(request, response);
		cppHandler.show();
	}

	// ACTION ID -> doSignout
	public void doSignout() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		request.getSession().invalidate();
		lpHandler.show();
	}

	// ACTION ID -> doDownloadFile
	public void doFileDownload() throws IOException {
		request.getSession().setAttribute("fileid", fileId);
		FileDownloadPageHandler fdpHandler = new FileDownloadPageHandler(request, response);
		fdpHandler.show();
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
		response.sendRedirect("JSPs/user_home_page.jsp");
	}
}
