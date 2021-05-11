<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Login</title>
</head>
<body>
	<form action="/MyProject/LoginServlet" method="post">
		用户名:<input type="text" name="userName"><br> 
		密 码:<input type="password" name="passWord"><br> 
		<input type="submit" value="提交" name="login">
	</form>
</body>
</html>