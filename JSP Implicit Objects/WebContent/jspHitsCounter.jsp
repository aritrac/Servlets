<%@page import="sun.nio.cs.HistoricallyNamedCharset"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.io.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer hitsCount = (Integer)application.getAttribute("hitCounter");
		if(hitsCount == null || hitsCount == 0){
			out.println("first time!");
			hitsCount = 1;
		}else{
			/*return visit*/
			out.println("Welcome back!");
			hitsCount++;
		}
		application.setAttribute("hitCounter", hitsCount);
	%>
	<p>Total number of visits: <%=hitsCount %></p>
</body>
</html>