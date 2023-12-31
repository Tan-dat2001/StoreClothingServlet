<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="com.clothingstore.model.Item"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- Start All Title Box -->
	<div class="all-title-box">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<h2>Thanh Toán</h2>
					<ul class="breadcrumb">
						<li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
						<li class="breadcrumb-item active">Thanh toán</li>
					</ul>
				</div>
			</div>
		</div>
	</div>
	<!-- End All Title Box -->

	<!-- Start Cart  -->
	<form action="make-payment" method="post">
		<div class="cart-box-main">
			<div class="container">

				<div class="row">
					<div class="col-sm-6 col-lg-6 mb-3">
						<div class="checkout-address">
							<div class="title-left">
								<h3>Địa chỉ nhận hàng</h3>
							</div>
							<!-- <form class="needs-validation" novalidate> -->
							<div class="mb-3">
								<label for="firstName">Họ Tên *</label> <input type="text"
									class="form-control" id="firstName" placeholder="" value=""
									name="fullName" required>
								<div class="invalid-feedback">Valid first name is
									required.</div>
							</div>


							<div class="mb-3">
								<label for="username">Số điện thoại *</label>
								<div class="input-group">
									<input type="text" class="form-control" id="username"
										placeholder="" name="phone" required>
									<div class="invalid-feedback" style="width: 100%;">Your
										username is required.</div>
								</div>
							</div>
							<!-- <div class="mb-3">
								<label for="email">Email *</label> <input type="email"
									class="form-control" id="email" name="email" placeholder="">
								<div class="invalid-feedback">Please enter a valid email
									address for shipping updates.</div>
							</div> -->
							<div class="mb-3">
								<label for="address">Địa chỉ *</label> <input type="text"
									class="form-control" id="address" name="address" placeholder=""
									required>
								<div class="invalid-feedback">Please enter your shipping
									address.</div>
							</div>
							<div class="mb-3">
								<label for="address2">Ghi chú</label> <input type="text"
									class="form-control" id="address2" name="note" placeholder="">
							</div>

							<hr class="mb-4">
							<div class="title">
								<span style="font-weight: bolder;">Phương thức thanh toán</span>
							</div>
							<div class="d-block my-3">

								<!-- 		<div class="custom-control custom-radio">
									<input id="debit" name="paymentMethod" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="debit">Thẻ ghi nợ</label>
								</div>
								<div class="custom-control custom-radio">
									<input id="momo" name="paymentMethod" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="momo">Momo</label>
								</div>
								<div class="custom-control custom-radio">
									<input id="cod" name="paymentMethod" type="radio"
										class="custom-control-input" required> <label
										class="custom-control-label" for="cod">Thanh toán khi
										nhận Hàng</label>
								</div> -->
								<c:forEach var="p" items="${paymentMethods}">
									<div class="custom-control custom-radio">
										<input id="${p.payment_id}" name="paymentMethod" type="radio"
											value="${p.payment_id}" class="custom-control-input">
										<label class="custom-control-label" for="${p.payment_id}">${p.paymentName}</label>
									</div>
								</c:forEach>

							</div>
							<!-- <div class="row">
								<div class="col-md-6 mb-3">
									<label for="cc-name">Tên thẻ</label> <input type="text"
										class="form-control" id="cc-name" placeholder=""
										name="nameCard" required> <small class="text-muted">Vui
										lòng điền đầy đủ như trên thẻ</small>
									<div class="invalid-feedback">Name on card is required</div>
								</div>
								<div class="col-md-6 mb-3">
									<label for="cc-number">Số thẻ</label> <input type="text"
										class="form-control" id="cc-number" placeholder=""
										name="numCard" required>
									<div class="invalid-feedback">Credit card number is
										required</div>
								</div>
							</div>
							<div class="row">
								<div class="col-md-3 mb-3">
									<label for="cc-expiration">Ngày hết hạn</label> <input
										type="text" class="form-control" id="cc-expiration"
										name="expired" placeholder="" required>
									<div class="invalid-feedback">Expiration date required</div>
								</div>
								<div class="col-md-3 mb-3">
									<label for="cc-expiration">CVV</label> <input type="text"
										class="form-control" id="cc-cvv" name="CCV" placeholder=""
										required>
									<div class="invalid-feedback">Security code required</div>
								</div>

							</div> -->
							<!-- </form> -->
						</div>
					</div>
					<div class="col-sm-6 col-lg-6 mb-3">
						<div class="row">
							<div class="col-md-12 col-lg-12">
								<div class="shipping-method-box">
									<div class="title-left">
										<h3>Phương thức vận chuyển</h3>
									</div>
									<div class="mb-4">
										<!-- <div class="custom-control custom-radio">
										<input id="shippingOption1" name="shipping-option"
											class="custom-control-input" checked="checked" type="radio">
										<label class="custom-control-label" for="shippingOption1">Giao
											hàng tiêu chuẩn</label> <span class="float-right font-weight-bold">FREE</span>
									</div>
									<div class="ml-4 mb-2 small">(3-7 ngày)</div>
									<div class="custom-control custom-radio">
										<input id="shippingOption2" name="shipping-option"
											class="custom-control-input" type="radio"> <label
											class="custom-control-label" for="shippingOption2">Giao
											hàng nhanh</label> <span class="float-right font-weight-bold">$10.00</span>
									</div>
									<div class="ml-4 mb-2 small">(2-4 business days)</div>  -->

										<%-- <c:forEach var="d" items="${deliveryMethods}">
										<div class="custom-control custom-radio">
											<input id="${d.delivery_id}" name="delivery" value="${d.delivery_id}"
												class="custom-control-input" checked type="radio">
											<label class="custom-control-label" for="${d.delivery_id}">${d.deliveryName}</label> 
											<span class="float-right font-weight-bold">${d.deliveryPrice}</span>
										</div>
									</c:forEach> --%>
										<c:forEach var="delivery" items="${deliveryMethods}">
											<div class="custom-control custom-radio">
												<input id="shippingOption${delivery.delivery_id}"
													name="delivery" class="custom-control-input"
													type="radio" value="${delivery.delivery_id}"> <label
													class="custom-control-label"
													for="shippingOption${delivery.delivery_id}">
													${delivery.deliveryName} </label> <span
													class="float-right font-weight-bold">$$</span>
													<!-- ${delivery.deliveryPrice} -->
											</div>
										</c:forEach>


									</div>
								</div>
							</div>
							<div class="col-md-12 col-lg-12">
								<div class="odr-box">
									<div class="title-left">
										<h3>Sản phẩm</h3>
									</div>
									<div class="rounded p-2 bg-light">
										<c:forEach var="item" items="${listItem}">
											<div class="media mb-2 border-bottom">
												<div class="media-body">
													<a
														href="product-detail?productId=${item.product.product_id}">${item.product.productName}</a>
													<div class="small text-muted">
														Giá: ${item.product.productPrice } đ<span class="mx-2">|</span>
														Số lượng: ${item.quantity } <span class="mx-2">|</span>
														Tổng: ${item.product.productPrice*item.quantity} đ
													</div>
												</div>
											</div>
										</c:forEach>

									</div>
								</div>
							</div>
							<div class="col-md-12 col-lg-12">
								<div class="order-box">
									<div class="title-left">
										<h3>Đơn hàng của bạn</h3>
									</div>
									<div class="d-flex">
										<div class="font-weight-bold">Sản phẩm</div>
										<div class="ml-auto font-weight-bold">Tổng</div>
									</div>
									<hr class="my-1">
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
											%>
										</div>
									</div>
									<!-- <div class="d-flex">
										<h4>Giảm giá</h4>
										<div class="ml-auto font-weight-bold">$ 40</div>
									</div> -->
									<hr class="my-1">
									<!-- 								<div class="d-flex">
									<h4>Thuế</h4>
									<div class="ml-auto font-weight-bold">$ 2</div>
								</div> -->
									<div class="d-flex">
										<h4>Chi phí vận chuyển</h4>
										<div class="ml-auto font-weight-bold">$$</div>
									</div>
									<hr>
									<div class="d-flex gr-total">
										<h5>Tổng thanh toán</h5>
										<div class="ml-auto h5">
											<%
											out.print(total + " đ");
											%>
										</div>
									</div>
									<hr>
								</div>
							</div>
							<div class="col-12 d-flex shopping-box">
								<button type="submit" class="ml-auto btn hvr-hover">Đặt
									hàng</button>
							</div>
						</div>
					</div>
				</div>

			</div>
		</div>
		<!-- End Cart -->
	</form>
</body>
</html>