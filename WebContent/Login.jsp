<%@ page import = "java.io.*,java.util.*, javax.servlet.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
		<title>Login Page</title>
		
		<script> 
				history.forward();
		</script>
</head>
<body background="loginphoto.jpg">
	<% 
		out.println("<h1 align = \"center\"> Welcome to the Login Page!</b></h1>");
	%>
	<center>
    		<h1>Login Page</h1> <h2>Please enter your SignIn Details</h2> 
               
               <h3 style="color: red;">
			${LogoutMessage}
			</h3>
			
			<form action="LoginCheck" method="post"> <br/>
			
               		<table>
               			<tr><td align="right">
               					
               					<h3>Username:<input type="text" name="username" placeholder = "Enter Username"> <br/></h3>
               					<h3>Password:<input type="password" name="password" placeholder = "Enter Password"> <br/></h3>
              					<div class="field">
						
					</div><br><br>
              					<input type="submit" value="SUBMIT" "> 
               			
               			<h3 style="color: red;">
						 ${msg} 
					</h3>
					
					<br>
					
					<c:remove var="message" scope="session" />
                       	</td></tr>
                    	</table>
         	</form> 
         	
         	<h3> New User?<a href="Register.jsp"> Register here.</a></h3>
   	</center>

</body>
</html>