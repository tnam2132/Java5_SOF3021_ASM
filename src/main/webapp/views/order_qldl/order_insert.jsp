<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nhập hóa đơn mới</title>
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
		<h1 style="text-align: center;">Điền thông tin hóa đơn</h1>
		<!-- HIển thị sản phẩm -->
		<f:form action="/Java5_SOF3021_Assignment/order/create_update/?id=${product.id}"
			method="POST">
			<div class="card text-center" style="margin: 10px 10px;">
				<div class="card-header bg-light"></div>
				<div class="card-body">
					<img style="height: 150px; max-width: 95%;" class="poly-prod"
						src="/Java5_SOF3021_Assignment/images/${product.image}">
				</div>
				<div class="card-footer bg-light">
					<label>Tên sản phẩm</label>
					<div style="color: black;">${product.name}</div>
					<label>Số lượng</label> <input type="number" name="quantity"
						onblur="this.form.submit()"
						style="width: 50px;" value="${orderDetail.quantity}"/>
					<div style="color: red;">${orderDetail.price*orderDetail.quantity}VNĐ</div>
				</div>
			</div>
		</f:form>
		<f:form action="/Java5_SOF3021_Assignment/order/create_order"
			method="POST" modelAttribute="order">
			<div>
				<div class="form-group">
					<label class="form-label">Địa chỉ :</label>
					<f:input type="text" class="form-control" name="address"
						path="address" />
				</div>
				<input type="hidden" name="ma" value="${product.id}"/>
				<input type="hidden" name="qty" value="${orderDetail.quantity}"/>
				<input type="hidden" name="price" value="${orderDetail.price*orderDetail.quantity}"/>
			</div>
			<button type="Submit" class="btn btn-outline-success"
				style="margin-top: 10px;">Thêm</button>
			<a style="margin-top: 10px;"
				href="/Java5_SOF3021_Assignment/homepage"
				class="btn btn-outline-success">Hủy</a>
		</f:form>
	</div>
</body>
</html>