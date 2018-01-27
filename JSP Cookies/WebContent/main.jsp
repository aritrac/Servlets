<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	//Create cookies for first and last names.
	Cookie firstName = new Cookie("first_name",request.getParameter("first_name"));
	Cookie lastName = new Cookie("last_name",request.getParameter("last_name"));
			
	//Set expiry date after one hour for both the cookies
	firstName.setMaxAge(60*60);
	lastName.setMaxAge(60*60);
			
	//Add both the cookies in the response header
	response.addCookie(firstName);
	response.addCookie(lastName);
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>The JSP which sets client browser cookies when requested</title>
</head>
<body>
	<ul>
		<b>First Name:</b><%=request.getParameter("first_name") %><br/>
		<b>Last Name:</b><%=request.getParameter("last_name") %>
	</ul>
</body>
</html>