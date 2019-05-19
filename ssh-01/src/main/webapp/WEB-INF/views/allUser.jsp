<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">

        .table1{

            border:1px solid #ddd;

            width:600px;
 			margin:0px auto;

        }

        thead{

            background-color:lightblue;

        }
    </style>
</head>
<body>
		<table cellspacing="0" border="1" class="table1">
			<thead>
			   <tr>
					<th width="150">id</th>
			        <th width="150">姓名</th>
			        <th width="150"></th>
			        <th width="150"></th>
			   </tr>
			</thead>
		
		<tbody>
		<c:forEach items="${page.content }" var="p">
		
		    <tr>
		
		        <td align="center">${p.id }</td>
		
		        <td align="center">${p.userName }</td>
		        <td align="center"><a href="${pageContext.request.contextPath}/user/delete?id=${p.id }" onclick='return confirm("确认要删除吗?")'>删除</a></td>
		        <td align="center">修改</td>
		
		    </tr>
		
		</c:forEach>
		
		</tbody>
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
</body>
</html>