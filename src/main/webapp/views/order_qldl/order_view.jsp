<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý hóa đơn</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
}
table {
	height: 300px;
	margin-top: 20px;
}
</style>
</head>
<body>
	<div class="container pt-6">
	<!-- QLDL product -->
	<h1 style="text-align: center; margin: 30px 0;">Danh sách hóa đơn</h1>
		<div>
			<form action="/Java5_SOF3021_Assignment/order/search"
				method="post">
				<label class="form-label">Tìm kiếm</label>
				<div class="row">
					<div class="form-group col-md-3">
						<input class="form-control" name="keywords" placeholder="Nhập địa chỉ đơn hàng">
					</div>
					<div class="form-group col-md-2">
						<button class="btn btn-outline-success">Search</button>
					</div>
					<div class="form-group col-md-3"></div>
					<div class="form-group col-md-4">
						<a  class="btn btn-outline-primary" type="btn btn-dark" href="/Java5_SOF3021_Assignment/homepage">Trang chủ</a>
					</div>
				</div>
			</form>
		</div>
			<table border="1"
				class="table table-hover table-responsive">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Created_Date</th>
						<th>Address</th>
						<th>User_id</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pages.content}" var="order">
					<tr>
						<td>${order.id}</td>
						<td>${order.createdDate}</td>
						<td>${order.address}</td>
						<td>${order.account.username}</td>
						<td><a class="btn btn-outline-primary"
							href="/Java5_SOF3021_Assignment/order/update?id=${order.id}">Sửa</a></td>
						<td><a class="btn btn-outline-danger"
							href="/Java5_SOF3021_Assignment/order/delete?id=${order.id}">Xóa</a></td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
			<div>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/order/${url}?p=0">First</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/order/${url}?p=${pages.number-1}">Previous</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/order/${url}?p=${pages.number+1}">Next</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/order/${url}?p=${pages.totalPages-1}">Last</a></li>
				</ul>
			</div>
			
	</div>
</body>
</html>