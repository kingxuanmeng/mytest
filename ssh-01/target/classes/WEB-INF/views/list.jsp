<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${page == null || page.numberOfElements == 0 }">
        <h3>没有员工记录！</h3>
    </c:if>
    
    <c:if test="${page != null && page.numberOfElements > 0 }">
    
        <table border="1" cellspacing="0" cellpadding="10">
        
            <tr>
                <th>Id</th>
                <th>用户名</th>
                
                <th>密码</th>
               
            </tr>
            
            <c:forEach items="${page.content }" var="emp">
                
                <tr>
                    <td>${emp.id }</td>
                    <td>${emp.userName }</td>
                    
                    <td>${emp.password }</td>
                    
                    <td>
                        <a href="${pageContext.request.contextPath }/emp/${emp.id}">Edit</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath }/emp/${emp.id}" class="delete">Delete</a>
                        <input type="hidden" value="${emp.userName }">
                    </td>
                </tr>
                
            </c:forEach>
            
            <tr>
                <td colspan="8">
                    共 ${page.totalElements} 条记录  &nbsp;&nbsp;&nbsp;
                    共 ${page.totalPages} 页  &nbsp;&nbsp;&nbsp;
                    当前为 ${page.number + 1 } 页  &nbsp;&nbsp;&nbsp;
                    
                    <c:if test="${page.number + 1 > 1 }">
                        <a href="?pageNo=${page.number + 1 - 1 }">上一页</a>  &nbsp;&nbsp;&nbsp;
                    </c:if>
                    
                    <c:if test="${page.number + 1 < page.totalPages}">
                        <a href="?pageNo=${page.number + 1 + 1 }">下一页</a>  &nbsp;&nbsp;&nbsp;
                    </c:if>
                </td>
            </tr>
                        
        </table>
        
    </c:if>
</body>
</html>