<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" width="300px">
		<tr>
		<th>编号</th>
		<th>账户名称</th>
		<th>账户金额</th>
		</tr>
		<c:forEach items="${list}" var="account" varStatus="vs">
		<tr>
		<td>${vs.count}</td>
		<td>${account.name }</td>
		<td>${account.money }</td>
		</tr>
		</c:forEach>
	</table>
</body>
</html>