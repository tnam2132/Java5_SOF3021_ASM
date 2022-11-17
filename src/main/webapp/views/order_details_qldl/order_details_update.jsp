<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cập nhập hóa đơn</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style>
.container {
	margin: 40px auto;
	width: 700px;
	border: 13px double #858585;
	box-shadow: 10px 10px 5px 5px #888888;
}

label {
	font-size: 20px;
}

input {
	margin: 5px 0 10px 0;
}
</style>
</head>
<body>
	<div class="container pt-3">
		<h1 style="text-align: center;">Điền thông tin cập nhập hóa đơn chi tiết</h1>
		<f:form action="/Java5_SOF3021_Assignment/order_details/update_order_details" method="POST" modelAttribute="orderDetail">
			<f:hidden  path="id" />
			<div class="row">
				<div class="form-group">
					<label class="form-label">Giá :</label> <f:input class="form-control" name="price"
						 path="price" />
						 <f:hidden path="order"/>
						 <f:hidden path="product"/>
				</div>
				<div class="form-group">
					<label class="form-label">Số lượng :</label> <f:input class="form-control" name="quantity"
						 path="quantity" />
				</div>
			</div>
			<f:button type="Submit" class="btn btn-outline-success"
				style="margin-top: 10px;">Cập nhập</f:button>
			<a style="margin-top: 10px;" href="/Java5_SOF3021_Assignment/order_details/view" class="btn btn-outline-success">Hủy</a>
		</f:form>
	</div>
</body>
</html>