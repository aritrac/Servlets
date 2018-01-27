<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Format Transform XML Using XSL in JSP</title>
</head>
<body>
	<c:set var="xmltext">
		<books>
			<book>
				<name>JSP</name>
				<author>java2s.com</author>
				<price>100</price>
			</book>
			<book>
				<name>Servlet</name>
				<author>java2s.com</author>
				<price>2000</price>
			</book>
		</books>
	</c:set>
	<c:import url="style.xsl" var="xslt"/>
	<x:transform xml="${xmltext}" xslt="${xslt}"/>
</body>
</html>