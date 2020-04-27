<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改商品</title>
<link href="css/admin/common.css" type="text/css" rel="stylesheet">
</head>
<body>
 <form:form action="${pageContext.request.contextPath }/adminGoods/updateAgood?id=${goods.id }" method="post" modelAttribute="goods" enctype="multipart/form-data">
    <table border=1 style="border-collapse:collapse">
      <caption><font size=4 face=华文新魏>添加商品</font></caption>
      <tr>
        <td>名称<font color="red">*</font></td>
        <td><form:input path="gname"/></td>
      </tr>
       <tr>
        <td>原价<font color="red">*</font></td>
        <td><form:input path="goprice"/></td>
      </tr>
       <tr>
        <td>折扣价<font color="red">*</font></td>
        <td><form:input path="grprice"/></td>
      </tr>
       <tr>
        <td>库存<font color="red">*</font></td>
        <td><form:input path="gstore"/></td>
      </tr>
       <tr>
        <td>图片<font color="red">*</font></td>
        <td><input type="file" name="logoImage"/></td>
      </tr>
       <tr>
        <td>类型<font color="red">*</font></td>
        <td>
          <form:select path="goodstype_id">
            <form:options items="${goodsType }" itemLabel="typename" itemValue="id"/>
          </form:select></td>
      </tr>
       <tr>
        <td><input type="submit" value="提交"></td>
        <td><input type="reset" value="重置"></td>
      </tr>
    </table>
    </form:form>
</body>
</html>