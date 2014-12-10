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
<script type="text/javascript">
	$(function() {
		$("#backBtn").click(function() {
			window.location.href = 'index.jsp'
		});
		$("#cartBtn").click(function() {
			window.location.href = "/Shop/cart.jsp"
		});
		$("#clearBtn").click(function() {
			$.ajax({
				type : "POST",
				url : "/Shop/json/shopJson!clear.action",
				dataType : "json",
				success : function(msg) {
					if (msg.flag == 1) {
						window.location.href = "/Shop/show.jsp"
					} else {
						alert("内部异常，修改失败");
					}
				}
			});
		});
		$("#delBtn").click(function() {
			var datas = "";
			$("input:checked").each(function() {
				datas = datas + "ids=" + $(this).val() + "&";
			});
			$.ajax({
				type : "POST",
				url : "/Shop/json/shopJson!delItem.action",
				data : datas,
				dataType : "json",
				success : function(msg) {
					if (msg.flag == 1) {
						window.location.href = "/Shop/show.jsp"
					} else {
						alert("内部异常，清空失败");
					}
				}
			});
		});
		$("#modifyBtn").click(function() {
			var datas = "";
			$("input:checked").each(function() {
				var id = $(this).val()
				datas = datas + "infos=" + id + ":" + $("#" + id).val() + "&";

			});
			$.ajax({
				type : "POST",
				url : "/Shop/json/shopJson!modifyItem.action",
				data : datas,
				dataType : "json",
				success : function(msg) {
					if (msg.flag == 1) {
						window.location.href = "/Shop/show.jsp"
					} else {
						alert("内部异常，清空失败");
					}
				}
			});
		});
	})
</script>
<title>查看购物车</title>
</head>
<body background="img/e.jpg">
	<div class="container-fluid">
		<div class="row-fluid">
			<div class="span12">
				<h3>Dear，${User.name}！你选购的宝贝如下： <small class = "word"><c:if test="${User != null}">
								<p >${User.name}&nbsp！欢迎光临！</p>
								<div class = "word">
									<a href="/Shop/login.jsp" style="color:#4F9D9D; font-size: 12px;">注销</a>
									<a href="temp.action" style="color: #4F9D9D; font-size: 12px;">退出</a>
								</div>
							</c:if></small></h3>
				<table class="table">
					<thead>
						<tr>
							<th>选择</th>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>合计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Car.items}" var="item">
							<tr class="error">
								<td><input type="checkbox" value="${item.product.id}"
									class="delClass" /></td>
								<td>${item.product.name }</td>
								<td>${item.product.price }</td>
								<td><input type="text" value="${item.amount}"
									id="${item.product.id}" /></td>
								<td><input type="text"
									value="${item.amount * item.product.price }" /></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<div align ="right"><p style="color:	#2828FF; font-size: 19px;">总金额 : ${Car.totalPrice }</p></div>
				<div align="center">
					<input type="button"  class="btn" value="修改数量" id="modifyBtn" /> <input
						type="button" class="btn"  value="删除所选项" id="delBtn" /> <input type="button" class="btn"
						value="清空购物车" id="clearBtn" /> <input type="button"  class="btn" value="结账"
						id="cartBtn" /> <input type="button"  class="btn" value="继续购物" id="backBtn" />
				</div>
			</div>
		</div>
	</div>
</body>
</html>