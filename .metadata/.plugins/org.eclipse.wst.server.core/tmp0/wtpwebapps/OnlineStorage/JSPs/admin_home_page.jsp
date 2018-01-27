<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.User"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		String showNoUsers = "";
		String showTable = "display:none";
		List<User> userList = null;
		if(session.getAttribute("userList") != null){
			userList = (List<User>)session.getAttribute("userList");
			if(userList.size() != 0){
				showNoUsers = "display:none";
				showTable = "";
			}
		}
	%>
	<title>Admin Users</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:40%;position:absolute;top:100px;height:80x;left:635px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminhome&actionid=doShowUploads">Upload Details</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminhome&actionid=doEditQuestions">Edit Questions</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminhome&actionid=doShowAboutUs">About Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminhome&actionid=doShowContactUs">Contact Us</a></th>
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=adminhome&actionid=doSignout">Signout</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Welcome Admin</h4></div>
	<div style="width:70%;top:197px;height:50px;border-style:solid;left:230px;position:absolute;<%=showNoUsers%>"><h4 align="center">No Registered Users Found</h4></div>
	<div style="width:70%;top:250px;height:500px;left:230px;position:absolute;<%=showTable%>">
		<table style="width:70%;top:260px;left:233px;position:absolute">
			<tr>
				<td style="border-style:solid">Name</td><td style="border-style:solid">Email</td><td style="border-style:solid">Mobile</td><td style="border-style:solid">Address</td><td style="border-style:solid">Start HH</td><td style="border-style:solid">End HH</td>
			</tr>
			<%
				if(userList != null){
					if(userList.size() != 0){
						Iterator<User> iter = userList.iterator();
						while(iter.hasNext()){
							User user = iter.next();
			%>
			<tr>
				<td style="border-style:solid"><%=user.getUserName() %></td><td style="border-style:solid"><%=user.getEmailId() %></td><td style="border-style:solid"><%=user.getMobileNo() %></td><td style="border-style:solid"><%=user.getAddress() %></td><td style="border-style:solid"><%=user.getStartHH() %> Hr(s)</td><td style="border-style:solid"><%=user.getEndHH() %> Hr(s)</td>
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
