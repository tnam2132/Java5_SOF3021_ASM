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
<title>Đăng ký tài khoản</title>
</head>
<body>
	<div class="container pt-2">
		<h1>Đăng ký tài khoản</h1>
		<f:form action="/Java5_SOF3021_Assignment/register" method="post"
			modelAttribute="account">
			<div class="mb-2">
				<label class="form-label">Tên tài khoản</label>
				<f:input type="text" name="username" class="form-control"
					path="username" />
			</div>
			<div style="color: red">
				<f:errors path="username" element="small" delimiter="<br>"></f:errors>
			</div>
			<div class="mb-2">
				<label class="form-label">Họ và tên</label>
				<f:input type="text" name="fullname" class="form-control"
					path="fullname" />
			</div>
			<div style="color: red">
				<f:errors path="fullname" element="small" delimiter="<br>"></f:errors>
			</div>
			<div class="mb-2">
				<label class="form-label">Email</label>
				<f:input type="text" name="email" class="form-control" path="email"/>
			</div>
			<div style="color: red">
				<f:errors path="email" element="small" delimiter="<br>"></f:errors>
			</div>
			<div class="mb-2">
				<label class="form-label">Mật khẩu</label>
				<f:input type="password" name="password" class="form-control"
					path="password" />
				<f:hidden path="photo" />
			</div>
			<div style="color: red">
				<f:errors path="password" element="small" delimiter="<br>"></f:errors>
			</div>
			<div class="mb-2">
				<label class="form-label">Xác nhận mật khẩu</label> <input
					type="password" name="confirmpassword" class="form-control" />
			</div>
			<div class="mb-2 row">
				<div class="col-sm-6">
					<button type="submit" class="btn btn-danger">Đăng ký</button>
				</div>
				<div class="col-sm-6">
					<a href="/Java5_SOF3021_Assignment/login/form"
						class="btn btn-primary">Hủy</a>
				</div>
			</div>
		</f:form>
	</div>
</body>
</html>