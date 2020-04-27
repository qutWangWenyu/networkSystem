<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
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
		font-size:12px;
	}
	table tr td input[type=submit],table tr td input[type=reset]{width:137px;height:35px; background:url(images/btnbg.png) no-repeat; font-size:14px;font-weight:bold;color:#fff; cursor:pointer;}
	table tr td input[type=text]{width:345px; height:25px; line-height:25px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;text-indent:10px;}
	select{width:105px; height:25px; line-height:25px; border-top:solid 1px #a7b5bc; border-left:solid 1px #a7b5bc; border-right:solid 1px #ced9df; border-bottom:solid 1px #ced9df;text-indent:10px;}
	table tr td:first-child{padding-left:23px;line-height:25px; font-weight: bold;text-align: center;}
	table tr th{height:50px;}
	form{margin-left:20px;margin-top:20px;}
	input[type=submit]{width:60px;margin-left:20px;}
</style>
<script type="text/javascript">
	var tempName="";
		function changeColor(obj){
			tempName=obj.style.backgroundColor;
			//obj.className = "bgcolor";
			obj.style.backgroundColor="#F08080";
		}
		function changeColor1(obj){
			obj.style.backgroundColor=tempName;
		}
	</script>
</head>
<body>
<c:if test="${allTypes.size()==0 }">
   您没有类型
</c:if>
<c:if test="${allTypes.size()!=0 }">
  <table border="1" bordercolor="PaleGreen">
    <tr>
      <th width="200px">类型ID</th>
      <th width="600px">类型名称</th>
    </tr>
    <c:forEach items="${allTypes }" var="good">
      <tr onmouseover="changeColor(this)" onmouseout="changeColor1(this)">
        <td>${good.id }</td>
		<td>${good.typename }</td>
      </tr>
    </c:forEach>
  </table>
</c:if>
<form action="${pageContext.request.contextPath }/adminType/addType" method="post">
   类型名称：<input type="text" name="typename">
        <input type="submit" value="添加">
</form>
</body>
</html>