<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Download</title>
</head>
<body>
	<div
		style="width: 70%; top: 0px; height: 80px; left: 230px; position: absolute">
		<h1 align="center">Fog Computing : Mitigating Insider Data Theft
			Attacks In the Cloud</h1>
	</div>
	<table style="width:50%;position:absolute;top:100px;height:80x;left:500px;text-align:right;" align="center">
		<th><a href="<%=request.getContextPath()%>/Dispatcher?pageid=filedownload&actionid=doShow">Go Back</a></th>
	<table>
	<div style="width:34%;top:250px;height:200px;left:470px;position:absolute">
	<form action="<%=request.getContextPath()%>/Dispatcher?pageid=filedownload&actionid=doFileDownload" method="POST">
		<table style="width:40%;top:150px;left:450px;position:absolute">
			<tr>
				<td>Unique Code</td>
				<td colspan="2"><input type="password" name="unique_code" size="36" required/></td>	
			</tr>
			<tr>
				<td colspan="3" align="center"><input type="submit" value="Download File"></td>	
			</tr>
		</table>
		</form>
	</div>
</body>
</html>