<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>房源详情</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
	<style type="text/css">
		table{
			text-align: center;
			border-collapse: collapse;
		}
		.bgcolor{
		  	background-color: #F08080;
		}
	</style>
	<script type="text/javascript">
		function changeColor(obj){
			obj.className = "bgcolor";
		}
		function changeColor1(obj){
			obj.className = "";
		}
	</script>
</head>
</head>
<body>
<c:if test="${allGoods.size()==0 }">您还没有商品</c:if>
<c:if test="${allGoods.size()!=0 }">
 <table border="1" bordercolor="PaleGreen">
  <tr>
    <th width="100px">ID</th>
    <th width="200px">名称</th>
    <th width="200px">价格</th>
    <th width="100px">库存</th>
    <th width="200px">详情</th>
    <th width="200px">操作</th>
  </tr>
  <c:forEach items="${allGoods }" var="goods">
    <tr>
      <td>${goods.id }</td>
      <td>${goods.gname }</td>
      <td>${goods.grprice }</td>
      <td>${goods.gstore }</td>
      <td><a href="${pageContext.request.contextPath }/adminGoods/selectAGoods?id=${goods.id }" target="center">详情</a></td>
      <td><a href="${pageContext.request.contextPath }/adminGoods/updateAGoods?id=${goods.id }" target="center">修改</a></td>
    </tr>
  </c:forEach>
  <tr>
     <td colspan="5" align="right">
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共${totalCount }条记录；共${totalPage }页&nbsp;&nbsp;第${pageCur }页&nbsp;&nbsp;
    <c:if test="${pageCur !=1 }">
      <a href="${pageContext.request.contextPath }/admin/changeSelectGoods?pageCur=${pageCur-1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageCur !=totalPage&&totalPage !=0 }">
      <a href="${pageContext.request.contextPath }/admin/changeSelectGoods?pageCur=${pageCur+1 }">下一页</a>
    </c:if>
     </td>
  </tr>
 </table>
</c:if>
</body>
</html>