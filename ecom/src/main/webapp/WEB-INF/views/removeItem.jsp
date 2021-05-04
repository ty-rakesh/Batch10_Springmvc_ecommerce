<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <% String message = (String) request.getAttribute("message"); %>
    
    <jsp:include page="header.jsp"></jsp:include>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<% if(message != null) { %>
	
	<h2> <%=message %> </h2>
	
	<% } %>


	<fieldset>
		<legend>Add Employee</legend>
		<form action="./remove" method="post">
			<table>
				<tr>
					<td>Item ID</td>
					<td>:</td>
					<td><input type="number" name="id"
						placeholder="Enter the ID" required="required"></td>
				</tr>
		
				<tr>
					<td><input type="submit" value="Remove item"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>