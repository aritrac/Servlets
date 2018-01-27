<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String uniqueCode = null;
		if(request.getAttribute("uniqueCode") != null){
			uniqueCode = (String)request.getAttribute("uniqueCode");
		}
	%>
	<title>Registration Success</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:10%;position:absolute;top:100px;height:80x;left:1200px;text-align:right;display:none" align="center">
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Please click <a href="<%=request.getContextPath()%>/Dispatcher?pageid=registrationdone&actionid=doShowLogin">here</a> to login again</h4></div>
	<div style="width:70%;top:197px;height:50px;left:230px;position:absolute"><h4 align="center">Registration Successful. Your unique code is <%=uniqueCode %>. Please keep in a safe place.</h4></div>
	<div style="width:34%;top:250px;height:350px;border-style:solid;left:500px;position:absolute;display:none">
		<h1 align="center">Show Error Details Here</h1>
	</div>
</body>
</html>
