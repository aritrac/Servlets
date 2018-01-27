<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>About Fog Computing</title>
</head>
<body>
<!-- ALL JAVA CODE HERE -->
	<%
		String pageId = "";
		String actionId = "";
		if(session.getAttribute("page") != null){
			pageId = (String)session.getAttribute("pageid");
		}
		
		if(session.getAttribute("actionid") != null){
			actionId = (String)session.getAttribute("actionid");
		}
	%>
	<div
		style="width: 70%; top: 0px; height: 80px; left: 230px; position: absolute">
		<h1 align="center">Fog Computing : Mitigating Insider Data Theft
			Attacks In the Cloud</h1>
	</div>
	<table
		style="width: 10%; position: absolute; top: 100px; height: 80x; left: 1060px; text-align: right"
		align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=aboutus&actionid=doShow">Go Back</a></th>
		<table>
			<div
				style="width: 70%; top: 140px; height: 50px; left: 180px; position: absolute;">
				<h3 align="center">
					About Fog Computing
					</h4>
			</div>
			<div
				style="width: 70%; top: 202px; height: 30px; left: 180px; text-align: center; position: absolute; display: none">
				<font color="red">Invalid User Password</color>
			</div>
			<div
				style="width: 60%; top: 250px; height: 100px; left: 290px; position: absolute">
				<p>Offensive decoy technology is a system, which provides the
					clients to secure their information in the server using decoy
					technology. The users are those who have valid credentials to use
					this system. In this system users are also called as insiders. In
					the security point of view, all the remote-users are to be treated
					as attackers.</p>
				<p>When the user registers to our system user needs to answer
					some challenging questions and select a specific time to download
					files along with valid details required to use the system. From
					answers given by the user for that challenging questions the system
					provides the security answer by performing some operations within
					the system for downloading files.</p>
				<p>If the insider or attacker wants to download the file from
					the system user should provide security answer provided at the time
					of registration. If the security answer is incorrect or if it is
					not a specified time to download the file then the system provides
					an identical file which is not an original file which is also
					called as decoy file to the insider/attacker. Apart from that, in
					our system user can also view how many times each file have been
					downloaded by the insider and attacker.</p>
			</div>
</body>
</html>