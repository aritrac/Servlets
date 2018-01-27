<%@page import="org.apache.commons.fileupload.FileItem"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="org.apache.commons.fileupload.servlet.ServletFileUpload"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItemFactory"%>
<%@page import="org.apache.commons.fileupload.disk.DiskFileItem"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		File file;
		int maxFileSize = 5000 * 1024;
		int maxMemSize = 5000 * 1024;
		
		String filePath = "D:/upload/";
		String contentType = request.getContentType();
		if(contentType.indexOf("multipart/form-data") >= 0){
			DiskFileItemFactory factory = new DiskFileItemFactory();
			factory.setSizeThreshold(maxMemSize);
			factory.setRepository(new File("D:/temp"));
			ServletFileUpload upload = new ServletFileUpload(factory);
			upload.setSizeMax(maxFileSize);
			try{
				List fileItems = upload.parseRequest(request);
				Iterator i = fileItems.iterator();
				out.println("<html>");
				out.println("<body>");
				while(i.hasNext()){
					FileItem fi = (FileItem)i.next();
					if(!fi.isFormField()){
						String fieldName = fi.getFieldName();
						String fileName = fi.getName();
						boolean isInMemory = fi.isInMemory();
						long sizeInBytes = fi.getSize();
						file = new File(filePath + "uploadedDoc1.pdf");
						fi.write(file);
						out.println("Upoaded Filename : " + filePath + fileName + "<br>");
					}
				}
				out.println("</body>");
				out.println("</html>");
			}catch(Exception ex){
				ex.printStackTrace();
			}
		}else{
			out.println("<html>");
			out.println("<body>");
			out.println("<p>No File Uploaded</p>");
			out.println("</body>");
			out.println("</html>");
		}
	%>
</body>
</html>