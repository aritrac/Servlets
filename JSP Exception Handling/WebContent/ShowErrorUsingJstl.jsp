<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Page With JSTL</title>
</head>
<body>
	<b>Error:</b>${pageContext.exception}
	<b>URI:</b>${pageContext.errorData.requestURI}
	<b>Status Code:</b>${pageContext.errorData.statusCode}
	<c:forEach var="trace" items="${pageContext.exception.stackTrace}">
		<p>${trace}</p>
	</c:forEach>
</body>
</html>