<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Transport"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String result;
	String to = "aritrachatterjee2007@gmail.com";
	String from = "mailserver@gmail.com";
	String host = "localhost";
	Properties properties = System.getProperties();
	properties.setProperty("mail.smtp.host", host);
	//Add user credentials for mail server here
	properties.setProperty("mail.user", "myuser");
	properties.setProperty("mail.password", "mypwd");
	Session mailSession = Session.getDefaultInstance(properties);
	try{
		MimeMessage message = new MimeMessage(mailSession);
		message.setFrom(new InternetAddress(from));
		message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
		message.setSubject("This is the subject line!");
		message.setText("This is actual message");
		Transport.send(message);
		result = "Sent message successfully...";
	}catch(MessagingException mex){
		mex.printStackTrace();
		result = "Error : unable to send message...";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sending a plain email</title>
</head>
<body>
	<center>
	</center>
	<p align="center">
		<%
			out.println("Result: " + result + "\n");
		%>
	</p>
</body>
</html>