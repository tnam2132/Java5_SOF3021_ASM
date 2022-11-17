<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý loại hàng</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<style type="text/css">
.container {
	
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
		<h1 style="text-align: center; margin: 30px 0;">Thống kê doanh thu theo loại hàng</h1>
		<div>
			<a class="btn btn-outline-primary" type="btn btn-dark"
				href="/Java5_SOF3021_Assignment/homepage">Trang chủ</a>
		</div>
		<table border="1" class="table table-hover table-responsive">
			<thead class="table-dark">
				<tr>
					<th>Loại hàng</th>
					<th>Doanh thu</th>
					<th>Số lượng bán</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${pages.content}" var="report">
					<tr>
						<td>${report.loai.name}</td>
						<td>${report.doanhThu}$</td>
						<td>${report.soLuong}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<ul class="pagination justify-content-center" style="margin: 20px 0">
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/statistics-category?p=0">First</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/statistics-category?p=${pages.number-1}">Previous</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/statistics-category?p=${pages.number+1}">Next</a></li>
				<li class="page-item"><a class="page-link"
					href="/Java5_SOF3021_Assignment/statistics-category?p=${pages.totalPages-1}">Last</a></li>
			</ul>
		</div>

	</div>
</body>
</html>