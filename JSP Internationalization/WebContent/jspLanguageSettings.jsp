<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Language Settings</title>
</head>
<body>
	<%
		//Set response content type
		response.setContentType("text/html");
		//Set spanish language code
		response.setHeader("Content-Language","es");
		String title = "En Espaol";
	%>
	
	<h1><% out.print(title); %></h1>
</body>
</html>