<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title> Welcome Page</title>
<script> 
				history.forward();
		</script>
</head>
<body background="cust2.jpeg">

<%
if (session.getAttribute("username") == null){
	request.setAttribute("msg", "Session has ended.  Please login.");
	response.sendRedirect("Login.jsp");
	
}
%>
<center>
<br><br><br>
<h1 align = "center"> Welcome Supplier </h1>
<% 
Date date = new Date();
out.println( "<h2 align = \"center\">" +date.toString()+"</h2>");
%>

<a href="LogoutSession">Logout</a>



</center>
</body>
</html>