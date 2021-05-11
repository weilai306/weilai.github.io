<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<!--base href="<%=basePath%>"-->
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
</head>
<body>

	<form action="login" method="post">
  	  <table align="center" width=40%>
  	 	<tr><td height=200></td></tr>
    	<tr><td>用户名:<input type="text" name="uname" ></input>${msg}</td></tr>
    	<tr><td>密&nbsp;码: <input type="password" name="pwd" ></input></td></tr>
    	<tr><td><input type="submit" value="提交" ></input>&nbsp;&nbsp;</td></tr>     
    </table>

	</form>
</body>
</html>