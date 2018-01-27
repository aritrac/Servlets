<%@ page language="java" contentType="text/html; charset=ISO-8859-1"	
    pageEncoding="ISO-8859-1"%>
<%@ include file="jspExpression.jsp" %>
<%--The above shows the types of JSP directives we can use --%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%--This is a JSP comment --%>
	<%--JSP Actions --%>
	<%--jsp:include : Includes a file --%>
	<%--jsp:useBean : Instantiates a JavaBean --%>
	<%--jsp:setProperty : Sets the property of a JavaBean --%>
	<%--jsp:getProperty : Inserts the property of a JavaBean into the output --%>
	<%--jsp:forward : Forwards the requester to a new page --%>
	<%--jsp:plugin : Generates browser-specific code that makes an OBJECT or EMBED tag for the Java plugin --%>
	<%--jsp:element : Defines XML elements. --%>
	<%--jsp:attribute : Defines XML element's attribute. --%>
	<%--jsp:body : Defines XML element's body. --%>
	<%--jsp:text : Write template text in JSP pages and documents. --%>
	
	<%--JSP Implicit Objects --%>
	<%--request : HttpServletRequest object associated with the request. Each time a client requests a page the JSP 
	engine creates a new object to represent that request. We can use the request object to get HTTP header information such as 
	form data, cookies, HTTP methods etc. --%>
	
	<%--response : HttpServletResponse object associated with the response to the client. JSP engine creates an object to represent the 
	response to the client. We can use this object to add new cookies or date stamps, HTTP status codes etc to the response. --%>
	
	<%--out : PrintWriter object used to send output to the client. We can use buffer in the output by using the buffered='false' 
	attribute of the page directive. out.print(dataType dt) prints a data type value. out.println(dataType dt) prints a data type 
	value then terminate the line with new line character. out.flush() flushes the stream. --%>
	
	<%--session : HttpSession object associated with the request. The session object tracks client session between client requests. --%>
	
	<%--application : ServletContext object associated with application context. This object reoresents the JSP page through the entire lifecycle. 
	It is created when the JSP page is initialized and will be removed when the JSP page is removed by the jspDestroy() method. --%>
	
	<%--config : ServletConfig object associated with the page. We can use this object to access the Servlet or JSP engine initialization parameters 
	such as the paths or file locations etc. config.getServletName() returns the servlet name , which is the string contained 
	in the <servlet-name> element defined in the WEB-INF\web.xml file. --%>
	
	<%--pageContext : The pageContext object is an instance of a javax.servlet.jsp.PageContext object, which is used to represent the 
	entire JSP page. This object contains informations about the request and response objects for each request. We can also get the directives 
	issued to the JSP page, including the buffering information, the errorPageURL, and page scope from this object. The PageContext class 
	defines fields, including PAGE_SCOPE, REQUEST_SCOPE, SESSION_SCOPE, and APPLICATION_SCOPE to identify the four scopes. --%>
	
	<%--page : It is a synonym for this, and is used to call the methods in translated servlet class. --%>
	
	<%--Exception : Used Exception object to access the exception data. --%>
</body>
</html>