<%@page import="com.fog.computing.pojo.Download"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.File"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		List<Download> entries = null;
		if(session.getAttribute("entries") != null){
			entries = (List<Download>)session.getAttribute("entries");
		}
	%>
	<title>User Home</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:50%;position:absolute;top:100px;height:80x;left:500px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=alert&actionid=doFileUpload">Upload File</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=alert&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=alert&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=alert&actionid=doChangePassword">Change Password</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=alert&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:250px;height:500px;left:230px;position:absolute">
		<table style="width:70%;top:260px;left:233px;position:absolute;">
			<tr>
				<td style="border-style:solid">FileId</td><td style="border-style:solid">Filename</td><td style="border-style:solid">UserId</td><td style="border-style:solid">Successful?</td><td style="border-style:solid">Download Time</td>
			</tr>
			<%
				if(entries != null){
					Iterator<Download> iter = entries.iterator();
					while(iter.hasNext()){
						Download download = iter.next();
			%>
			<tr>
				<td style="border-style:solid"><%=download.getFileID() %></td><td style="border-style:solid"><%=download.getFileName() %></td><td style="border-style:solid"><%=download.getUserId() %></td><td style="border-style:solid"><%=download.getIsSuccessful() %></td><td style="border-style:solid"><%=download.getDownloadTime() %></td>
			</tr>
			<%
					}
				}
			%>
			
		</table>
	</div>
</body>
</html>
