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
		String encodeRedirectURL(String url) : Encodes the URL in the sendRedirect method or, if encoding is not needed, returns the URL unchanged.
		
		String encodeURL(String url) : Encodes the URL by including the session ID, or, if encoding is not needed, returns the URL unchanged.
		
		boolean containsHeader(String name) : Returns a boolean indicating whether the named header has been set.
		
		boolean isCommitted() : Returns a boolean indicating if the response has been committed.
		
		void addCookie(Cookie cookie) : Adds the cookie to the response.
		
		void addDateHeader(String name, long date) : Adds a response header with the given name and date-value.
		
		void addHeader(String name, String value) : Adds a response header with the given name and value.
		
		void addIntHeader(String name, int value) : Adds a response header with the given name and integer value.
		
		void flushBuffer() : Forces content in the buffer to output to the client.
		
		void reset() : Clears data in the buffer, the status code and headers.
		
		void resetBuffer() : Clears the buffer content in the response without clearing headers or status code.
		
		void sendError(int sc) : Sends an error response to the client with the specified status code and clear the buffer.
		
		void sendError(int sc, String msg) : Sends an error response to the client using the specified status.
		
		void sendRedirect(String location) : Sends a temporary redirect response to the client using the specified redirect location URL.
		
		void setBufferSize(int size) : Sets the preferred buffer size for the response body.
		
		void setCharacterEncoding(String charset) : Sets the character encoding of the response, for example, to UTF-8.
		
		void setContentLength(int len) : Sets the length of the content body in the response(HTTP Content-Length header).
		
		void setContentType(String type) : Sets the content type of the response, if the response has not been committed yet.
		
		void setDateHeader(String name, long date) : Sets a response header with the given name and date-value.
		
		void setHeader(String name, String value) : Sets a response header with the given name and value.
		
		void setIntHeader(String name, int value) : Sets a response header with the given name and integer value.
		
		void setLocale(Locale loc) : Sets the locale of the response, if the response has not been committed yet.
		
		void setStatus(int sc) : Sets the status code for this response.
	 --%>
</body>
</html>