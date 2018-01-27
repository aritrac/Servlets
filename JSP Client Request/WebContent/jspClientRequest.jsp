<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%--
	Cookie[] getCookies() : Returns an array containing all of the Cookie objects the client sent.
	
	Enumeration getAttributeNames() : Returns an Enumeration containing the names of the attributes for this request.
	
	Enumeration getHeaderNames() : Returns an enumeration of all the header names.
	
	Enumeration getParameterNames() : Returns an Enumeration of String objects containing the names of the parameters
	
	HttpSession getSession() : Returns the current session. If the request does not have a session, creates a new one and return.
	
	HttpSession getSession(boolean create) : Returns the current HttpSession or, if there is no current session and create is true, returns a new session.
	
	Locale getLocale() : Returns the preferred Locale for the client, based on the Accept-Language header
	
	Object getAttribute(String name) : Returns the value of the named attribute, or null if no attribute for the given name.
	
	ServletInputStream getInputStream() : Retrieves the body of the request as binary data using a ServletInputStream.
	
	String getAuthType() : Returns the name of the authentication scheme used to protect the servlet, for example, "BASIC" or "SSL," or null.
	
	String getCharacterEncoding() : Returns the name of the character encoding.
	
	String getContentType() : Returns the MIME type, or null if the type is not known.
	
	String getContextPath() : Returns the portion of the request URI that indicates the context of the request.
	
	String getHeader(String name) : Returns the value of the specified request header as a String.
	
	String getMethod() : Returns the name of the HTTP method, for example, GET, POST, or PUT.
	
	String getParameter(String name) : Returns the value of a request parameter as a String, or null if the parameter does not exist.
	
	String getPathInfo() : Returns path information associated with the URL the client sent.
	
	String getProtocol() : Returns the name and version of the protocol for the request.
	
	String getQueryString() : Returns the query string contained in the request URL after the path.
	
	String getRemoteAddr() : Returns IP address of the client.
	
	String getRemoteHost() : Returns the fully qualified name of the client.
	
	String getRemoteUser() : Returns the login of the user, or null if the user has not been authenticated.
	
	String getRequestURI() : Returns request's URL from the protocol name up to the query string.
	
	String getRequestedSessionId() : Returns the session ID

	String getServletPath() : Returns request's URL that calls the JSP.
	
	String[] getParameterValues(String name) : Returns String arrays containing all of the values the given request parameter has
	
	boolean isSecure() : Returns a boolean indicating if the request is from a secure channel, such as HTTPS.
	
	int getContentLength() : Returns the length, in bytes, of the request, or -1 if the length is not known.
	
	int getIntHeader(String name) : Returns the value of the specified request header as an int.
	
	int getServerPort() : Returns the port number on which this request was received. 
--%>

</body>
</html>