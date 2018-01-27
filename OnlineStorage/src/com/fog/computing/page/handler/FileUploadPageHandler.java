package com.fog.computing.page.handler;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.fog.computing.dao.FileDAO;
import com.fog.computing.pojo.User;

public class FileUploadPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String fileToBeUploaded = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public FileUploadPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		fileToBeUploaded = request.getParameter("fileToBeUploaded");
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

		if (actionId.equalsIgnoreCase("doUploadFile")) {
			doUploadFile();
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

	}

	// ACTION ID -> doChangePassword
	public void doChangePassword() throws IOException {

	}

	// ACTION ID -> doSignout
	public void doSignout() throws IOException {
		LoginPageHandler lpHandler = new LoginPageHandler(request, response);
		request.getSession().invalidate();
		lpHandler.show();
	}

	// ACTION ID -> doUploadFile
	public void doUploadFile() throws IOException {
		File file;
		String uploadedFilePath = null;
		String decoyFilePath = null;
		// CREATING NEW FILE OBJECT TO PUT IN DB
		com.fog.computing.pojo.File newFile = new com.fog.computing.pojo.File();
		DiskFileItemFactory factory = new DiskFileItemFactory();
		factory.setSizeThreshold(50 * 1024); // 50 KB
		factory.setRepository(new File("c:\\temp"));

		ServletFileUpload upload = new ServletFileUpload(factory);
		upload.setSizeMax(4 * 1024); // 4 KB

		try {
			List<FileItem> fileItems = upload.parseRequest(request);

			Iterator<FileItem> iter = fileItems.iterator();

			while (iter.hasNext()) {
				FileItem fi = iter.next();
				if (!fi.isFormField()) {
					// SETTING THE FILE TYPE
					newFile.setFileType(fi.getContentType());
					// SETTING THE FILE SIZE
					newFile.setFileSize(fi.getSize());
					file = new File("C:\\temp\\" + fi.getName());
					fi.write(file);
					uploadedFilePath = file.getAbsolutePath();
					// SETTING THE FILE PATH
					newFile.setFilePath(uploadedFilePath);
					// SETTING THE FILE ID FROM SESSION
					newFile.setFileId((String) request.getSession()
							.getAttribute("fileid"));
					// SETTING THE FILE NAME FROM SESSION
					newFile.setFileName((String) request.getSession()
							.getAttribute("filename"));

					Calendar cal = Calendar.getInstance();
					// SETTING THE UPLOAD DATE
					newFile.setUploadDate(new java.sql.Date(cal
							.getTimeInMillis()));
				}
			}

			// CREATING THE DECOY FILE BASED ON THE UPLOADED FILE
			File decoy = new File("C:\\temp\\decoy.txt");
			decoyFilePath = decoy.getAbsolutePath();
			// SETTING THE DECOY FILE PATH
			newFile.setDecoyFilePath(decoyFilePath);
			// SETTING THE USER ID FROM SESSION
			newFile.setUserId(((User) request.getSession().getAttribute("user"))
					.getUserId());

			// READING THE ENTIRE CONTENT OF THE UPLOADED FILE
			BufferedReader br = new BufferedReader(new FileReader(
					uploadedFilePath));
			try {
				StringBuilder sb = new StringBuilder();
				String line = br.readLine();

				while (line != null) {
					sb.append(line);
					line = br.readLine();
				}

				String content = sb.toString();
				br.close();

				// GENERATING DECOY CONTENT TO PUT IN DECOY FILE
				StringBuilder newContent = new StringBuilder();
				for (int i = 0; i < content.length(); i++) {
					newContent
							.append(Character.toChars((content.charAt(i) + (int) (Math
									.random() * 9))));
				}

				String decoyContent = newContent.toString();

				// WRITING DECOY CONTENT TO DECOY FILE
				FileOutputStream fos = new FileOutputStream(decoy);
				fos.write(decoyContent.getBytes());
				fos.close();

			} catch (Exception ex) {
				ex.printStackTrace();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		// PUTTING THE FILE OBJECT IN DB
		FileDAO fileDAO = new FileDAO(request.getServletContext());
		fileDAO.createFile(newFile);
		
		UserHomePageHandler uhpHanlder = new UserHomePageHandler(request, response);
		uhpHanlder.show();

	}

	// ACTION ID -> doShowContactUs
	public void doShowContactUs() throws IOException {
		ContactUsPageHandler cupHandler = new ContactUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "fileuploadpage");
		request.getSession().setAttribute("actionid", "show");
		cupHandler.show();
	}

	// ACTION ID -> doShowAboutUs
	public void doShowAboutUs() throws IOException {
		AboutUsPageHandler aupHandler = new AboutUsPageHandler(request,
				response);
		request.getSession().setAttribute("page", "fileuploadpage");
		request.getSession().setAttribute("actionid", "show");
		aupHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/file_upload_page.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}
}
