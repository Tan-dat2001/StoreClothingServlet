<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đơn mua</title>
<link
	href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">

</head>
<body>
	<%
	HttpSession ss = request.getSession();
	String name = (String) ss.getAttribute("name");
	String email = (String) ss.getAttribute("email");
	float total = (Float)ss.getAttribute("total");
	%>
	<div class="container">
		<div class="view-account">
			<section class="module">
				<div class="module-inner">
					<div class="side-bar">
						<div class="user-info">
							<ul class="meta list list-unstyled">
								<li class="name">${name} <label
									class="label label-info">${email}</label>
								</li>
							</ul>
						</div>
						<nav class="side-menu">
							<ul class="nav">
								<li class="active"><a href="my-account"><span
										class="fa fa-user"></span> Hồ sơ</a></li>
								<li><a href="order-page"><span
										class="fa fa-credit-card"></span> Đơn mua</a></li>
								<li><a href="change-password"><i class="fa fa-key"
										aria-hidden="true"></i> Đổi mật khẩu</a></li>
							</ul>
						</nav>
					</div>
					<div class="content-panel">
						<c:forEach var="o" items="${listOrders}">
<%-- 							<c:set var="info" value="${infoDelivery}" /> --%>
								<div class="bg-white card mb-4 order-list shadow-sm">
									<div class="gold-members p-4">
										<a href="#"> </a>
										<div class="media">
											<!-- <a href="#"> <img class="mr-4" src="images/aothun1.jpg"
												alt="Generic placeholder image">
											</a> -->
											<div class="media-body">
												<a href="#"> 
													<span class="float-right text-info">Mã đơn hàng: #${o.order_id} 
													<i class="icofont-check-circled text-success"></i>
												</span> 
												</a>
												<c:forEach var="info" items="${infoDeliveries}">
													<c:if test="${o.order_id == info.orderId }">
														<h3 class="mb-2" style="font-weight:bold;"> Người nhận: ${info.name }</h3>
														<p class="mb-2">Số điện thoại: ${info.phone}</p>
														<p class=" mb-1"><i class="icofont-location-arrow"></i> 
															Địa chỉ: ${info.address}
														</p>
													</c:if>
												</c:forEach>
												
												<p class=" mb-3">
													Ngày đặt hàng: ${o.orderDate}
												</p>
												
												<hr>
												<div class="float-right">
													<a class="btn btn-sm btn-outline-primary" href="orderDetail-page?orderId=${o.order_id}"><i
														class="icofont-headphone-alt"></i> Xem chi tiết</a> 
													<!-- <a	class="btn btn-sm btn-primary" href="#"><i
														class="icofont-refresh"></i> Mua Lại</a> -->
												</div>
												<p class="mb-0 text-black text-primary pt-2">
													<span class="text-black font-weight-bold" style="color:#f37a27;"> Tổng thanh toán: ${o.totalAmount} đ</span>
													
												</p>
											</div>
										</div>
									</div>
								</div>
						</c:forEach>
						
					</div>
				</div>
			</section>
		</div>
	</div>
	<script data-cfasync="false"
		src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
	<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
	<script
		src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script type="text/javascript"></script>
</body>
</html>