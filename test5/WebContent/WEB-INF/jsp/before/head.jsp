<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<script type="text/javascript" src="js/shoppingCart.js"></script>
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
<link href="/css/before/daohang.css" rel="stylesheet" type="text/css" />
<link href="/css/before/common.css" rel="stylesheet" type="text/css" />
<link href="/css/before/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function clearValue(){
	}
</script>
</head>
<body>
	<div class="all_zong">
		<!--最上面 灰色条部分-->
		<div class="all_zong_top">
			<div class="all_zong_top_right a8c">
				<table border="0" cellspacing="0" cellpadding="0" class="main_login">
					<tr>
						<td>
							<p id="content">
								<%-- <a href="<%=basePath%>/user/toLogin" target="_top">登录</a> --%>
								<c:if test="${bruser!=null}">欢迎 ${bruser.bemail }</c:if>
								<c:if test="${bruser==null}"><a href="<%=basePath%>/user/toLogin">登录</a></c:if>
							</p>
						</td>
						<td>
							<p>
								<a href="<%=basePath%>/toRegister" target="_top">注册</a>
							</p>
						</td>
						<td>
							<span class="xx">|</span>
							<a href="<%=basePath%>userCenter" target="_top">用户中心</a>
							<span class="xx">|</span>
						</td>
						<!-- 没有登录 -->
						<td>
							<a href="login.html" target="_top">退出</a>
							<span class="xx">|</span>
						</td>
					</tr>
				</table>
			</div>
		</div>
		<!--end-->
		<!--logo 搜索-->
		<div class="all_zong_logo">
			<div class="all_zong_logo2">
				<img src="images/before/mylogo.png" />
			</div>
			<div class="back_search">
				<div class="back_search_red">
					<form action="<%=basePath%>/search" name="myForm" method="post">
						<div class="div2">
							<input type="text" name="mykey" class="txt" value="请输入您要查询的内容"  onfocus="clearValue()" />
						</div>
						<div class="div1">
							<input type="submit" class="an"  value="搜索" />
						</div>
					</form>
				</div>
			</div>
			<!--end-->
		</div>
		<!--红色 导航-->
		<div class="skin_a">
			<div class="front_daohangbj">
				<div class="all_zong">
					<div class="front_daohang">
						<ul>
							<li class="backbj"><a href="before?id=0" target="_top">首页</a></li>
							<!-- 显示商品类型 -->
							<c:forEach var="n" items="${goodsType }">
							<li><a href="" target="_top">${n.typename }</a></li>
							</c:forEach>
							
							<li class="buy">
								<p class="car">
									<a href="select/putCart" target="_top">购物车</a>
								</p>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<!--红色 导航 end-->
	</div>
</body>
</html>