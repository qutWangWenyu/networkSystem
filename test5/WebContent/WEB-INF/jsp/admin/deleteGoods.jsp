<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除房源</title>
</head>
<body>
  <form:form action="${pageContext.request.contextPath }/adminGoods/AddGoods" method="post" modelAttribute="goods" enctype="multipart/form-data">
    <table border=1 style="border-collapse:collapse">
      <caption><font size=4 face=华文新魏>删除房源</font></caption>
      <tr>
        <td>名称<font color="red">*</font></td>
        <td><form:input path="gname"/></td>
      </tr>
         <td>
          <form:delete path="goodstype_id">
            <form:options items="$GoodsType" itemLabel="typename" itemValue="id"/>
            </form:delete></td>
      </tr>
       <tr>
        <td><input type="submit" value="提交"></td>
        <td><input type="reset" value="重置"></td>
      </tr>
    </table>
  </form:form>
</body>
</html>