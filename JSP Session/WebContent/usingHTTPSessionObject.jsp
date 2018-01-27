<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<!--
	HTTP is a "stateless" protocol.

Each time a client uses a new connection to talk to the server and the server does not keep any record of previous request.

There are three ways to keep the records of client.

Cookies - When using cookie, server can assign a unique ID to each web client and recognize the client by using that ID.

Hidden Form Fields - Server can send a hidden HTML form field along with a unique session ID. When the form is submitted, the specified name and value are automatically included in the GET or POST data.

URL Rewriting - We can append client ID to the end of URL to identify the user. For example, with http://java2s.com/abc/index.htm;sessionid=123. URL rewriting works for the browsers when they don't support cookies.

JSP uses HttpSession to work with session data.

By default, JSPs have session enabled and a new HttpSession object is created for each new client.

In JSP page we can use the HttpSession object with the implicit session object


Method											Description
Object getAttribute(String name)				returns the object bound with the specified name in session, or null.
Enumeration getAttributeNames()					returns an Enumeration of String objects for the names of all the objects in session.
long getCreationTime()							returns the session creation time in milliseconds since midnight January 1, 1970 GMT.
String getId()									returns a string containing the unique identifier for this session.
long getLastAccessedTime()						returns the last time the client sent a request associated with this session, as the number of milliseconds since midnight January 1, 1970 GMT.
int getMaxInactiveInterval()					returns the maximum time interval, in seconds, that the servlet container will keep this session open between client accesses.
void invalidate()								invalidates this session.
boolean isNew()									returns true if the session is new to the client.
removeAttribute(String name)					removes the object by name from the session.
void setAttribute(String name, Object value)	binds an object to session by name
void setMaxInactiveInterval(int interval)		Sets the time, in seconds, between client requests before the servlet container will invalidate this session.
 -->
 
<%
	Date createTime = new Date(session.getCreationTime());
	Date lastAccessTime = new Date(session.getLastAccessedTime());
		
	String title = "Welcome Back";
	Integer visitCount = new Integer(0);
	String visitCountKey = "visitCount";
	String userIDKey = new String("userID");
	String userID = new String("Java2s_ID");
	
	if(session.isNew()){
		title = "Welcome";
		session.setAttribute(userIDKey, userID);
		session.setAttribute(visitCountKey, visitCount);
	}
	
	visitCount = (Integer)session.getAttribute(visitCountKey);
	visitCount = visitCount + 1;
	userID = (String)session.getAttribute(userIDKey);
	session.setAttribute(visitCountKey, visitCount);
%>

id: <%out.print(session.getId()); %> <br/>
Creation Time: <%out.print(createTime); %><br/>
Time of Last Access: <%out.print(lastAccessTime); %><br/>
User ID: <%out.print(userID); %><br/>
Number of visits: <%out.print(visitCount); %><br/>
</body>
</html>

