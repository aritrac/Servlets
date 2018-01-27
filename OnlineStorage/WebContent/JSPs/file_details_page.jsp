<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String combinationExists = "display:none";
		if(request.getAttribute("combinationExists") != null){
			combinationExists = "";
		}
	%>
	<title>File Details</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:50%;position:absolute;top:100px;height:80x;left:500px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doShowMyFiles">My Files</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doShowAlerts">View Alert</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doChangePassword">Change Password</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Fileupload</h4></div>
	<div style="width:70%;top:197px;height:50px;left:230px;position:absolute;<%=combinationExists%>"><h4 align="center"><font color="red">Filename or FileId exists for user</font></h4></div>
	<div style="width:22%;top:250px;height:100px;left:550px;position:absolute">
		<form action="<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doFileDetailsCheck" method="POST">
			<table style="width:20%;top:260px;left:560px;position:absolute">
				<tr>
					<td>FileName</td>
					<td align="right"><input type="text" name="filename" required/></td>
				</tr>
				<tr>
					<td>FileID</td>
					<td align="right"><input type="text" name="fileid" required/></td>
				</tr>
				<tr>
					<td align="left"><input type="button" value="Back" onclick="location.href='<%=request.getContextPath()%>/Dispatcher?pageid=filedetails&actionid=doShowMyFiles'"/></td>
					<td align="right"><input type="submit" value="Continue"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
