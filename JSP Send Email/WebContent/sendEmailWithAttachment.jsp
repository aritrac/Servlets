<%@page import="javax.mail.Transport"%>
<%@page import="javax.activation.DataHandler"%>
<%@page import="javax.activation.FileDataSource"%>
<%@page import="javax.activation.DataSource"%>
<%@page import="javax.mail.internet.MimeMultipart"%>
<%@page import="javax.mail.Multipart"%>
<%@page import="javax.mail.internet.MimeBodyPart"%>
<%@page import="javax.mail.BodyPart"%>
<%@page import="javax.mail.Message"%>
<%@page import="javax.mail.internet.InternetAddress"%>
<%@page import="javax.mail.internet.MimeMessage"%>
<%@page import="javax.mail.MessagingException"%>
<%@page import="javax.mail.Session"%>
<%@page import="java.util.Properties"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
	String result;
	String to = "to@gmail.com";
	String from = "from@gmail.com";
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
		BodyPart messageBodyPart = new MimeBodyPart();
		messageBodyPart.setText("This is message body");
		Multipart multipart = new MimeMultipart();
		multipart.addBodyPart(messageBodyPart);
		messageBodyPart = new MimeBodyPart();
		String filename = "file.txt";
		DataSource source = new FileDataSource(filename);
		messageBodyPart.setDataHandler(new DataHandler(source));
		messageBodyPart.setFileName(filename);
		multipart.addBodyPart(messageBodyPart);
		message.setContent(multipart);
		Transport.send(message);
		String title = "Send Email";
		result = "Sent message successfully...";
	}catch(MessagingException mex){
		mex.printStackTrace();
		result =  "Error: unable to send message...";
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>send email with attachment</title>
</head>
<body>
	<%
		out.println("Result: " + result + "\n");
	%>
</body>
</html>