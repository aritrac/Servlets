<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Various methods of JSP Cookie object</title>
<!-- Cookies are text files stored on the client computer and are used to store information.

	 A JSP can access to the cookies through the request method request.getCookies() which returns an array of Cookie objects.

     The following table lists useful methods associated with Cookie object. -->
     
<!-- setDomain(String pattern) : sets the domain for cookie, for example java2s.com. -->
<!-- String getDomain() : gets the domain to which cookie applies. -->
<!-- setMaxAge(int seconds) : Sets how much time in seconds should elapse before the cookie expires. By default, the cookie will last for the current session. -->
<!-- getMaxAge() : Get cookie age in seconds. -1 indicating the cookie will persist until browser shutdown. -->
<!-- String getName() : returns the name of the cookie, which cannot be changed after creation. -->
<!-- setValue(String newValue) : sets the value associated with the cookie. -->
<!-- String getValue() : gets the value associated with the cookie. -->
<!-- setPath(String uri) : sets the path this cookie applies. By default, the cookie is returned for all URLs in the current directory and subdirectories. -->
<!-- String getPath() : gets the path to which this cookie applies. -->
<!-- setSecure(boolean flag) : sets to send cookie over encrypted (i.e. SSL) connections. -->
<!-- setComment(String purpose) : Sets a comment that describes a cookie's purpose. -->
<!-- String getComment() : get the comment for the cookie -->
</head>
<body>
	
</body>
</html>