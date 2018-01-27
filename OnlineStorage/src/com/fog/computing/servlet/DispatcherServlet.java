package com.fog.computing.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fog.computing.page.handler.AboutUsPageHandler;
import com.fog.computing.page.handler.AdminFilesPageHandler;
import com.fog.computing.page.handler.AdminHomePageHandler;
import com.fog.computing.page.handler.AlertPageHandler;
import com.fog.computing.page.handler.ChangePasswordPageHandler;
import com.fog.computing.page.handler.ContactUsPageHandler;
import com.fog.computing.page.handler.EditQuestionsPageHandler;
import com.fog.computing.page.handler.FileDetailsPageHandler;
import com.fog.computing.page.handler.FileDownloadPageHandler;
import com.fog.computing.page.handler.FileUploadPageHandler;
import com.fog.computing.page.handler.LoginPageHandler;
import com.fog.computing.page.handler.RegistrationDonePageHandler;
import com.fog.computing.page.handler.RegistrationPageHandler;
import com.fog.computing.page.handler.UserHomePageHandler;

public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DispatcherServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("pageid");
		// GET REQUEST FOR LOGIN PAGE
		if (id.equalsIgnoreCase("login")) {
			LoginPageHandler lpHanlder = new LoginPageHandler(request, response);
			lpHanlder.handle();
		}

		// GET REQUEST FOR REGISTRATION PAGE
		if (id.equalsIgnoreCase("register")) {
			RegistrationPageHandler rpHanlder = new RegistrationPageHandler(
					request, response);
			rpHanlder.handle();
		}

		// GET REQUEST FOR REGISTRATION DONE PAGE
		if (id.equalsIgnoreCase("registrationdone")) {
			RegistrationDonePageHandler rpHanlder = new RegistrationDonePageHandler(
					request, response);
			rpHanlder.handle();
		}

		// GET REQUEST FOR USER HOME PAGE
		if (id.equalsIgnoreCase("userhome")) {
			UserHomePageHandler uhpHanlder = new UserHomePageHandler(request,
					response);
			uhpHanlder.handle();
		}

		// GET REQUEST FOR FILE DETAILS PAGE
		if (id.equalsIgnoreCase("filedetails")) {
			FileDetailsPageHandler fdpHanlder = new FileDetailsPageHandler(
					request, response);
			fdpHanlder.handle();
		}

		// GET REQUEST FOR FILE UPLOAD PAGE
		if (id.equalsIgnoreCase("fileupload")) {
			FileUploadPageHandler fupHanlder = new FileUploadPageHandler(
					request, response);
			fupHanlder.handle();
		}

		// GET REQUEST FOR ADMIN HOME PAGE
		if (id.equalsIgnoreCase("adminhome")) {
			AdminHomePageHandler ahpHanlder = new AdminHomePageHandler(request,
					response);
			ahpHanlder.handle();
		}

		// GET REQUEST FOR ADMIN FILES PAGE
		if (id.equalsIgnoreCase("adminfiles")) {
			AdminFilesPageHandler afpHanlder = new AdminFilesPageHandler(
					request, response);
			afpHanlder.handle();
		}

		// GET REQUEST FOR CONTACT US PAGE
		if (id.equalsIgnoreCase("contactus")) {
			ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
					response);
			cupHandler.handle();
		}

		// GET REQUEST FOR ABOUT US PAGE
		if (id.equalsIgnoreCase("aboutus")) {
			AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
					response);
			aupHandler.handle();
		}

		// GET REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("editquestions")) {
			EditQuestionsPageHandler eqpHandler = new EditQuestionsPageHandler(
					request, response);
			eqpHandler.handle();
		}

		// GET REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("changepassword")) {
			ChangePasswordPageHandler cppHandler = new ChangePasswordPageHandler(
					request, response);
			cppHandler.handle();
		}

		// GET REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("filedownload")) {
			FileDownloadPageHandler fdpHandler = new FileDownloadPageHandler(
					request, response);
			fdpHandler.handle();
		}

		// GET REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("alert")) {
			AlertPageHandler apHandler = new AlertPageHandler(request, response);
			apHandler.handle();
		}
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("pageid");

		// POST REQUEST FOR LOGIN PAGE
		if (id.equalsIgnoreCase("login")) {
			LoginPageHandler lpHanlder = new LoginPageHandler(request, response);
			lpHanlder.handle();
		}
		// POST REQUEST FOR REGISTRATION PAGE
		if (id.equalsIgnoreCase("register")) {
			RegistrationPageHandler rpHanlder = new RegistrationPageHandler(
					request, response);
			rpHanlder.handle();
		}

		// POST REQUEST FOR REGISTRATION DONE PAGE
		if (id.equalsIgnoreCase("registrationdone")) {
			RegistrationDonePageHandler rpHanlder = new RegistrationDonePageHandler(
					request, response);
			rpHanlder.handle();
		}

		// POST REQUEST FOR USER HOME PAGE
		if (id.equalsIgnoreCase("userhome")) {
			UserHomePageHandler uhpHanlder = new UserHomePageHandler(request,
					response);
			uhpHanlder.handle();
		}

		// POST REQUEST FOR FILE DETAILS PAGE
		if (id.equalsIgnoreCase("filedetails")) {
			FileDetailsPageHandler fdpHanlder = new FileDetailsPageHandler(
					request, response);
			fdpHanlder.handle();
		}

		// POST REQUEST FOR FILE UPLOAD PAGE
		if (id.equalsIgnoreCase("fileupload")) {
			FileUploadPageHandler fupHanlder = new FileUploadPageHandler(
					request, response);
			fupHanlder.handle();
		}

		// POST REQUEST FOR FILE UPLOAD PAGE
		if (id.equalsIgnoreCase("adminhome")) {
			AdminHomePageHandler ahpHanlder = new AdminHomePageHandler(request,
					response);
			ahpHanlder.handle();
		}

		// POST REQUEST FOR ADMIN FILES PAGE
		if (id.equalsIgnoreCase("adminfiles")) {
			AdminFilesPageHandler afpHanlder = new AdminFilesPageHandler(
					request, response);
			afpHanlder.handle();
		}

		// POST REQUEST FOR CONTACT US PAGE
		if (id.equalsIgnoreCase("contactus")) {
			AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
					response);
			aupHandler.handle();
		}

		// POST REQUEST FOR ABOUT US PAGE
		if (id.equalsIgnoreCase("aboutus")) {
			AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
					response);
			aupHandler.handle();
		}

		// POST REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("editquestions")) {
			EditQuestionsPageHandler eqpHandler = new EditQuestionsPageHandler(
					request, response);
			eqpHandler.handle();
		}

		// POST REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("changepassword")) {
			ChangePasswordPageHandler cppHandler = new ChangePasswordPageHandler(
					request, response);
			cppHandler.handle();
		}

		// POST REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("filedownload")) {
			FileDownloadPageHandler fdpHandler = new FileDownloadPageHandler(
					request, response);
			fdpHandler.handle();
		}

		// POST REQUEST FOR EDIT QUESTIONS PAGE
		if (id.equalsIgnoreCase("alert")) {
			AlertPageHandler apHandler = new AlertPageHandler(request, response);
			apHandler.handle();
		}
	}

}
