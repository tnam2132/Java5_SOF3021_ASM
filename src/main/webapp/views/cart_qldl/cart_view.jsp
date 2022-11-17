<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div>
		<a class="btn btn-outline-primary" type="btn btn-dark"
			href="/Java5_SOF3021_Assignment/homepage">Trang chủ</a>
		<h1 style="text-align: center;">Shopping cart</h1>
		<hr>
		<!-- HIển thị sản phẩm -->
		<div class="row">
			<c:forEach items="${cart.items}" var="item">
				<div class="col-md-3">
					<form action="/Java5_SOF3021_Assignment/cart/update/${item.product.id}"
						method="POST">
						<div class="card text-center" style="margin: 10px 10px;">
							<div class="card-header bg-light"></div>
							<div class="card-body">
								<img style="height: 150px; max-width: 95%;" class="poly-prod"
									src="/Java5_SOF3021_Assignment/images/${item.product.image}">
							</div>
							<div class="card-footer bg-light">
								<div style="color: black;">${item.product.name}</div>
								<div style="color: red;">${item.price*item.quantity} VNĐ</div>
								<input type="number" name="qty" value="${item.quantity}"
									onblur="this.form.submit()" style="width: 50px;">
								<div>
									<a href="/Java5_SOF3021_Assignment/cart/remove/${item.product.id}">Xóa
										khỏi giỏ hàng</a>
								</div>
							</div>
						</div>
					</form>
				</div>
			</c:forEach>
		</div>
		<a href="/Java5_SOF3021_Assignment/cart/clear"
			class="btn btn-outline-danger" style="margin-bottom: 10px;">Clear
			cart</a> <a href="/Java5_SOF3021_Assignment/homepage"
			class="btn btn-outline-primary" style="margin-bottom: 10px;">Add
			more</a>
	</div>
</body>
</html>