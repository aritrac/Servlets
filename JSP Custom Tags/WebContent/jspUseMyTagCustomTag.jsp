<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="ex" uri="WEB-INF/custom.tld" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Use MyTag custom tag</title>
</head>
<body>
	<!-- A custom tag without body support -->
	<br/>
	<ex:My/>
	
	<!-- A custom tag with body support -->
	
	<br/>
	<ex:MyWithBody>
		Let's print out this custom string
	</ex:MyWithBody>
	
	<!-- A custom tag with attribute support -->
	<br/>
	<ex:MyWithAttribute message="This is aritra sending a message!" attribute_name1="false"/>
</body>
</html>