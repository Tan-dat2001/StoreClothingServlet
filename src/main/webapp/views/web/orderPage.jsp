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
						<div class="bg-white card mb-4 order-list shadow-sm">
							<div class="gold-members p-4">
								<a href="#"> </a>
								<div class="media">
									<a href="#"> <img class="mr-4" src="images/aothun1.jpg"
										alt="Generic placeholder image">
									</a>
									<div class="media-body">
										<a href="#"> <span class="float-right text-info">Delivered
												on Mon, Nov 12, 7:18 PM <i
												class="icofont-check-circled text-success"></i>
										</span>
										</a>
										<h6 class="mb-2">
											<a href="#"></a> <a href="#" class="text-black">Gus's
												World Famous Fried Chicken</a>
										</h6>
										<p class="text-gray mb-1">
											<i class="icofont-location-arrow"></i> 730 S Mendenhall Rd,
											Memphis, TN 38117, USA
										</p>
										<p class="text-gray mb-3">
											<i class="icofont-list"></i> ORDER #25102589748 <i
												class="icofont-clock-time ml-2"></i> Mon, Nov 12, 6:26 PM
										</p>
										<p class="text-dark">Veg Masala Roll x 1, Veg Burger x 1,
											Veg Penne Pasta in Red Sauce x 1</p>
										<hr>
										<div class="float-right">
											<a class="btn btn-sm btn-outline-primary" href="#"><i
												class="icofont-headphone-alt"></i> HELP</a> <a
												class="btn btn-sm btn-primary" href="#"><i
												class="icofont-refresh"></i> REORDER</a>
										</div>
										<p class="mb-0 text-black text-primary pt-2">
											<span class="text-black font-weight-bold"> Total Paid:</span>
											$300
										</p>
									</div>
								</div>

							</div>
						</div>
						<div class="bg-white card mb-4 order-list shadow-sm">
							<div class="gold-members p-4">
								<a href="#"> </a>
								<div class="media">
									<a href="#"> <img class="mr-4" src="images/aothun1.jpg"
										alt="Generic placeholder image">
									</a>
									<div class="media-body">
										<a href="#"> <span class="float-right text-info">Delivered
												on Mon, Nov 12, 7:18 PM <i
												class="icofont-check-circled text-success"></i>
										</span>
										</a>
										<h6 class="mb-2">
											<a href="#"></a> <a href="#" class="text-black">Gus's
												World Famous Fried Chicken</a>
										</h6>
										<p class="text-gray mb-1">
											<i class="icofont-location-arrow"></i> 730 S Mendenhall Rd,
											Memphis, TN 38117, USA
										</p>
										<p class="text-gray mb-3">
											<i class="icofont-list"></i> ORDER #25102589748 <i
												class="icofont-clock-time ml-2"></i> Mon, Nov 12, 6:26 PM
										</p>
										<p class="text-dark">Veg Masala Roll x 1, Veg Burger x 1,
											Veg Penne Pasta in Red Sauce x 1</p>
										<hr>
										<div class="float-right">
											<a class="btn btn-sm btn-outline-primary" href="#"><i
												class="icofont-headphone-alt"></i> HELP</a> <a
												class="btn btn-sm btn-primary" href="#"><i
												class="icofont-refresh"></i> REORDER</a>
										</div>
										<p class="mb-0 text-black text-primary pt-2">
											<span class="text-black font-weight-bold"> Total Paid:</span>
											$300
										</p>
									</div>
								</div>

							</div>
						</div>
						<div class="bg-white card mb-4 order-list shadow-sm">
							<div class="gold-members p-4">
								<a href="#"> </a>
								<div class="media">
									<a href="#"> <img class="mr-4" src="images/aothun1.jpg"
										alt="Generic placeholder image">
									</a>
									<div class="media-body">
										<a href="#"> <span class="float-right text-info">Delivered
												on Mon, Nov 12, 7:18 PM <i
												class="icofont-check-circled text-success"></i>
										</span>
										</a>
										<h6 class="mb-2">
											<a href="#"></a> <a href="#" class="text-black">Gus's
												World Famous Fried Chicken</a>
										</h6>
										<p class="text-gray mb-1">
											<i class="icofont-location-arrow"></i> 730 S Mendenhall Rd,
											Memphis, TN 38117, USA
										</p>
										<p class="text-gray mb-3">
											<i class="icofont-list"></i> ORDER #25102589748 <i
												class="icofont-clock-time ml-2"></i> Mon, Nov 12, 6:26 PM
										</p>
										<p class="text-dark">Veg Masala Roll x 1, Veg Burger x 1,
											Veg Penne Pasta in Red Sauce x 1</p>
										<hr>
										<div class="float-right">
											<a class="btn btn-sm btn-outline-primary" href="#"><i
												class="icofont-headphone-alt"></i> HELP</a> <a
												class="btn btn-sm btn-primary" href="#"><i
												class="icofont-refresh"></i> REORDER</a>
										</div>
										<p class="mb-0 text-black text-primary pt-2">
											<span class="text-black font-weight-bold"> Total Paid:</span>
											$300
										</p>
									</div>
								</div>

							</div>
						</div>
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