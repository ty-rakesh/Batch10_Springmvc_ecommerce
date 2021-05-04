<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		if (msg != null && !msg.isEmpty()) {
	%>
	<h1>
		<%=msg%></h1>
	<%
		}
	%>

	<fieldset>
		<legend>Employee Login</legend>
		<form action="./empLogin" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId"
						placeholder="Enter Employee ID"></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password"
						placeholder="Enter Employee password"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>