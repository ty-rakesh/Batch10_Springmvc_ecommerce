<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
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
		<legend>Delete</legend>
		<form action="./deleteEmp">
			<label>Employee ID : </label> <input type="number" name="empId"
				required="required" placeholder="Enter Employee ID"> <br>
			<hr>
			<input type="submit" value="Delete">
		</form>
	</fieldset>
</body>
</html>