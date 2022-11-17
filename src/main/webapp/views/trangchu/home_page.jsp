<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
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
	<!-- Header -->
	<header class="row">
		<img class="img-fluid"
			src="/Java5_SOF3021_Assignment/images/banner.jpg" />
	</header>
	<!-- menu -->
	<nav class="row">
		<div class="navbar navbar-expand-sm  navbar-dark bg-dark">
			<div class="container-fluid">
				<ul class="navbar-nav">
					<li class="nav-item"><a ng-click="intro=1"
						href="/Java5_SOF3021_Assignment/homepage"
						class="nav-link navbar-brand">
							<h4>Trang chủ</h4>
					</a></li>
					<c:if test="${sessionScope.username != null}">
						<span class="navbar-text">Tài khoản:
							${sessionScope.username} | Vai trò: ${sessionScope.role}</span>
					</c:if>
				</ul>
				<ul class="navbar-nav">
					<c:if test="${sessionScope.username != null}">
						<!-- Giỏ hàng -->
						<li class="nav-item"><a class="nav-link" href="/Java5_SOF3021_Assignment/cart/view">Giỏ
								hàng</a></li>
						<!-- Trang qiản trị -->
						<c:if test="${sessionScope.role == 0}">
							<ul class="navbar-nav">
								<li class="nav-item dropdown"><a
									class="nav-link dropdown-toggle" href="#" role="button"
									data-bs-toggle="dropdown">Trang quản trị</a>
									<ul class="dropdown-menu">

										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/account/view">Quản lý tài
												khoản</a></li>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/product/view">Quản lý sản
												phẩm</a></li>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/category/view">Quản lý
												loại hàng</a></li>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/order/view">Quản lý hóa
												đơn</a></li>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/order_details/view">Quản
												lý hóa đơn chi tiết</a></li>
										<hr>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/statistics-category">Thống
												kê doanh thu theo loại</a></li>
										<li><a class="dropdown-item"
											href="/Java5_SOF3021_Assignment/statistics-date">Thống kê
												doanh thu theo thời gian</a></li>
									</ul></li>
							</ul>
						</c:if>
					</c:if>
					<!-- Phần tài khoản -->
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" role="button"
						data-bs-toggle="dropdown">Tài khoản</a>
						<ul class="dropdown-menu">
							<c:if test="${sessionScope.username == null}">
								<li><a class="dropdown-item"
									href="/Java5_SOF3021_Assignment/login/form">Đăng nhập</a></li>
								<li><a class="dropdown-item"
									href="/Java5_SOF3021_Assignment/register/form">Đăng ký</a></li>
							</c:if>
							<c:if test="${sessionScope.username != null}">
								<li><a class="dropdown-item"
									href="/Java5_SOF3021_Assignment/logout">Đăng xuất</a></li>
								<li><a class="dropdown-item"
									href="/Java5_SOF3021_Assignment/account/change_password_form">Đổi
										mật khẩu</a></li>
								<li><a class="dropdown-item"
									href="/Java5_SOF3021_Assignment/account/update?id=0">Cập
										nhập tài khoản</a></li>
							</c:if>
						</ul></li>
				</ul>
			</div>
		</div>
	</nav>

	<article>
		<!-- HIển thị theo loai sản phẩm -->
		<h2 style="text-align: center;">Loại hàng</h2>
		<div class="list-group list-group-horizontal">
			<c:forEach items="${categories}" var="categorie">
				<a style="text-align: center;"
					href="/Java5_SOF3021_Assignment/category/${categorie.id}"
					class="list-group-item list-group-item-action">${categorie.name}</a>
			</c:forEach>
		</div>
		<!-- HIển thị sản phẩm -->
		<div class="row">
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
								<div style="color: red;">${page.price} VNĐ</div>
								<c:if test="${sessionScope.username != null}">
									<div>
										<a href="/Java5_SOF3021_Assignment/cart/add/${page.id}">Thêm vào giỏ hàng</a>
										<div><a href="/Java5_SOF3021_Assignment/order/create?id=${page.id}">Đặt hàng</a></div>
									</div>
								</c:if>
							</div>
						</a>
					</div>
				</div>

			</c:forEach>
		</div>
		<!-- Phân trang sản phẩm -->
		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/${url}?p=0">First</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/${url}?p=${pages.number-1}">Previous</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/${url}?p=${pages.number+1}">Next</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/${url}?p=${pages.totalPages-1}">Last</a></li>
			</ul>
		</div>
	</article>
	<footer>
		<h1>Web bán hàng</h1>
	</footer>
</body>
</html>