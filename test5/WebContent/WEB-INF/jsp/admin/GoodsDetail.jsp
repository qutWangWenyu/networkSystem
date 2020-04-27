<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品详情</title>
</head>
<body>
<table border="1" style="border-collapse:collapse">
  <caption><font size="4" face=华文新魏></font></caption>
  <tr>
    <td>名称</td>
    <td>${goods.gname }</td>
  </tr>
  <tr>
    <td>原价</td>
    <td>${goods.goprice }</td>
  </tr>
  <tr>
    <td>现价</td>
    <td>${goods.grprice }</td>
  </tr>
  <tr>
    <td>库存</td>
    <td>${goods.gstore }</td>
  </tr>
  <tr>
    <td>图片</td>
    <td><c:if test="${goods.gpicture!='' }"><img alt="" width="250" height="250" src="logos/${goods.gpicture }"</c:if></td>
  </tr>
  <tr>
    <td>类型</td>
    <td>${type.typename }</td>
  </tr>
</table>
</body>
</html>