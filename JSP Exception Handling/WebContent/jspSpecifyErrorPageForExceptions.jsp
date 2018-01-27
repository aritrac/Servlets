<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="ShowErrorUsingJstl.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Specify Error Page For Exceptions</title>
</head>
<body>
	<%
		int x = 1;
		if(x == 1){
			throw new RuntimeException("Error condition!!!");
		}
	%>
</body>
</html>