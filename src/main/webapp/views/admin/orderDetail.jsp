<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var="info" value="${infoDelivery}" />
	<c:set var="o" value="${orderInfo }"  />
	<main class="app-content">
		<div class="app-title">

			<ul class="app-breadcrumb breadcrumb">
				<li class="breadcrumb-item"><i class="fa fa-home fa-lg"></i></li>
				<li class="breadcrumb-item"><a href="#">charts</a></li>
			</ul>
		</div>
		<div class="row">
			<div class="col-md-8">
				<div class="tile">
					<h3 class="tile-title">Mã đơn hàng #${o.order_id }</h3>
					<div class="custom-product-grid" id="customProductGrid">
						<c:forEach var="od" items="${orderDetails}">
							<div class="custom-product-item">
								<c:forEach var="p" items="${products }">
									<c:if test="${p.product_id == od.product_id}">
										<img class="custom-product-image" src="${p.productImage}"
											alt="ảnh sản phẩm">
										<div class="custom-product-details">
											<div>
												<h4 class="custom-product-name" style="margin-bottom:16px;" >${p.productName }</h4>
												<p class="custom-product-quantity" style=" font-size: 16px; font-weight: 600;">Số lượng: ${od.quantity}</p>
												<p class="custom-product-price" style=" font-size: 16px; font-weight: 600;">Giá tiền: ${p.productPrice }</p>
											</div>
										</div>
									</c:if>
								</c:forEach>

							</div>
						</c:forEach>
					</div>
				</div>

			</div>
			<div class="col-md-4">
				<div class="tile">
					<h3 class="tile-title">Thông tin vận chuyển</h3>
					<div class="user-receive">
						<hr>
						<p class="custom-info-head">Tên người nhận: ${info.name}</p>
						<p class="custom-info">Số điện thoại: ${info.phone}</p>
						<hr>
						<p class="custom-info-head ">Địa chỉ giao hàng</p>
						<p class="custom-info">${info.address }</p>
						<hr>
						<p class="custom-info-head ">Ghi chú:</p>
						<p class="custom-info">${info.note}</p>
						<hr>
					</div>
					<div class="row mt-3">
						<div class="col-7 custom-info-head">Tổng tiền:</div>
						<div class="col-5 " style="font-size: 20px; color: black;">${o.totalAmount} đ</div>
					</div>
				</div>
			</div>
		</div>


		</div>
	</main>
</body>
</html>