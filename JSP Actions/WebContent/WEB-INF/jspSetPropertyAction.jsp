<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.aritra.jsp.Customer"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Customer cust = new Customer();
	%>
	<%--Defining Bean properties outside the Bean --%>
	<jsp:useBean id="cust1" class="com.aritra.jsp.Customer"/>  <%--Created a customer bean --%>
	
	
	<jsp:setProperty property="firstName" name="cust1" value="Aritra"/>			<%--Setting the firstName of the bean Customer we created --%>
	<jsp:setProperty property="lastName" name="cust1" value="Chatterjee" />		<%--Setting the lastName of the bean Customer we created --%>
	
	<%--Defining Bean properties inside the Bean --%>
	<jsp:useBean id="cust2" class="com.aritra.jsp.Customer">
		<jsp:setProperty name="cust2" property="firstName" value="Ankita"/>
		<jsp:setProperty name="cust2" property="lastName" value="Chatterjee"/>
	</jsp:useBean>
	
	<jsp:getProperty property="firstName" name="cust1"/>
	<jsp:getProperty property="lastName" name="cust1"/>
	
	<jsp:getProperty property="firstName" name="cust2"/>
	<jsp:getProperty property="lastName" name="cust2"/>
</body>
</html>