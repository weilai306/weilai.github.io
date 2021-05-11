<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>error</title>
</head>
<body>
	<%@page language="java" import="jluee.entity.User"%>
	<%!User user;%>
	<%
		user = (User) session.getAttribute("user");
	out.println(user.getStatus() + "<br>");
	%>
	<a href="login.jsp">返回</a>
</body>
</html>