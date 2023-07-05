<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Giỏ hàng</title>
	<!-- <style>
		.name-product{
				max-width: 500px; 
				white-space: nowrap; 
				overflow: hidden; 
				text-overflow: ellipsis;
				}
	</style> -->
</head>
<body>
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Giỏ Hàng</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="web-home">Trang chủ</a></li>
						<li class="breadcrumb-item active">Giỏ hàng</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->
<form action="check-out" method="post">
	<!-- Start Cart  -->
	<div class="cart-box-main">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="table-main table-responsive">
						<table class="table">
							<thead>
								<tr>
									<th>Hình ảnh</th>
									<th>Tên sản phẩm</th>
									<th>Giá</th>
									<th>Số lượng</th>
									<th>Tổng tiền</th>
									<th>Xóa khỏi giỏ hàng</th>
								</tr>
							</thead>
							<tbody>
								
									<c:set var="o" value="${sessionScope.cart}" />
									<c:forEach var="i" items="${o.items}">
										<tr>
											<td class="thumbnail-img thumbnail-img-custom"><a
												href="#"> <img class="img-fluid" src="${i.product.productImage}"
													alt="" />
											</a></td>
											<td class="name-pr"><a href="product-detail?productId=${i.product.product_id}" class="name-product" 
											 style="max-width: 500px; display: inline-block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
											  ${i.product.productName} </a>
											</td>
											<td class="price-pr"><p>${i.product.productPrice} đ</p></td>
											<td class="quantity-box"><input type="number" size="4" name="quantity" 
												value="${i.quantity}" min="0" step="1"
												class="c-input-text qty text">
											</td>
											<td class="total-pr"><p>${i.product.productPrice*i.quantity} đ</p></td>
											<td class="remove-pr"><a href="#"> <i class="fas fa-times"></i>	</a></td>
										</tr>
									</c:forEach>
							</tbody>
						</table>
					</div>
				</div>
			</div>

			<div class="row my-5">
				<div class="col-lg-6 col-sm-6">
					<div class="coupon-box">
						<div class="input-group input-group-sm">
							<input class="form-control" placeholder="Nhập mã giảm"
								aria-label="Coupon code" type="text">
							<div class="input-group-append">
								<button class="btn btn-theme" type="button">Áp mã giảm</button>
							</div>
						</div>
					</div>
				</div>
				<!-- <div class="col-lg-6 col-sm-6">
                    <div class="update-box">
                        <input value="Update Cart" type="submit">
                    </div>
                </div> -->
			</div>

			<div class="row my-5">
				<div class="col-lg-8 col-sm-12"></div>
				<div class="col-lg-4 col-sm-12">
					<div class="order-box">
						<h3>Tóm tắt đơn hàng</h3>
						<div class="d-flex">
							<h4>Tổng tạm tính</h4>
							<div class="ml-auto font-weight-bold">$ 130</div>
						</div>
						<div class="d-flex">
							<h4>Giảm giá</h4>
							<div class="ml-auto font-weight-bold">$ 40</div>
						</div>
						<hr class="my-1">
						<div class="d-flex">
							<h4>Mã giảm</h4>
							<div class="ml-auto font-weight-bold">$ 10</div>
						</div>
						<div class="d-flex">
							<h4>Thuế</h4>
							<div class="ml-auto font-weight-bold">$ 2</div>
						</div>
						<div class="d-flex">
							<h4>Phí vận chuyển</h4>
							<div class="ml-auto font-weight-bold">Free</div>
						</div>
						<hr>
						<div class="d-flex gr-total">
							<h5>Tổng thanh toán</h5>
							<div class="ml-auto h5">$ 388</div>
						</div>
						<hr>
					</div>
				</div>
				<div class="col-12 d-flex shopping-box">
					<button type="submit" class="ml-auto btn hvr-hover" style="color:white; border:none;">Thanh Toán</button>
				</div>
			</div>

		</div>
	</div>
	<!-- End Cart -->
</form>
</body>
</html>