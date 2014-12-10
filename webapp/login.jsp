<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet" media="screen">
    <link href="bootstrap/css/1.css" rel="stylesheet">
    <link href="bootstrap/css/2.css" rel="stylesheet">
<script type="text/javascript" src="js/jquery.js"></script>
    <script src="bootstrap/js/bootstrap.min.js"></script>

    <script type="text/javascript">
	$(function() {
		$("#regBtn").click(function() {
			window.location.href = 'reg.jsp'
		});
	})
</script>
<title>登录	</title>
</head>
<body background="img/d.jpg">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span3">
			<h3>
				亲！欢迎光临，请登录吧。如果没有账号，那就请注册吧。
			</h3>
			<img alt="200x840" src="img/b.jpg" />
		</div>
		<div class="span4">
			<form class="form-horizontal" action="/Shop/shopCart!login.action" method="post">
				<div class="control-group">
					 <label class="control-label" for="inputText">账号</label>
					<div class="controls">
						<input id="inputText" type="text"  name ="user.name"/>
					</div>
				</div>
				<div class="control-group">
					 <label class="control-label" for="inputPassword">密码</label>
					<div class="controls">
						<input id="inputPassword" type="password"  name="user.password"/>
					</div>
				</div>
				<div class="control-group">
					<div class="controls">
						 <label class="checkbox"><input type="checkbox" /> Remember me</label> <button type="submit" class="btn">登陆</button>
						 <button type="button" class="btn" id ="regBtn">注册</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</div>
</body>
</html>