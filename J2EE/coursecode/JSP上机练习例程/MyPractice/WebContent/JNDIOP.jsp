<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JNDI操作结果</title>
</head>
<body>
	操作结果:${msg} &nbsp;&nbsp;${find_name} ${find_value}
	<a href="<%=basePath%>JNDIOPinterface.jsp">返回</a>
</body>
</html>