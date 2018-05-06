<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>User Registration Page</title>
</head>
<body>
	<center>
		<h3>User Registration Page</h3>

		<form action="RegistrationServlet" method="post">


			Username <input type="text" name="username" /> </br> Name <input
				type="text" name="name" /> </br> Password <input type="password"
				name="password"> </br> E-mail : <input type="text" name="email" />
			</br> Phone : <input type="text" name="phone" /> </br> Gender <select
				name="gender">
				<option value="male">Male</option>
				<option value="female">Female</option>
				<option value="Chakka">Chakka</option>
			</select> </br> </br> <input type="submit" value="Register" name="regitser">
		</form>
</br>
</br>
		Already a registered user ? <a href="index.jsp">Login </a>



		<%
			String msg = "";
			boolean isFailed = false;
			String status = request.getParameter("status");
			if (status != null) {
				if (status.equals("success")) {
					msg = "Registration is sucessful";
				} else {
					isFailed = true;
					msg = "Registration failed due to server error. Please try again after sometime.";
				}
			}
		%>


		<%
			if (!isFailed) {
		%>
		<p>
			<font color="green"> <%=msg%></font>
		</p>
		<%
			} else {
		%>
		<p>
			<font color="red"><%=msg%></font>
		</p>

		<%
			}
		%>

	</center>

</body>
</html>