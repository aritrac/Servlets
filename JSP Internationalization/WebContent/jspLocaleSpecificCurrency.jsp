<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locale Specific Currency</title>
</head>
<body>
<%
	String title = "Locale Specific Currency";
	//Get the client's locale
	Locale locale = request.getLocale();
	NumberFormat nft = NumberFormat.getCurrencyInstance(locale);
	String formattedCurr = nft.format(1000000);
%>
<center>
	<h1><%out.print(title); %></h1>
</center>
<div align="center">
	<p>Formatted Currency : <%out.print(formattedCurr); %></p>
</div>
</body>
</html>