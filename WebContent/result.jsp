<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary Lookup System</title>
</head>
<body>

	<h1 align="center">Dictionary Lookup System</h1>
	<br />
	<h3 align = "center">Result From Dictionary</h3>
	<%
		String datapassed = (String) request.getAttribute("datapassed");
		String result = (String) request.getAttribute("result");

		out.print("Word: " + datapassed);
		out.print("<br/>");
		out.print("<br/>");
		out.print("Result: " + result);
	%>
	<br />
	<br />
	<p align="center">
		<a href="home.jsp" id="Home">Query Again</a>
	</p>
</body>
</html>