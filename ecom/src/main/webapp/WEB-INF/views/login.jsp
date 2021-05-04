<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
	String message = (String) request.getAttribute("message");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<%     if (message != null && !message.isEmpty()) {      %>
	
	<h1>   <%= message %>   </h1>
	
	<%  }   %>


	<fieldset>
		<legend>Employee Login</legend>
		<form action="./login" method="post">
			<table>
				<tr>
					<td>Admin ID</td>
					<td>:</td>
					<td><input type="number" name="id"
						placeholder="Enter Admin ID"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"
						placeholder="Enter Admin password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>