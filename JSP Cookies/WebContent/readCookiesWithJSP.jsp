<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Reading already set cookies</title>
</head>
<body>
	<%
		Cookie cookie = null;
		Cookie[] cookies = null;
		cookies = request.getCookies();
		if(cookies != null){
			for(int i = 0; i < cookies.length; i++){
				cookie = cookies[i];
				out.print("Name : " + cookie.getName() + ", ");
				out.print("Value : " + cookie.getValue() + " <br/>");
			}
		}else{
			out.println("<h2>No cookies found</h2>");
		}
	%>
</body>
</html>