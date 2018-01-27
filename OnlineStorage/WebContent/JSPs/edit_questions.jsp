<%@page import="java.util.Iterator"%>
<%@page import="com.fog.computing.pojo.Question"%>
<%@page import="java.util.List"%>
<html>
<head></head>
<body style="background:E4D1D1">
	<!-- ALL JAVA CODE HERE -->
	<%
		List<Question> questions = null;
		if(session.getAttribute("questions") != null){
			questions = (List<Question>)session.getAttribute("questions");
		}
	%>
	<title>Registration</title>
	<div style="width:70%;top:0px;height:80px;left:230px;position:absolute"><h1 align="center">Fog Computing : Mitigating Insider Data Theft Attacks In the Cloud</h1></div>
	<table style="width:9%;position:absolute;top:100px;height:80x;left:1060px;text-align:right" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=editquestions&actionid=doBack">Go Back</a></th>
	<table>
	<div style="width:70%;top:140px;height:50px;left:230px;position:absolute;"><h3 align="center">Edit Questions Below</h4></div>
	<div style="width:70%;top:197px;height:50px;border-style:solid;left:230px;position:absolute;display:none"><h4 align="center">Some Message Abount Content Shown</h4></div>
	<div style="width:34%;top:250px;height:580px;left:470px;position:absolute">
	<form action="<%=request.getContextPath()%>/Dispatcher?pageid=editquestions&actionid=doUpdateQuestions" method="POST">
		<table style="width:40%;top:260px;left:473px;position:absolute">
			<% 
				Iterator<Question> iter = questions.iterator();
				int num = 1;
				while(iter.hasNext()){
					Question question = iter.next();
			%>
			<tr>
				<td>Question <%=num %></td>
				<td colspan="2"><input type="text" name="question<%=num %>" size="36" value="<%=question.getSecurityQuestion() %>" required/></td>	
			</tr>
			<%
				num++;
				}
			%>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="Update"></td>	
			</tr>
		</table>
		</form>
	</div>
</body>
</html>
