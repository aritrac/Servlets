<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Core Tags</title>
</head>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<body>
	<!--
		Tag				Description
		c:out			for expressions.
		c:set			Sets the result of an expression evaluation
		c:remove		Removes a scoped variable from a particular scope, if specified.
		c:catch			Catches Throwable in its body and optionally exposes it.
		c:if			if statement.
		c:choose		Conditional tag for mutually exclusive conditional operations, marked by <when> and <otherwise>
		c:when			Work with <choose> to include its body if the condition is 'true'.
		c:otherwise		Together with <choose> to run if all prior conditions are 'false'.
		c:import		Retrieves a URL and exposes its contents to either the page, a String in 'var', or a Reader in 'varReader'.
		c:forEach		Iteration tag.
		c:forTokens		Iterates over tokens, separated by the supplied delimeters.
		c:param			Adds a parameter to a containing 'import' tag's URL.
		c:redirect 		Redirects to a new URL.
		c:url			Creates a URL with optional query parameters 
	 -->
	 <c:out value=""></c:out>
	 <c:set></c:set>
	 <c:remove var=""/>
	 <c:catch></c:catch>
	 <c:if test=""></c:if>
	 <c:choose></c:choose>
	 <c:when test=""></c:when>
	 <c:otherwise></c:otherwise>
	 <c:import url=""></c:import>
	 <c:forEach var="i" begin="1" end="5">
	 </c:forEach>
	 <c:forTokens items="" delims=""></c:forTokens>
	 <c:param name=""></c:param>
	 <c:redirect></c:redirect>
	 <c:url></c:url>
	 
	 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
	 
	 <!--
	 	Tag					Description
		fmt:formatNumber 	Format numerical value.
		fmt:parseNumber 	Parses the string to a number, currency, or percentage.
		fmt:formatDate  	Format a date/time
		fmt:parseDate 		Parses the string to create a date/time
		fmt:bundle 			Loads a resource bundle.
		fmt:setLocale 		Set the given locale.
		fmt:setBundle 		Loads a resource bundle
		fmt:timeZone 		Set the time zone for time formatting
		fmt:setTimeZone 	Stores the given time zone in the time zone configuration variable
		fmt:message 		To display an internationalized message.
		fmt:requestEncoding Sets the request character encoding 
	  -->
	  <fmt:formatNumber></fmt:formatNumber>
	  <fmt:parseNumber></fmt:parseNumber>
	  <fmt:formatDate value=""/>
	  <fmt:parseDate></fmt:parseDate>
	  <fmt:bundle basename=""></fmt:bundle>
	  <fmt:setLocale value=""/>
	  <fmt:setBundle basename=""/>
	  <fmt:timeZone value=""></fmt:timeZone>
	  <fmt:setTimeZone value=""/>
	  <fmt:message></fmt:message>
	  <fmt:requestEncoding/>
	  
	  <%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
	  
	  <!--
	  	 Tag				Description
		 sql:setDataSource	Creates a DataSource
		 sql:query			Executes the SQL query in its body or the sql attribute.
		 sql:update			Executes the SQL update in its body or the sql attribute.
		 sql:param			Sets a parameter in an SQL statement to the specified value.
		 sql:dateParam		Sets a parameter in an SQL statement to the specified java.util.Date value.
	     sql:transaction	Work with transaction.
	   -->
	   <sql:setDataSource/>
	   <sql:query var=""></sql:query>
	   <sql:update></sql:update>
	   <sql:param></sql:param>
	   <sql:dateParam value=""/>
	   <sql:transaction></sql:transaction>
	   
	   <%@ taglib prefix="x" uri="http://java.sun.com/jsp/jstl/xml" %>
	   
	   <!--
		 Tag				Description
		 x:out				for XPath expressions.
		 x:parse			Parse XML data in an attribute or in the tag body.
		 x:set				Sets value to a variable in an XPath expression.
		 x:if				if statement on a XPath expression
		 x:forEach 			To loop over nodes in an XML document.
		 x:choose			Conditional tag, and work with when and otherwise
		 x:when 			Work with choose for 'true' condition
		 x:otherwise  		Work with of choose for 'false' condition
		 x:transform 		Applies an XSL transformation on a XML document
		 x:param 			Work with the transform tag to set a parameter in the XSLT stylesheet. 
	    -->
	    
	    <x:out select=""/>
	    <x:parse xml="${bookInfo}" var="output"></x:parse>
	    <x:set var=""/>
	    <x:if select=""></x:if>
	    <x:forEach select=""></x:forEach>
	    <x:choose></x:choose>
	    <x:when select=""></x:when>
	    <x:otherwise></x:otherwise>
	    <x:transform xml="${xmltext}" xslt="${xslt}"></x:transform>
	    <x:param name=""></x:param>
	    
	    <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	    
	    <!--
	    	Function				Description
			fn:contains()			Tests if a string contains a substring.
			fn:containsIgnoreCase()	Tests if a string contains a substring in a case insensitive way.
			fn:endsWith()			Tests if an input string ends with the suffix.
			fn:escapeXml()			Escapes characters for XML markup.
			fn:indexOf()			Returns the index within a string of the first occurrence of a substring.
			fn:join()				Joins all elements of an array into a string.
			fn:length()				Returns the number of items in a collection, or the number of characters in a string.
			fn:replace()			Replace in an input string with a given string.
			fn:split()				Splits a string into an array of substrings.
			fn:startsWith()			If an input string starts with the prefix.
			fn:substring()			Returns a sub string.
			fn:substringAfter()		Returns a sub string following a specific substring.
			fn:substringBefore()	Returns a subset of a string before a specific substring.
			fn:toLowerCase()		Converts a string to lower case.
			fn:toUpperCase()		Converts a string to upper case.
			fn:trim()				Removes white spaces from both ends of a string. 
	     -->
	   <c:set var="string1" value="${fn:substring(string1, 5, 15)}" />
</body>
</html>