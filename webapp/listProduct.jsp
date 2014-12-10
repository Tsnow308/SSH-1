<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet"
	media="screen">
<link href="bootstrap/css/1.css" rel="stylesheet">
<link href="bootstrap/css/2.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<style type="text/css">
	.word{float:right}
</style>
<title>欢迎光临！</title>
</head>
<body background="img/e.jpg">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<div class="page-header">
					<h1>
						本店出售以下商品 <small class = "word"><c:if test="${User != null}">
								<p >${User.name}&nbsp！欢迎光临！</p>
								<div class = "word">
									<a href="/Shop/login.jsp" style="color:#4F9D9D; font-size: 12px;">注销</a>
									<a href="temp.action" style="color: #4F9D9D; font-size: 12px;">退出</a>
								</div>
							</c:if>	<c:if test="${User == null}">
						<a href="/Shop/login.jsp" style="color: #993366">点击登录</a>
				</c:if></small>
					</h1>
				</div>
				<table class="table">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>商品价格</th>
							<th>添加购物车</th>
						</tr>

					</thead>
					<tbody>
						<c:forEach items="${products}" var="product">
							<tr class="info">
								<td>${product.name}</td>
								<td>￥${product.price }</td>
								<td><a
									href="/Shop/shopCart!addToCart.action?product.id=${product.id}&product.name=${product.name}
												&product.price=${product.price}">添加到购物车</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div align=center>	<a href="/Shop/show.jsp">查看购物车</a> <br> <a
					href="/Shop/cart.jsp">结账</a> <br>
			</div>
			
			</div>
		</div>
	</div>
</body>
</html>