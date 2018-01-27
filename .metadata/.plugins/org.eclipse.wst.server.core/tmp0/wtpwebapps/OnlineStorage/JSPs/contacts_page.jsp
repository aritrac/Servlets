<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Contact Us</title>
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
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=contactus&actionid=doShow">Go Back</a></th>
		<table>
			<div
				style="width: 70%; top: 140px; height: 50px; left: 180px; position: absolute;">
				<h3 align="center">
					Contact Fog Computing
					</h4>
			</div>
			<div
				style="width: 70%; top: 202px; height: 30px; left: 180px; text-align: center; position: absolute; display: none">
				<font color="red">Invalid User Password</color>
			</div>
			<div
				style="width: 60%; top: 250px; height: 100px; left: 460px; position: absolute">
				<p>Offensive Decoy technology Helpline service:+16789834346</p>
				<p>Emailid:offensivedectech@gmail.com</p>
			</div>
</body>
</html>