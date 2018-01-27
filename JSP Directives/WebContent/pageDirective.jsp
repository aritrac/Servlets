<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--the PAGE directive --%>
	<%--example of PAGE IMPORT attribute --%>
	
	<%--buffer : Set a buffering model for the output stream.--%>
	<%--autoFlush : Set behavior of the servlet output buffer.--%>
	<%--contentType : Set the character encoding scheme.--%>
	<%--errorPage : Set the URL of another JSP for Java unchecked runtime exceptions.--%>
	<%--isErrorPage : Set if this JSP page is used by another JSP page as errorPage.--%>
	<%--extends : Set a superclass that the generated servlet must extend--%>
	<%--import : A list of packages as Java import statement in the JSP.--%>
	<%--info : Provides a string that will be returned from the servlet's getServletInfo() method%>
	<%--isThreadSafe : Set the threading model for the generated servlet.--%>
	<%--language : Defines the programming language used in the JSP page.--%>
	<%--session : Specifies whether or not the JSP page is in HTTP sessions--%>
	<%--isELIgnored : Whether to igore EL expression within the JSP page.--%>
	<%--isScriptingEnabled : Determines if scripting elements are allowed.--%>
	
	<%@page import="java.util.Date" %>
	Today is: <%=new Date() %>
	
	<%--example of PAGE CONTENT TYPE attribute --%>
	<%@page contentType=application/msword %>
	Today is: <%=new Date() %>
	
	<%--example of PAGE INFO attribute --%>
	<%@ page info="composed by java2s.com" %>
	Today is: <%=new Date() %>
	
	<%--example of PAGE BUFFER attribute --%>
	<%@page buffer="16kb" %>
	Today is: <%=new Date() %>
	
	<%--example of PAGE ERRORPAGE attribute --%>
	<%@page errorPage="myerrorpage.jsp" %>
	<%=100/0 %>
	
	<%--example of PAGE ISERRORPAGE attribute --%>
	<%@page isErrorPage="true" %>
	Sorry an exception occurred! <br/>
	The exception is: <%=exception %>
	
	
	
	<%--the TAGLIB directive --%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
	<%--XML Equivalent --%>
	<jsp:directive.taglib uri = "http://java.sun.com/jsp/jstl/core" prefix="c"/>
	
	<%@include file="include.jsp" %>
	<%--XML Equivalent --%>
	<jsp:directive.include file="include.jsp"/>
</body>
</html>