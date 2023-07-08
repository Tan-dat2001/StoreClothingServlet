<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<main class="app-content">
		<div class="app-title">
			<div>
				<h1>
					<i class="fa fa-edit"></i>Thêm sản phẩm
				</h1>
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<form action="admin-addProduct" method="post">
								<div>
									<input type="hidden" name="id" value="0">
								</div>
								<div class="form-group">
									<label for="exampleInputName">Tên sản phẩm</label> <input
										name="productName" class="form-control" id="exampleInputName"
										type="text" placeholder="">
								</div>
								<div class="form-group">
									<label for="exampleInputFile">Hình Ảnh</label> <input
										name="image" class="form-control-file" id="exampleInputFile"
										type="file">
								</div>
								<div class="form-group">
									<label for="exampleSelect1">Loại sản phẩm</label> <select
										name="category" class="form-control" id="exampleSelect1">
										<c:forEach var="category" items="${categories}">
											<option value="${category.category_id}">${category.categoryName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Số Lượng</label> <input
										name="quantity" class="form-control" id="exampleInputAmount"
										type="quantity" min="0" placeholder="0">
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Giá</label> <input
										name="price" class="form-control" id="exampleInputAmount"
										type="number" min="0" placeholder="0">
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Giảm giá</label><select
										name="discount" class="form-control" id="exampleInputAmount">
										<c:forEach var="discount" items="${discounts}">
											<option value="${discount.discount_id}">${discount.discountName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleTextarea">Mô Tả</label>
									<textarea name="description" class="form-control" id="exampleTextarea"
										rows="3"></textarea>
								</div>
								<!-- <div class="form-group">
									<label for="exampleTextarea1">Bảo Hành</label>
									<textarea name="baoHanh" class="form-control"
										id="exampleTextarea1" rows="3"></textarea>
								</div> -->
								<div class="col-lg-12  text-center">
									<button class="btn btn-primary" type="submit">Thêm
										sản phẩm</button>
								</div>
								</form>
						</div>
					</div>
				</div>
	</main>
</body>
</html>