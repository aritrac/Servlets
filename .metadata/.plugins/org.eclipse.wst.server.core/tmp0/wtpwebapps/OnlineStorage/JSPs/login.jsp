<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String showCredentialsInvalid = "display:none";
		if(request.getAttribute("credentialsInvalid") != null){
			showCredentialsInvalid = "";
		}
	%>
	<title>Please login</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:30%;position:absolute;top:100px;height:80x;left:770px;text-align:right" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=login&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=login&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=login&actionid=doRegister">First Time User</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:180px;position:absolute;"><h3 align="center">Please login to continue</h4></div>
	<div style="width:70%;top:202px;height:30px;left:180px;text-align:center;position:absolute;<%=showCredentialsInvalid%>"><font color="red">Invalid User Password</color></div>
	<div style="width:40%;top:250px;height:100px;left:510px;position:absolute">
		<form action="<%=request.getContextPath()%>/Dispatcher?pageid=login&actionid=doLogin" method="POST">
			<table style="width:20%;top:260px;left:510px;position:absolute">
				<tr>
					<td>Username</td>
					<td><input name="username" type="text" required="required"/></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="password" required="required"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit" value="login"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
