<%@page import="com.sun.org.apache.bcel.internal.generic.FNEG"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Using EL expressions</title>
</head>
<body>
	<jsp:useBean id="box" class="com.aritra.BoxBean">
		<jsp:setProperty name="box" property="height" value="100"/>
	</jsp:useBean>
	<b>Original Height</b><br/>
	<jsp:getProperty property="height" name="box"/> <br/>
	<b>New Height</b><br/>
	<jsp:setProperty property="height" name="box" value="${2*box.height}"/><br/>
	<jsp:getProperty property="height" name="box"/>
	
	<!--
		Operator					Description
		.							Access a bean property
		[]							Access an array or List element
		( )							Group a expression to change the evaluation order
		+							Add
		-							Subtract
		*							Multiply
		/ or div					Division
		% or mod					Modulo
		== or eq					equality
		!= or ne					Not equality
		< or lt						less than
		> or gt						greater than
		<= or le					less than or equal
		>= or gt					greater than or equal
		&& or and					logical AND
		|| or or					logical OR
		! or not					Unary Boolean complement
		empty						Test for empty variable values 
	 -->
	 
	 <!-- Using JSP Functions from JSTL using EL -->
	 <p>
	 Length of string "hello" is ${fn:length("hello")}
	 </p>
	 
	 <!--
	 	Implicit object				Description
		pageScope					page scoped variables
		requestScope				request scoped variables
		sessionScope				session scoped variables
		applicationScope			application scoped variables
		param						Request parameters as strings
		paramValues					Request parameters as collections of strings
		header						HTTP request headers as strings
		headerValues				HTTP request headers as collections of strings
		initParam					Context-initialization parameters
		cookie						Cookie values
		pageContext					The JSP PageContext object for the current page 
	  -->
	  
	  <!-- Accessing A Request Param -->
	  <p>The value of request param "myParam" is ${param["myParam"]}</p>
	  
	  <!-- Accessing HTTP Headers -->
	  <p>The value of user-agent is ${header["user-agent"]}</p>
</body>
</html>