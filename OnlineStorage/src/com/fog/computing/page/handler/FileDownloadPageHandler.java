package com.fog.computing.page.handler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;

import com.fog.computing.dao.DownloadDAO;
import com.fog.computing.dao.FileDAO;
import com.fog.computing.dao.UserDAO;
import com.fog.computing.pojo.Download;
import com.fog.computing.pojo.File;
import com.fog.computing.pojo.User;

public class FileDownloadPageHandler {
	// REQUEST AND RESPONSE OBJECTS
	private HttpServletRequest request;
	private HttpServletResponse response;

	// PAGE PARAMETERS
	String pageId = null;
	String actionId = null;
	String uniqueCode = null;

	// SESSION ATTRIBUTES

	// ERROR ATTRIBUTES

	// PAGE ATTRIBUTES

	// PAGE HANDLER CONSTRUCTOR
	public FileDownloadPageHandler(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	// GET ALL PARAMS FROM PAGE
	private void initParams() {
		pageId = request.getParameter("pageid");
		actionId = request.getParameter("actionid");
		uniqueCode = request.getParameter("unique_code");
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

		if (actionId.equalsIgnoreCase("doFileDownload")) {
			doFileDownload();
		}
	}

	// ACTION ID -> doFileDownload
	public void doFileDownload() throws IOException {
		String fileId = (String)request.getSession().getAttribute("fileid");
		FileDAO fileDao = new FileDAO(request.getServletContext());
		File file = fileDao.findFile(fileId);
		
		//Creating an entry for the Download
		Download download = new Download();
		download.setFileID(file.getFileId());
		download.setFileName(file.getFileName());
		download.setUserId(file.getUserId());
		download.setDownloadTime(new Date(Calendar.getInstance().getTimeInMillis()));
		
		
		UserDAO userDao = new UserDAO(request.getServletContext());
		User user = (User)request.getSession().getAttribute("user");
		
		if(userDao.validateUniqueCode(uniqueCode, user)){
			//Check if time is valid
			//Getting hour from current time
			int current_hr = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
			System.out.println("current : " + current_hr);
			System.out.println("start hh : " + user.getStartHH());
			System.out.println("end hh : " + user.getEndHH());
			if(current_hr >= user.getStartHH() && current_hr <= user.getEndHH()){
				download.setIsSuccessful("Y");
				//DOWNLOAD ORIGINAL FILE
				java.io.File fileToDownload = new java.io.File("C:\\temp\\orig.txt");
				FileInputStream inStream = new FileInputStream(fileToDownload);
				String mimeType = request.getServletContext().getMimeType("C:\\temp\\orig.txt");
				if(mimeType == null){
					//set to binary type if mime mapping is not found
					mimeType = "application/octet-stream";
				}
				response.setContentType(mimeType);
				response.setContentLength((int)fileToDownload.length());
				
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; file=\"%s\"", fileToDownload.getName());
				response.setHeader(headerKey, headerValue);
				
				OutputStream outStream = response.getOutputStream();
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inStream.read(buffer)) != -1){
					outStream.write(buffer,0,bytesRead);
				}
				
				inStream.close();
				outStream.close();
				
			}else{
				download.setIsSuccessful("N");
				//DOWNLOAD DUMMY FILE
				java.io.File fileToDownload = new java.io.File("C:\\temp\\dummy.txt");
				FileInputStream inStream = new FileInputStream(fileToDownload);
				String mimeType = request.getServletContext().getMimeType("C:\\temp\\dummy.txt");
				if(mimeType == null){
					//set to binary type if mime mapping is not found
					mimeType = "application/octet-stream";
				}
				response.setContentType(mimeType);
				response.setContentLength((int)fileToDownload.length());
				
				String headerKey = "Content-Disposition";
				String headerValue = String.format("attachment; file=\"%s\"", fileToDownload.getName());
				response.setHeader(headerKey, headerValue);
				
				OutputStream outStream = response.getOutputStream();
				
				byte[] buffer = new byte[4096];
				int bytesRead = -1;
				
				while((bytesRead = inStream.read(buffer)) != -1){
					outStream.write(buffer,0,bytesRead);
				}
				
				inStream.close();
				outStream.close();
			}
		}else{
			download.setIsSuccessful("N");
			//DOWNLOAD DUMMY FILE
			java.io.File fileToDownload = new java.io.File("C:\\temp\\dummy.txt");
			FileInputStream inStream = new FileInputStream(fileToDownload);
			String mimeType = request.getServletContext().getMimeType("C:\\temp\\dummy.txt");
			if(mimeType == null){
				//set to binary type if mime mapping is not found
				mimeType = "application/octet-stream";
			}
			response.setContentType(mimeType);
			response.setContentLength((int)fileToDownload.length());
			
			String headerKey = "Content-Disposition";
			String headerValue = String.format("attachment; file=\"%s\"", fileToDownload.getName());
			response.setHeader(headerKey, headerValue);
			
			OutputStream outStream = response.getOutputStream();
			
			byte[] buffer = new byte[4096];
			int bytesRead = -1;
			
			while((bytesRead = inStream.read(buffer)) != -1){
				outStream.write(buffer,0,bytesRead);
			}
			
			inStream.close();
			outStream.close();
		}
		
		DownloadDAO downloadDao = new DownloadDAO(request.getServletContext());
		downloadDao.createEntry(download);
		
		//UserHomePageHandler uhpHandler = new UserHomePageHandler(request, response);
		//uhpHandler.show();
	}

	// ACTION ID -> doShow
	public void doShow() throws IOException {
		UserHomePageHandler uhpHandler = new UserHomePageHandler(request,
				response);
		uhpHandler.show();
	}

	// SHOW THE PAGE
	public void show() throws IOException {
		setSessionAttributes();
		response.sendRedirect("JSPs/file_download.jsp");
	}

	// SHOW PAGE WITH ERROR
	public void showError() throws IOException, ServletException {

	}

}
