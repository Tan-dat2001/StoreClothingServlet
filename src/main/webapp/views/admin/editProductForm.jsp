<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

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
					<i class="fa fa-edit"></i>Sửa thông tin sản phẩm
				</h1>
			</div>

		</div>

		<div class="row">
			<div class="col-md-12">
				<div class="tile">
					<div class="row">
						<div class="col-lg-3"></div>
						<div class="col-lg-6">
							<form action="admin-editProduct" method="post">
								<div>
									<input type="hidden" name="productId" value="${product.product_id}">
								</div>
								<div class="form-group">
									<label for="exampleInputName">Tên sản phẩm</label> <input
										name="productName" class="form-control" id="exampleInputName"
										type="text" placeholder="" value="${product.productName}">
								</div>
								<div class="form-group">
									<label for="exampleInputFile">Hình Ảnh</label> <input
										name="image" class="form-control-file" id="exampleInputFile"
										type="text" value="${product.productImage}"> 
<%-- 									<img alt="Hình ảnh sản phẩm" name="image" src="<c:url value='${product.productImage}' /> ">	
 --%>								</div>
								<div class="form-group">
									<label for="exampleSelect1">Loại sản phẩm</label> <select
										name="category" class="form-control" id="exampleSelect1">
										<c:forEach var="category" items="${categories}">
											<option value="${category.category_id}" ${product.category_id == category.category_id ? 'selected':''}>${category.categoryName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Số Lượng</label> <input
										name="quantity" class="form-control" id="exampleInputAmount"
										type="quantity" min="0" placeholder="0" value="${product.quantity}">
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Giá</label> <input
										name="price" class="form-control" id="exampleInputAmount"
										type="number" min="0" placeholder="0" value="${product.productPrice }">
								</div>
								<div class="form-group">
									<label for="exampleInputAmount">Giảm giá</label><select
										name="discount" class="form-control" id="exampleInputAmount">
										<c:forEach var="discount" items="${discounts}">
											<option value="${discount.discount_id}" ${product.discount_id == discount.discount_id ? 'selected':''}>${discount.discountName}</option>
										</c:forEach>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleInputStatus">Trạng thái</label><select
										name="status" class="form-control" id="exampleInputStatus">
											<option value="enabled" ${product.status == 'enabled' ? 'selected':''}>Enabled</option>
											<option value="disabled" ${product.status == 'disabled' ? 'selected':''}>Disabled</option>
									</select>
								</div>
								<div class="form-group">
									<label for="exampleTextarea">Mô Tả</label>
									<textarea name="description" class="form-control" id="exampleTextarea"
										rows="3" >${product.productDesc}</textarea>
								</div>
								<!-- <div class="form-group">
									<label for="exampleTextarea1">Bảo Hành</label>
									<textarea name="baoHanh" class="form-control"
										id="exampleTextarea1" rows="3"></textarea>
								</div> -->
								<div class="col-lg-12  text-center">
									<button class="btn btn-primary" type="submit">Sửa sản phẩm</button>
								</div>
								</form>
						</div>
					</div>
				</div>
	</main>
</body>
</html>