<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Đăng Nhập" /></title>
 <!-- css -->
    <link href="<c:url value='/template/web/assets/favicon.ico'/>">
    <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" type="text/css" media="all"/>
    <!-- Site Icons -->
    <link rel="shortcut icon" href="<c:url value='/template/web/images/favicon.ico'/>" type="image/x-icon">
    <link rel="apple-touch-icon" href="<c:url value='/template/web/images/apple-touch-icon.png'/>">
	<link rel="stylesheet" href="<c:url value='/template/web/fonts/fontawesome-free-6.1.1-web/fontawesome-free-6.1.1-web/css/all.min.css' />">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/bootstrap.min.css'/> ">
    <!-- Site CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/style.css'/> ">
    <!-- Responsive CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/responsive.css'/> ">
    <!-- Custom CSS -->
    <link rel="stylesheet" href="<c:url value='/template/web/css/custom.css'/> ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css"
        crossorigin="anonymous" />
</head>
<body>
	<div class="main-top">
		<div class="container-fluid">
			<div class="row">
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="text-slid-box">
						<div id="offer-box" class="carouselTicker">
							<ul class="offer-box">
								<li><i class="fab fa-opencart"></i> Chào mừng đến với D&L
									STORE</li>
								<li><i class="fab fa-opencart"></i> Mang lại cho bạn trải
									nghiệm tốt nhất</li>
								<li><i class="fab fa-opencart"></i> Với các sản phẩm độc
									đáo</li>
								<li><i class="fab fa-opencart"></i> Hãy thỏa sức khám phá</li>
								<li><i class="fab fa-opencart"></i> Chào mừng đến với D&L
									STORE</li>
								<li><i class="fab fa-opencart"></i> Mang lại cho bạn trải
									nghiệm tốt nhất</li>
								<li><i class="fab fa-opencart"></i> Với các sản phẩm độc
									đáo</li>
								<li><i class="fab fa-opencart"></i> Hãy thỏa sức khám phá</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-6 col-md-6 col-sm-12 col-xs-12">
					<div class="right-phone-box">
						<p>
							Liên hệ : <strong>0905453249</strong>
						</p>
					</div>
					<div class="our-link">
						<ul>
							<li><a href="web-home">Trang chủ</a></li>
							<li><a href="log-in">Đăng nhập</a></li>

						</ul>
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- Start Main Top -->
	
	<div class="container">
    	<dec:body/>
    </div>
    
	<!-- footer -->
	<%@ include file="/common/web/footer.jsp" %>
	<!-- footer -->
	
	
	<!-- ALL JS FILES -->
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery-3.2.1.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/popper.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/bootstrap.min.js'/>"></script>
	 <!-- ALL PLUGINS -->
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery.superslides.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/bootstrap-select.js'/>"></script>
	
	<script type="text/javascript" src="<c:url value='/template/web/js/inewsticker.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/bootsnav.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/images-loded.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/isotope.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/owl.carousel.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/baguetteBox.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/form-validator.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/contact-form-script.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/custom.js' />"></script>
</body>
</html>