<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dictionary Lookup System</title>
</head>
<body>
	<td>
		<h1 align="center">Dictionary Service</h1> <br />
		<h3>Response:</h3> <%
 	String datapassed = (String) request.getAttribute("datapassed");
 	String result = (String) request.getAttribute("result");

 	if (result == null) {
 		out.print("no input entered  "
 				+ "\n please enter a word  to compare by clciking make another query below");
 	} else {
 		out.print("Word: " + datapassed);

 		out.print("Result: " + result);
 	}
 %> <br /> <br />
		<p align="center">
			<a href="home.jsp" id="Home">Make another Query</a>
		</p>
	</td>
</body>
</html>