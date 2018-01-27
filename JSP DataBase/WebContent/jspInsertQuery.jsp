<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert Query JSP</title>
</head>
<body>
	<sql:setDataSource var="snapshot" driver="com.mysql.jdbc.Driver" url="jdbc:mysql://localhost/TEST" user="root" password="pass123"/>
	
	<sql:update dataSource="${snapshot}" var="result">
		insert into employees values(104,2,"FirstName","LastName");
	</sql:update>
	
	<sql:query dataSource="${snapshot}" var="result">
		select * from employees;
	</sql:query>
	
	<table border="1" width="100%">
		<tr>
			<th>Emp ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
		</tr>
		<c:forEach var="row" items="${result.rows}">
			<tr>
				<td><c:out value="${row.id}"/></td>
				<td><c:out value="${row.first}"/></td>
				<td><c:out value="${row.last}"/></td>
				<td><c:out value="${row.age}"/></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>