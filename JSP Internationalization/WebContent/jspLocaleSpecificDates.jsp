<%@page import="java.util.Date"%>
<%@page import="java.text.DateFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locale Specific Dates Settings</title>
</head>
<body>
<%
	String title = "Locale Specific Dates";
	//Get the client's locale
	Locale locale = request.getLocale();
	String date = DateFormat.getDateTimeInstance(DateFormat.FULL,DateFormat.SHORT,locale).format(new Date());
%>
<h1><%out.print(title); %></h1>
<p>Local Date: <% out.print(date); %></p>
</body>
</html>