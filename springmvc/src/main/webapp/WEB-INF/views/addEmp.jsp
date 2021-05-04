<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%
	String msg = (String) request.getAttribute("msg");
String errMsg = (String) request.getAttribute("errMsg");
%>
<jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Employee</title>
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
	<%
		if (errMsg != null && !errMsg.isEmpty()) {
	%>
	<h1 style="color: red;">
		<%=errMsg%></h1>
	<%
		}
	%>
	<fieldset>
		<legend>Add Employee</legend>
		<form action="./add" method="post">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="empId"
						placeholder="Enter the ID" required="required"></td>
				</tr>
				<tr>
					<td>Employee Name</td>
					<td>:</td>
					<td><input type="text" name="name"
						placeholder="Enter the Name" required="required"></td>
				</tr>
				<tr>
					<td>Employee DOB</td>
					<td>:</td>
					<td><input type="date" name="birthDate"
						placeholder="Enter the DOB" required="required"></td>
				</tr>
				<tr>
					<td>Employee Password</td>
					<td>:</td>
					<td><input type="password" name="password"
						placeholder="Enter the password" required="required"></td>
				</tr>
				<tr>
					<td><input type="submit" value="Add"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>