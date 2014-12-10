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
		$(function(){
			$("#regBtn").click(function(){
				var name = $("#name").val();
				var pwd1= $("#pwd1").val();
				var pwd2 = $("#pwd2").val();
				var address = $("#address").val();
				var postcode = $("#postcode").val();
				var email = $("#email").val();
				var homephone = $("#homephone").val();
				var cellphone = $("#cellphone").val();
				var officephone = $("#officephone").val();
				if( pwd1 != pwd2 ){
					alert("两次密码不一致 !");
					return false;
				}
				var datas = "user.name="+name+"&user.password="+pwd1+"&user.address=" +address+"&user.postcode=" +postcode+"&user.email=" +email+"&user.homephone=" +homephone+"&user.cellphone=" +cellphone+"&user.officephone=" +officephone ;
				$.ajax({
					   type: "POST",
					   url: "/Shop/json/shopJson!reg.action",
					   data: datas,
					   dataType:"json",
					   success: function(msg){
					  		if(msg.flag == 1){
					  			alert("注册成功 ! ");
					  			window.location.href="/Shop/login.jsp"
					  		}else{
					  			alert("内部异常，注册失败");
					  		}
					   }
					});
			});
		})
</script>
<title>注册</title>
</head>
<body background="img/e.jpg">
<div class="container-fluid">
	<div class="row-fluid">
		<div class="span8">
			<div class="alert">
				 <button type="button" class="close" data-dismiss="alert">×</button>
				<h4>
					提示!
				</h4> <strong>亲!</strong> 请如实填写你的信息
			</div>
			<center>
			<form action="#" method="post">
						用户&nbsp&nbsp&nbsp&nbsp名: <input type="text"  name="name"  id="name"/>
						<br>用户密码: <input type="password" name="pwd01"  id="pwd1"/>
						<br>密码确认: <input type="password"    id="pwd2" />
						<br>你的地址: <input type="text"  name="address"  id="address" />
						<br>你的邮编: <input type="text"   name="postcode" id="postcode" />
						<br>你的Emai: <input type="text"   name="email" id="email" />
						<br>家庭电话: <input type="text"  name="homephone"  id="homephone" />
						<br>你的手机: <input type="text"  name="cellphone"  id="cellphone" />
						<br>办公电话: <input type="text"  name="officephone"  id="officephone" />
						<br>
						<input type="button"  value="注册"  id="regBtn" />
					</form>		
					</center>
		</div>
		<div class="span4	">
			<img src="img/c.jpg" />
		</div>
	</div>
</div>
</body>
</html>