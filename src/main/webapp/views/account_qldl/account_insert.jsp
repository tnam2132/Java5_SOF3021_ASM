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
h1 {
	text-align: center;
}

label {
	font-size: 20px;
}

.container {
	margin: 0 auto;
	width: 500px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

.form-control {
	margin-bottom: 20px;
}

a {
	text-decoration: none;
}

.btn {
	width: 180px;
	margin-top: 12px;
	margin-left: 13px;
}

.error {
	color: red;
}
</style>
<title>Register</title>
</head>
<body>
	<div class="container pt-2">
		<h1>Đăng ký</h1>
		<f:form action="/Java5_SOF3021_Assignment/account/create_account" method="POST" modelAttribute="account">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label> <f:input type="text"
					name="username" class="form-control" path="username"/>
			</div>
			<div class="mb-2">
				<label class="form-label">Họ và tên</label> <f:input type="text"
					name="fullname" class="form-control" path="fullname"
					/>
			</div>
			<div class="mb-2">
				<label class="form-label">Email</label> <f:input type="text"
					name="email" class="form-control" path="email"
					/>
			</div>
			<div class="mb-2">
				<label class="form-label">Mật khẩu</label> <f:input type="password"
					name="password" class="form-control" path="password"/>
			</div>
			<div class="mb-2">
				<label class="form-label">Xác nhận mật khẩu</label> <input
					type="password" name="confirmpassword" class="form-control"
					/>
			</div>
			<div class="mb-2">
				<label class="form-label">Admin</label> 
				<label><f:radiobutton name="admin" value="0" path="admin"/>Admin</label>
				<label><f:radiobutton name="admin" value="1" path="admin"/>Nhân viên</label>
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-danger">Đăng ký</button>
				</div>
				<div class="col-sm-6">
					<a href="/Java5_SOF3021_Assignment/account/view" class="btn btn-primary">Hủy</a>
				</div>
			</div>
		</f:form>
	</div>
</body>
</html>