<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
table {
	height: 300px;
	margin-top: 20px;
}

a {
	text-decoration: none;
}
</style>
</head>
<body>
	<div class="pt-6"></div>
	<a  class="btn btn-outline-primary" type="btn btn-dark" href="/Java5_SOF3021_Assignment/homepage">Trang chủ</a>
	<!-- Chi tiết sản phẩm -->
	<h1 style="text-align: center; margin: 30px 0;">Chi tiết sản phẩm</h1>
	<div class="row">
		<div class="col-md-6">
			<div class="col-md-3">
				<div class="card text-center"
					style="margin: 10px 10px; width: 600px;">
					<div class="card-header bg-light"></div>
					<div class="card-body">
						<img style="height: 150px; max-width: 95%;" class="poly-prod"
							src="/Java5_SOF3021_Assignment/images/${product.image}">
					</div>
					<div class="card-footer bg-light">
						<div>
							<a href="#">Loại khỏi giỏ hàng</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<div class="col-md-6">
			<div>
				<h2>Tên sản phẩm: ${product.name}</h2>
			</div>
			<div>
				<h2>Giá sản phẩm: ${product.price} VNĐ</h2>
					<h2>Loại hàng: ${product.category.name}</h2>
				<h2>
					Trạng thái:
					<c:if test="${product.available==0}">Còn hàng</c:if>
					<c:if test="${product.available==1}">Hết hàng</c:if>
				</h2>
				<c:if test="${product.available==0&&sessionScope.username != null}">
					<a href="#" class="btn btn-primary">Đặt hàng</a>
				</c:if>
			</div>
		</div>
		<!-- Hàng cùng loại -->
		<div class="row" style="margin-top: 100px;">
			<h1 style="text-align: center;">Sản phẩm cùng loại</h1>
			<c:forEach items="${pages.content}" var="page">
				<div class="col-md-3">
					<div class="card text-center" style="margin: 10px 10px;">
						<a href="/Java5_SOF3021_Assignment/product/ctsp?id=${page.id}">
							<div class="card-header bg-light"></div>
							<div class="card-body">
								<img style="height: 150px; max-width: 95%;" class="poly-prod"
									src="/Java5_SOF3021_Assignment/images/${page.image}">
							</div>
							<div class="card-footer bg-light">
								<div style="color: black;">${page.name}</div>
								<div style="color: red;">${page.price}</div>
								<div>
									<a href="#">Thêm vào giỏ hàng</a>
								</div>
							</div>
						</a>
					</div>
				</div>
			</c:forEach>
		</div>
		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/product/ctsp?id?p=0">First</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/product/ctsp?id?p=${pages.number-1}">Previous</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/product/ctsp?id?p=${pages.number+1}">Next</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/product/ctsp?id?p=${pages.totalPages-1}">Last</a></li>
			</ul>
		</div>
	</div>
</body>
</html>