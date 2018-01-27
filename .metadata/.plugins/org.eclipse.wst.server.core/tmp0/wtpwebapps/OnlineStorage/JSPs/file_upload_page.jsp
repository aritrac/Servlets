<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String fileName = "";
		String fileid = "";
		if(session.getAttribute("fileid") != null){
			fileid = (String)session.getAttribute("fileid");
		}
		if(session.getAttribute("filename") != null){
			fileName = (String)session.getAttribute("filename");
		}
	%>
	<title>File Upload</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:50%;position:absolute;top:100px;height:80x;left:500px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doShowMyFiles">My Files</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doShowAlerts">View Alert</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doChangePassword">Change Password</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Fileupload</h4></div>
	<div style="width:70%;top:197px;height:50px;border-style:solid;left:230px;position:absolute;display:none"><h4 align="center">Some Message Abount Content Shown</h4></div>
	<div style="width:30%;top:250px;height:110px;left:550px;position:absolute">
		<form action="<%=request.getContextPath()%>/Dispatcher?pageid=fileupload&actionid=doUploadFile" method="POST" enctype="multipart/form-data">
			<table style="width:30%;top:260px;left:560px;position:absolute">
				<tr>
					<td>Filename</td>
					<td><%=fileName %></td>
				</tr>
				<tr>
					<td>FileId</td>
					<td><%=fileid %></td>
				</tr>
				<tr>
					<td>Choose File</td>
					<td><input type="file" name="fileToBeUploaded" value="Choose file"/></td>
				</tr>
				<tr>
					<td colspan="2" align="center"><input type="Submit" value="Upload"/></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>
