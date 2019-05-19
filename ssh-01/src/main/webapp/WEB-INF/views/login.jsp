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
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/user/login" method="post">
	用户名：<input type="text" name="userName"><br>
	密码：<input type="password" name="password"><br>
	<input type="submit" value="登录">
	</form>
	<button><a href="/Register.jsp">注册</a></button>
</body>
</html>