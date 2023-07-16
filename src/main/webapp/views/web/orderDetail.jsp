<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chi tiết đơn hàng</title>
</head>
<body>
	<c:set var="info" value="${infoDelivery}" />
	<c:set var="o" value="${orderInfo}" />
	<!-- Start body order-detail -->
	<section class="h-100 h-custom" style="background-color: #eee;">
		<div class="container py-5 h-100">
			<div
				class="row d-flex justify-content-center align-items-center h-100">
				<div class="col-lg-8 col-xl-6" style="min-width: 900px;">
					<div class="card border-top border-bottom border-3"
						style="border-color: #f37a27 !important;">
						<div class="card-body p-5">

							<p class="lead fw-bold mb-1" style="color: #f37a27;">Chi tiết
								đơn hàng</p>

							<div class="row">
								<div class="col ">
									<p class="small">Người nhận:</p>
									<p>${info.name}</p>
								</div>
								<div class="col">
									<p class="small">Ngày đặt hàng:</p>
									<p>${o.orderDate}</p>
								</div>
								<div class="col ">
									<p class="small ">Số điện thoại:</p>
									<p>${info.phone}</p>
								</div>
							</div>

							<div class="row">
								<div class="col-3 small ">
									<p>Địa chỉ:</p>
								</div>
								<div class="col-9 ">
									<p>${info.address }</p>
								</div>
							</div>
							<div class="row">
								<p class="small col-12">
									Ghi chú: <span style="font-size: 18px; font-weight: normal;">${info.note}</span>
								</p>
							</div>
							<c:forEach var="od" items="${orderDetails}">
								<div class="mx-n5 px-4 py-4 mb-1"
									style="background-color: #f2f2f2;">
									<div class="row">
										<div class="col-md-8 col-lg-9">
											<c:forEach var="p" items="${products }">
												<c:if test="${p.product_id == od.product_id}">
													<p>${p.productName }</p>
												</c:if>
											</c:forEach>
										</div>
										<div class="col-md-4 col-lg-3">
											<p>x${od.quantity}</p>
										</div>
									</div>
									<div class="row">
										<div class="col-md-8 col-lg-9">
											<p class="mb-0">Đơn giá:</p>
										</div>
										<c:forEach var="p" items="${products }">
											<c:if test="${p.product_id == od.product_id}">
												<div class="col-md-4 col-lg-3">
													<p class="mb-0">${p.productPrice} đ</p>
												</div>
											</c:if>
										</c:forEach>
									</div>
									<div class="row">
										<div class="col-md-8 col-lg-9">
											<p class="mb-0">Thành tiền:</p>
										</div>
										<div class="col-md-4 col-lg-3">
											<p class="mb-0">${od.totalAmount}đ</p>
										</div>
									</div>
								</div>
							</c:forEach>


							<div class="row my-4">
								<div class="col-md-4 offset-md-8 col-lg-3 offset-lg-9">
									<p class="lead fw-bold mb-0" style="color: #f37a27;">Tổng
										thanh toán: ${o.totalAmount } đ</p>
								</div>
							</div>

							<!-- <p class="lead fw-bold mb-4 pb-2" style="color: #f37a27;">Theo
								dõi đơn hàng</p>

							<div class="row">
								<div class="col-lg-12">

									<div class="horizontal-timeline">

										<ul class="list-inline items d-flex justify-content-between">
											<li class="list-inline-item items-list">
												<p class="py-1 px-2 rounded text-white"	style="background-color: #f37a27;">Đang xử lý</p>
											</li>
											<li class="list-inline-item items-list">
												<p class="py-1 px-2 rounded text-white"	style="background-color: #f37a27;">Đã lấy hàng</p>
											</li>
											<li class="list-inline-item items-list">
												<p class="py-1 px-2 rounded text-white" style="background-color: #f37a27;">Đang giao</p>
											</li>
											<li class="list-inline-item items-list text-end"
												style="margin-right: 8px;">
												<p style="margin-right: -8px;">Đã giao</p>
											</li>
										</ul>

									</div>

								</div>
							</div> -->

							<p class="mt-4 pt-2 mb-0">
								Liên lạc chúng tôi: <a href="#!" style="color: #f37a27;">+84
									901172380</a>
							</p>

						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End body order-detail -->
</body>
</html>