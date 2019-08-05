<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Signup Page</title>

</head>
<body background="signup.jpg">
<center>
		<h1>Welcome to the Sign Up Page !!</h1>
		<h2>Please enter your details below</h2>
<form action="Registration" method="post">
	
	<table>
    <tr><td align="right">
	<h3>Username:<input type="text" name="username" placeholder="Enter Username" required> <br/></h3>
	<h3>First Name:<input type="text" name="firstname" placeholder="Enter First Name" required> <br/></h3>
	<h3>Last Name:<input type="text" name="lastname" placeholder="Enter Last Name" required> <br/></h3>
    <h3>Email ID:<input type="text" name="emailid" placeholder="Enter Email ID" required> <br/></h3>
   	</select>
   	
    <h3>Password:<input type="password" name="password" placeholder="Enter Password" required> <br/></h3>
    <h3>Confirm Password:<input type="password" name="pass2" placeholder="Enter Password" required> <br/></h3>
    <input type="submit" value="Sign Up"> 
    <br>
    <h3> Already a User?<a href="Login.jsp"> Login here.</a></h3>
    
   <h3 style="color: red;">
						 ${msg} 
					</h3>
    </td></tr>
                    	</table>
   
    </form>
     </center>
</body>
</html>