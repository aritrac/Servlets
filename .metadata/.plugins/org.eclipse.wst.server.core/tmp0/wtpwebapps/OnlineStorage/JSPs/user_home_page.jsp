<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.File"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String username = "user";
		String noFilesToDisplay = "display:none";
		String noTableToDisplay = "";
		List<File> fileList = null;
		if(session.getAttribute("username") != null){
			username = (String)session.getAttribute("username");
		}
		if(session.getAttribute("fileList") != null){
			fileList = (List<File>)session.getAttribute("fileList");
			if(fileList.size() == 0){
				noFilesToDisplay = "";
				noTableToDisplay = "display:none";
			}
		}
	%>
	<title>User Home</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:50%;position:absolute;top:100px;height:80x;left:500px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doFileUpload">Upload File</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doShowAlerts">View Alert</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doChangePassword">Change Password</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Welcome <%=username %></h4></div>
	<div style="width:70%;top:197px;height:50px;left:230px;position:absolute;<%=noFilesToDisplay%>"><h4 align="center">No files uploaded yet</h4></div>
	<div style="width:70%;top:250px;height:500px;left:230px;position:absolute">
		<table style="width:70%;top:260px;left:233px;position:absolute;<%=noTableToDisplay%>">
			<tr>
				<td style="border-style:solid">Filename</td><td style="border-style:solid">FileID</td><td style="border-style:solid">Size</td><td style="border-style:solid">Date Uploaded</td><td style="border-style:solid">Download</td>
			</tr>
			<%
				if(fileList != null){
					if(fileList.size() != 0){
						Iterator<File> iter = fileList.iterator();
						while(iter.hasNext()){
							File file = iter.next();	
						%>
						<tr>
							<td style="border-style:solid"><%=file.getFileName() %></td><td style="border-style:solid"><%=file.getFileId() %></td><td style="border-style:solid"><%=file.getFileSize() %> bytes</td><td style="border-style:solid"><%=file.getUploadDate() %></td><td style="border-style:solid"><a href="<%=request.getContextPath()%>/Dispatcher?pageid=userhome&actionid=doFileDownload&fileid=<%=file.getFileId()%>">Download</a></td>
						</tr>
						<%
						}
					}
				}
			%>
		</table>
	</div>
</body>
</html>
