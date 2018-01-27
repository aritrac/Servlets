<%@ page language="java" import="java.io.*,java.util.*,javax.servlet.*,java.text.*" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("E yyyy.MM.dd 'at' hh:mm:ss a zzz");
	out.print("<h2 align=\"center\">" + ft.format(dNow) + "</h2>");
%>
</body>
</html>