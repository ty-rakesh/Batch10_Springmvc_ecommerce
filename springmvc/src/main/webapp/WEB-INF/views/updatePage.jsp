<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	Integer id = (Integer) request.getAttribute("id");
	String msg = (String) request.getAttribute("msg");
%>
<%@ include file="header.jsp"%>
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
		<legend>Add Employee</legend>
		<form action="./update" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><%=id%></td>
					<td><input type="number" name="empId" value="<%=id%>"
						placeholder="Enter the ID" hidden="true"></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="name"
						placeholder="Enter the Name"></td>
				</tr>
				<tr>
					<td>Employee DOB</td>
					<td>:</td>
					<td><input type="date" name="birthDate"
						placeholder="Enter the DOB"></td>
				</tr>
				<tr>
					<td>Employee Password</td>
					<td>:</td>
					<td><input type="password" name="password"
						placeholder="Enter the password"></td>
				</tr>
				<tr>
					<td><input type="submit" value="update"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>