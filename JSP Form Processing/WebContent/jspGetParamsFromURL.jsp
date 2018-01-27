<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--Access this page from the following to print out the params : http://localhost:8080/main.jsp?first_name=James&last_name=Smith --%>
	
	<b>First Name:</b><%=request.getParameter("first_name") %>
	<b>Last Name:</b><%=request.getParameter("last_name") %>
</body>
</html>