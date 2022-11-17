<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
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
	height: 540px;
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
		<f:form action="/Java5_SOF3021_Assignment/account/change_password" method="POST" modelAttribute="account">
			<div class="mb-2">
				<label class="form-label">Nhập mật khẩu cũ</label> <f:input type="password"
					name="password" class="form-control" path="password"/>
			</div>
			<div class="mb-2">
				<label class="form-label">Nhập mật khẩu mới</label> <input type="password"
					name="new_password" class="form-control" path="new_password"/>
			</div>
			<div class="mb-2">
				<label class="form-label">Xác nhận mật khẩu mới</label> <input
					type="password" name="re_new_password" class="form-control"
					/>
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-success">Đổi mật khẩu</button>
				</div>
				<div class="col-sm-6">
					<a href="/Java5_SOF3021_Assignment/homepage" class="btn btn-primary">Hủy</a>
				</div>
			</div>
		</f:form>
	</div>
</body>
</html>