<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="bootstrap/css/1.css" rel="stylesheet">
    <link href="bootstrap/css/2.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <style type="text/css">
	.word{float:right}
</style>
<title>结账</title>
</head>
<body background="img/e.jpg">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span12">
			<h3>
				Dear，${User.name}！你所购买的商品如下： <small class = "word"><c:if test="${User != null}">
								<p >${User.name}&nbsp！欢迎光临！</p>
								<div class = "word">
									<a href="/Shop/login.jsp" style="color:#4F9D9D; font-size: 12px;">注销</a>
									<a href="temp.action" style="color: #4F9D9D; font-size: 12px;">退出</a>
								</div>
							</c:if></small>
			</h3>
				<table class="table">
					<thead>
						<tr>
							<th>商品名称</th>
							<th>单价</th>
							<th>数量</th>
							<th>合计</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${Car.items}" var="item">
						<tr  class="success">
						<td width="25%" height=30>${item.product.name }</td>
						<td width="25%" height=30>${item.product.price }</td>
						<td width="25%" height=30>${item.amount}</td>
						<td width="25%" height=30>${item.amount * item.product.price }</td>
					</tr>
						</c:forEach>
					</tbody>
				</table>
				<div align ="right"><p style="color:	#2828FF; font-size: 19px;">总金额 : ${Car.totalPrice }</p></div>
			<h3>
				请确认你的联系方式：
			</h3>
			<c:if test="${User != null}">
			<form action="/Shop/cart/shopCart!saveOrder.action" method="post">
				<fieldset>
					 <legend>Mr/Miss &nbsp${User.name}!</legend> 
					 <label>姓名</label><input type="text"  value="${User.name}"/> 
					 <label>地址</label><input type="text"  value="${User.address }" /> 
					 <label>邮编</label><input type="text" value="${User.postcode }" /> 
					 <label>Email</label><input type="text" value="${User.email }" /> 
					 <label>电话</label><input type="text" value="${User.cellphone }" /> <br>
					 <input type=submit  value=确认结账  class = "btn">
				</fieldset>
			</form>
			</c:if>
			<c:if test="${User == null}">	
				<script language=javascript>alert('你没有登录哟，点击确定去登录吧');location.href="/Shop/login.jsp";</script>
		</c:if>
		</div>
	</div>
</div>
</body>
</html>