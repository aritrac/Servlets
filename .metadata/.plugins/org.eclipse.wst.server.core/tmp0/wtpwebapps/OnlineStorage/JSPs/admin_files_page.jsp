<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.File"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String showNoFiles = "";
		String showTable = "display:none";
		List<File> fileList = null;
		if(session.getAttribute("fileList") != null){
			fileList = (List<File>)session.getAttribute("fileList");
			if(fileList.size() != 0){
				showNoFiles = "display:none";
				showTable = "";
			}
		}
	%>
	<title>Admin Files</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:40%;position:absolute;top:100px;height:80x;left:635px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminfiles&actionid=doShowUsers">User Details</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminfiles&actionid=doEditQuestions">Edit Questions</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminfiles&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminfiles&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminfiles&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">File Uploaded By Users</h4></div>
	<div style="width:70%;top:197px;height:50px;border-style:solid;left:230px;position:absolute;<%=showNoFiles%>"><h4 align="center">No Files Uploaded So Far</h4></div>
	<div style="width:70%;top:250px;height:500px;left:230px;position:absolute;<%=showTable%>">
		<table style="width:70%;top:260px;left:233px;position:absolute">
			<tr>
				<td style="border-style:solid">Filename</td><td style="border-style:solid">FileID</td><td style="border-style:solid">UserID</td><td style="border-style:solid">FileSize (in bytes)</td><td style="border-style:solid">Upload Date</td>
			</tr>
			<%
				if(fileList != null){
					if(fileList.size() != 0){
						Iterator<File> iter = fileList.iterator();
						while(iter.hasNext()){
							File file = iter.next();
			%>
			<tr>
				<td style="border-style:solid"><%=file.getFileName() %></td><td style="border-style:solid"><%=file.getFileId() %></td><td style="border-style:solid"><%=file.getUserId() %></td><td style="border-style:solid"><%=file.getFileSize() %></td><td style="border-style:solid"><%=file.getUploadDate() %></td>
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
