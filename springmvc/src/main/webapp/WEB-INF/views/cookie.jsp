<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	String msg = (String) request.getAttribute("msg");
    	String cookie = (String) request.getAttribute("cookieValue");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
if(msg!=null && !msg.isEmpty()){
 %>
 <h2><%=msg %></h2>
 <%
}
 %>
<%
if(cookie!=null && !cookie.isEmpty()){
%>
<h2 style="color: green;">the cookie value is <%=cookie %></h2>
<%
}
%>
<h1>
<a href="./createcookie">Create cookie</a>
</h1>
<h1>
<a href="./showcookie">Show cookie</a>
</h1>
</body>


</html>