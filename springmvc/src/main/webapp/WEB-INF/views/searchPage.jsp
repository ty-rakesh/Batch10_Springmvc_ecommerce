<%@page import="java.util.List"%>
<%@page import="com.te.springmvc.beans.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
	EmployeeInfoBean infoBean = (EmployeeInfoBean) request.getAttribute("data");
String msg = (String) request.getAttribute("msg");
List<EmployeeInfoBean> infoBeans = (List) request.getAttribute("infobeans");
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
		<legend>Search</legend>
		<form action="./search" method="get">
			<table>
				<tr>
					<td>Employee ID</td>
					<td>:</td>
					<td><input type="number" name="id" placeholder="Enter the ID"></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"></td>
				</tr>
			</table>
		</form>
	</fieldset>

	<%
		if (infoBean != null) {
	%>
	<h1>
		Name :
		<%=infoBean.getName()%></h1>
	<h1>
		ID :
		<%=infoBean.getEmpId()%></h1>
	<h1>
		BirthDate :
		<%=infoBean.getBirthDate()%></h1>
	<%
		}
	%>

	<%
		if (infoBeans != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DOB</th>
		</tr>
		<%
			for (EmployeeInfoBean bean : infoBeans) {
		%>
		<tr>
			<td><%=bean.getEmpId()%></td>
			<td><%=bean.getName()%></td>
			<td><%=bean.getBirthDate()%></td>
		</tr>

	</table>

	<%
		}
	}
	%>
</body>
</html>