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
<title>JNDI操作</title>
</head>
<body>
<form name="demo" id="demo" method="post">
  	  <table align="center" width=40%>
  	 	<tr><td height=50></td></tr>
    	<tr><td>绑定名字:<input type="text" name="bind_name" ></input></td></tr>
    	<tr><td>绑定值: &nbsp;&nbsp;&nbsp;<input type="password" name="bind_value" ></input></td></tr>
    	<tr><td>
    	<input type="button" value="绑定" onclick="bindAction()"></input>&nbsp;&nbsp;
    	<input type="button" value="查询"  onclick="lookupAction()">&nbsp;&nbsp;
    	<input type="button" value="重新绑定" onclick="rebindAction()"></input>&nbsp;&nbsp;
    	<input type="button" value="取消绑定" onclick="unbindAction()"></input ></td></tr>
    </table>
</form>

<script type="text/javascript">
 function bindAction(){
     document.demo.action="<%=basePath%>bind";
     document.demo.submit();
 }
  
 function lookupAction(){
     document.demo.action="<%=basePath%>lookup";
     document.demo.submit();
 }
  
 function rebindAction(){
     document.demo.action="<%=basePath%>rebind";
     document.demo.submit();
 }
  
 function unbindAction(){
    document.demo.action="<%=basePath%>unbind";
     document.demo.submit();
 }
  </script>
</body>
</html>