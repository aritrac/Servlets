<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Normal Error Handling via Java</title>
</head>
<body>
	<%
		try{
			int i = 1;
			i = i / 0;
			out.println("The answer is " + i);
		}catch(Exception e){
			out.println("An exception occurred: " + e.getMessage());
		}
	%>
</body>
</html>