<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>This is the error page</title>
</head>
<body>
	<p>Here is the exception stack trace</p>
	<pre>
		<%exception.printStackTrace(response.getWriter()); %>
	</pre>
</body>
</html>