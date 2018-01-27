<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using a Java Bean in JSP</title>
</head>
<body>
	<jsp:useBean id="students" class="com.aritra.StudentsBean">
		<jsp:setProperty name="students" property="firstName" value="Jack"/>
		<jsp:setProperty name="students" property="lastName" value="Smith"/>
		<jsp:setProperty name="students" property="age" value="24"/>
	</jsp:useBean>
	
	<p>
		Student First Name : <jsp:getProperty property="firstName" name="students"/>
	</p>
	<p>
		Student Last Name : <jsp:getProperty property="lastName" name="students"/>
	</p>
	<p>
		Student Age : <jsp:getProperty property="age" name="students"/>
	</p>
</body>
</html>