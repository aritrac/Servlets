<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%! int day = 3; %>
<%
	switch(day){
	case 0:
		out.println("It's Sunday");
		break;
	case 1:
		out.println("It's Monday");
		break;
	case 2:
		out.println("It's Tuesday");
		break;
	case 3:
		out.println("It's Wednesday");
		break;
	case 4:
		out.println("It's Thursday");
		break;
	case 5:
		out.println("It's Friday");
		break;
	default:
		out.println("It's Saturday");
	}
%>
</body>
</html>