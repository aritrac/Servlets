<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<%
	Date createTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());
		
	String title = "Welcome Back";
	Integer visitCount = new Integer(0);
	String visitCountKey = "visitCount";
	String userIDKey = new String("userID");
	String userID = new String("Java2s_ID");
	
	if(session.isNew()){
		title = "Welcome";
		session.setAttribute(userIDKey, userID);
		session.setAttribute(visitCountKey, visitCount);
	}
	
	visitCount = (Integer)session.getAttribute(visitCountKey);
	visitCount = visitCount + 1;
	userID = (String)session.getAttribute(userIDKey);
	session.setAttribute(visitCountKey, visitCount);
%>
<body>

<%
	//Remove a particular attribute from a session
	session.removeAttribute("userID");

	//Remove the entire session from server
	session.invalidate();
	
	//To set session timeout for each session individually
	session.setMaxInactiveInterval(60);
%>

</body>
</html>