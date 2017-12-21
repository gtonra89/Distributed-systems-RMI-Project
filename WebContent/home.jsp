<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.concurrent.ArrayBlockingQueue"%>
<%@page import="ClientSide.jobID"%>
<%@page import="java.util.concurrent.BlockingQueue"%>
<%@page import="java.util.Iterator"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary Lookup System</title>
</head>
<body>
	<H1>Dictionary Lookup</H1>
	<FORM ACTION="Servlet" METHOD="POST">
		Please enter your Word to Search: <INPUT TYPE="TEXT" NAME="text">
		<BR> <INPUT TYPE="SUBMIT" value="Search">
	</FORM>
</body>
</html>