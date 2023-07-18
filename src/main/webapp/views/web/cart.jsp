<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.clothingstore.model.Item"%>
<%@ page import="java.util.List"%>
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
	<form action="check-out" method="post">
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
												href="product-detail?productId=${i.product.product_id}"> <img class="img-fluid"
													src="${i.product.productImage}" alt="" />
											</a></td>
											<td class="name-pr"><a
												href="product-detail?productId=${i.product.product_id}"
												class="name-product"
												style="max-width: 500px; display: inline-block; white-space: nowrap; overflow: hidden; text-overflow: ellipsis;">
													${i.product.productName} </a></td>
											<td class="price-pr"><p>${i.product.productPrice}đ</p></td>
											<td class="quantity-box"
												style="display: flex; justify-content: center; align-items: center; margin-top: 32px; border: none;">
												<button type="button">
													<a href="processNum?num=-1&productId=${i.product.product_id}">-</a>
												</button> 
												<input type="text" value="${i.quantity}" class="c-input-text qty text">
												<button type="button">
													<a href="processNum?num=1&productId=${i.product.product_id}">+</a>
												</button>
											</td>
											<td class="total-pr"><p >${i.product.productPrice*i.quantity} đ</p></td>
											<td class="remove-pr">
												<a href="process?productId=${i.product.product_id}">
                                           			 <i class="fas fa-times"></i>
                                        		</a>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>

				<!-- <div class="row my-5">
					<div class="col-lg-6 col-sm-6">
						<div class="coupon-box">
							<div class="input-group input-group-sm">
								<input class="form-control" placeholder="Nhập mã giảm"
									aria-label="Coupon code" type="text" name="discountCodeInput">
								<div class="input-group-append">
									<button class="btn btn-theme" type="button"><a>Áp mã giảm</a></button>
								</div>
							</div>
						</div>
					</div> -->


					<!-- <div class="col-lg-6 col-sm-6">
                    <div class="update-box">
                        <input value="Update Cart" type="submit">
                    </div>
                </div>  -->
				<!-- </div> -->

				<div class="row my-5">
					<div class="col-lg-8 col-sm-12"></div>
					<div class="col-lg-4 col-sm-12">
						<div class="order-box">
							<h3>Tóm tắt đơn hàng</h3>
							<div class="d-flex">
								<h4>Tổng tạm tính</h4>
								<div class="ml-auto font-weight-bold">
									<c:set var="o" value="${sessionScope.cart}" />
									<%
									HttpSession ss = request.getSession();
									float total = 0;
									List<Item> items = (List<Item>) ss.getAttribute("listItem");
									if (items != null) {
										for (Item item : items) {
											total += item.getProduct().getProductPrice() * item.getQuantity();
										}
									}
									out.print(total + " đ");
									session.setAttribute("total", total);
									%>
								</div>
							</div>
							<%-- <div class="d-flex">
								<h4>Giảm giá</h4>
								<div class="ml-auto font-weight-bold"> 40đ</div>
							</div>
							<hr class="my-1">
							
							<div class="d-flex gr-total">
								<h5>Tổng thanh toán</h5>
								<div class="ml-auto h5">
									<%out.print(total + " đ");%>
								</div>
							</div> --%>
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