<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>deleteSelectGoods.html</title>
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
	<script type="text/javascript" >
  		function confirmDelete(){
  			var elements=document.getElementsByName("ids");
  			var s="";
  			for(var i=0;i<elements.length;i++)
  			{
  			    if(elements[i].checked==true||elements[i].checked=="checked")
  			    {
  			    	s += elements[i].value+''/'';
  			   	}
  			}
  			window.location.href = "/test5/adminGoods/deleteManyGoods?ids="+s;
  		}
  		function checkDel(id){
  			if(window.confirm("是否删除该商品？")){
  				window.location.href = "/test5/adminGoods/deleteAGoods?id="+id;
  			}
  		}
  </script>
  <style type="text/css">
	table{
		border-color:green;
		margin-left:20px;
		margin-top:20px;
		width:600px;
	}
	table tr td{
		padding:10px 5px;
		font-size: 12px;	
	}
	table tr:nth-child(odd){
		background-color: #eee;
	}
	table tr td input[type=submit],table tr td input[type=reset]{width:137px;height:35px; background:url(images/btnbg.png) no-repeat; font-size:14px;font-weight:bold;color:#fff; cursor:pointer;}
	table tr td input[type=text]{width:345px; height:25px; line-height:25px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;text-indent:10px;}
	select{width:105px; height:25px; line-height:25px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;text-indent:10px;}
	table tr td:first-child{padding-left:23px;line-height:25px; font-weight: bold;text-align: center;}
</style>
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
      <td><input type="checkbox" name="ids" value="${goods.id }"/>${goods.id }</td>
      <td>${goods.gname }</td>
      <td>${goods.grprice }</td>
      <td>${goods.gstore }</td>
      <td><a href="${pageContext.request.contextPath }/adminGoods/selectAGoods?id=${goods.id }" target="_blank">详情</a></td>
      <td><a href="${pageContext.request.contextPath }/adminGoods/deleteAGoods?id=${goods.id }" target="_blank">删除</a></td>
    </tr>
  </c:forEach>
  <tr>
	  <td colspan="6">
		  <input type="button" value="删除" onclick="confirmDelete()">
	  </td>
	</tr>
  <tr>
     <td colspan="6" align="right">
       &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;共${totalCount }条记录；共${totalPage }页&nbsp;&nbsp;第${pageCur }页&nbsp;&nbsp;
    <c:if test="${pageCur !=1 }">
      <a href="${pageContext.request.contextPath }/adminGoods/changeDeleteAGoods?pageCur=${pageCur-1 }">上一页</a>&nbsp;&nbsp;&nbsp;&nbsp;
    </c:if>
    <c:if test="${pageCur !=totalPage&&totalPage !=0 }">
      <a href="${pageContext.request.contextPath }/adminGoods/changeDeleteAGoods?pageCur=${pageCur+1 }">下一页</a>
    </c:if>
     </td>
  </tr>
 </table>
</c:if>
</body>
</html>