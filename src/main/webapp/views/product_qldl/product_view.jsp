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
</style>
</head>
<body>
	<div class="pt-6">
	<!-- QLDL product -->
	<h1 style="text-align: center; margin: 30px 0;">Danh sách sản phẩm</h1>
		<div>
			<form action="/Java5_SOF3021_Assignment/product/search"
				method="post">
				<label class="form-label">Tìm kiếm</label>
				<div class="row">
					<div class="form-group col-md-3">
						<input class="form-control" name="keywords" placeholder="Nhập tên sản phẩm">
					</div>
					<div class="form-group col-md-2">
						<button class="btn btn-outline-success">Search</button>
					</div>
					<div class="form-group col-md-3"></div>
					<div class="form-group col-md-4">
						<a  class="btn btn-outline-primary" type="btn btn-dark" href="/Java5_SOF3021_Assignment/homepage">Trang chủ</a>
						<a  class="btn btn-outline-primary" type="btn btn-dark" href="/Java5_SOF3021_Assignment/product/insert">Thêm mới sản phẩm</a>
					</div>
				</div>
			</form>
		</div>
			<table border="1"
				class="table table-hover table-responsive">
				<thead class="table-dark">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Image</th>
						<th>Price</th>
						<th>Available</th>
						<th>CreatedDate</th>
						<th>Last_modified_date</th>
						<th>Category_id</th>
						<th>Created_user</th>
						<th>Last_modified_user</th>
						<th>Sửa</th>
						<th>Xóa</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${pages.content}" var="product">
						<tr>
							<td>${product.id}</td>
							<td>${product.name}</td>
							<td>
								<img style="height: 100px; max-width: 95%;" class="poly-prod"
									src="../images/${product.image}">
							</td>
							<td>${product.price}</td>
							<td>${product.available}</td>
							<td><fmt:formatDate value="${product.createdDate}" pattern="dd/MM/yyyy" /></td>
							<td><fmt:formatDate value="${product.last_modified_date}" pattern="dd/MM/yyyy" /></td>
							<td>${product.category.name}</td>
							<td>${product.account.username}</td>
							<td>${product.last_modified_account.username}</td>
							<td><a class="btn btn-outline-primary" href="/Java5_SOF3021_Assignment/product/update?id=${product.id}">Sửa</a></td>
							<td><a class="btn btn-outline-danger" href="/Java5_SOF3021_Assignment/product/delete?id=${product.id}">Xóa</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div>
				<ul class="pagination justify-content-center" style="margin: 20px 0">
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/product/${url}?p=0">First</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/product/${url}?p=${pages.number-1}">Previous</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/product/${url}?p=${pages.number+1}">Next</a></li>
					<li class="page-item"><a class="page-link"
						href="/Java5_SOF3021_Assignment/product/${url}?p=${pages.totalPages-1}">Last</a></li>
				</ul>
			</div>
			
	</div>
</body>
</html>