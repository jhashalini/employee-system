<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Employee Management</title>
</head>
<body>
	<center>
		<h3>Employee management System</h3>

		<form action="LoginServlet" method="post">

			Username <input type="text" name="username" /> </br> Password <input
				type="password" name="password"> </br> <input type="submit"
				value="Login" name="login">

		</form>
     </br>
     </br>
		Not a registered user ? <a href="registration.jsp">Click here</a>


	</center>




</body>
</html>