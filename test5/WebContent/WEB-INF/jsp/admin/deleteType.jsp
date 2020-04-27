<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除类型</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
<style type="text/css">
table {
	text-align: center;
	border-collapse: collapse;
}

.bgcolor {
	background-color: #F08080;
}
</style>
</head>
<body>
	<c:if test="${allTypes.size()==0 }">您还没有类型</c:if>
	<c:if test="${allTypes.size()!=0 }">
		<table border="1" bordercolor="PaleGreen">
			<tr>
				<th width="200px">类型ID</th>
				<th width="600px">类型名称</th>
				<th width="200px">删除操作</th>
			</tr>
			<c:forEach items="${allTypes }" var="goodsType">
				<tr>
					<td>${goodsType.id }</td>
					<td>${goodsType.typename }</td>
					<td><a href="${pageContext.request.contextPath }/deleteType?id=${goodsType.id }">删除</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>