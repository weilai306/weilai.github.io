<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<head>
<title>main</title>
</head>
<body>
	<%@page language="java" import="jluee.entity.User" %>
	<%!User user;%>
	<%
		user = (User) session.getAttribute("user");
	out.println("用户名:" + user.getUserName() + "<br>");
	out.println("用户身份:" + user.getIdendity() + "<br>");
	%>
</body>
</html>