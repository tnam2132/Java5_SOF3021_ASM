<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
label {
	font-size: 20px;
}

.container {
	margin: 70px auto;
	width: 450px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

.form-control {
	margin-bottom: 30px;
}

a {
	text-decoration: none;
}

.btn {
	width: 180px;
	margin-left: 5px;
}

h6 {
	margin-top: 25px;
	text-align: center;
}
</style>
<title>Login</title>
</head>
<body>
	<div class="container pt-4">
		<h1 style="margin-bottom: 25px; text-align: center;">Đăng nhập</h1>
		<f:form action="/Java5_SOF3021_Assignment/login" method="POST" modelAttribute="account">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label> <f:input type="text"
					name="username" class="form-control" path="username" value = "Nam"/>
				 	<f:hidden path="fullname"/>
					<f:hidden path="email"/>
					<f:hidden path="photo"/>
			</div>
			<div style="color: red">
				<f:errors path="username" element="small" delimiter="<br>"></f:errors>
			</div>
			<div class="mb-2">
				<label class="form-label">Mật khẩu</label>
				<f:input type="password" name="password" class="form-control"
					path="password" value = "123456" />
			</div>
			<div style="color: red">
				<f:errors path="password" element="small" delimiter="<br>"></f:errors> 
			</div>
			<div class="mb-2">
				<label class="form-label">Remember</label><input type="checkbox"
					name="remember" value="true" />
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-success">Đăng nhập</button>
				</div>
				<div class="col-sm-6">
					<a href="/Java5_SOF3021_Assignment/homepage" class="btn btn-primary">Hủy</a>
				</div>
			</div>
			<div class="mb-2">
				<h6>
					<a href="/Java5_SOF3021_Assignment/register/form">Đăng ký</a>
				</h6>
				<h6>
					<a href="/Java5_SOF3021_Assignment/homepage">Quên mật khẩu</a>
				</h6>
			</div>
		</f:form>
	</div>
</body>
</html>