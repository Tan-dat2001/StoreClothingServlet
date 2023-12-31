<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Responsive navbar-->
<!-- Start Main Top -->
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
							<li><i class="fab fa-opencart"></i> Với các sản phẩm độc đáo
							</li>
							<li><i class="fab fa-opencart"></i> Hãy thỏa sức khám phá</li>
							<li><i class="fab fa-opencart"></i> Chào mừng đến với D&L
								STORE</li>
							<li><i class="fab fa-opencart"></i> Mang lại cho bạn trải
								nghiệm tốt nhất</li>
							<li><i class="fab fa-opencart"></i> Với các sản phẩm độc đáo
							</li>
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
						<%
						HttpSession ss = request.getSession();
						String name = ((String)ss.getAttribute("name"));
						String email = ((String)ss.getAttribute("email"));
						int accountId = (Integer)ss.getAttribute("accountId");
  						if (name != null) {
						%>
						<li style="font-size: 16px; font-weight: 600; color: white;">${name}</li>
						<%
						} else {
						%>
						<li><a href="log-in">Đăng nhập</a></li>
						<%
						}
						%>

					</ul>
				</div>
			</div>

		</div>
	</div>
</div>
<!-- Start Main Top -->
<header class="main-header">
	<!-- Start Navigation -->
	<nav
		class="navbar navbar-expand-lg navbar-light bg-light navbar-default bootsnav">
		<div class="container navbar-css" style="min-width: 1280px;">
			<!-- Start Header Navigation -->
			<div class="navbar-header navbar-logo">
				<button class="navbar-toggler" type="button" data-toggle="collapse"
					data-target="#navbar-menu" aria-controls="navbars-rs-food"
					aria-expanded="false" aria-label="Toggle navigation">
					<i class="fa fa-bars"></i>
				</button>
				<a class="navbar-brand" href="index.html"><img
					src="<c:url value='/template/web/images/logo.png'/> " class="logo"
					alt=""></a>
			</div>
			<!-- End Header Navigation -->

			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="collapse navbar-collapse" id="navbar-menu">
				<ul class="nav navbar-nav ml-auto" data-in="fadeInDown"
					data-out="fadeOutUp">
					<li class="nav-item "><a class="nav-link"
						href="web-home">Trang chủ</a></li>


					<li class="dropdown"><a href="#"
						class="nav-link dropdown-toggle arrow" data-toggle="dropdown">Áo
							nam</a>
						<ul class="dropdown-menu">
							<c:forEach var="i" items="${listCategoriesAo}">
								<li><a href="product-category?categoryId=${i.category_id}">${i.categoryName}</a></li>
							</c:forEach>


						</ul></li>
					<li class="dropdown"><a href="#"
						class="nav-link dropdown-toggle arrow" data-toggle="dropdown">Quần
							nam</a>
						<ul class="dropdown-menu">
							<c:forEach var="i" items="${listCategoriesQuan}">
								<li><a href="product-category?categoryId=${i.category_id}">${i.categoryName}</a></li>
							</c:forEach>

						</ul></li>
					<li class="nav-item"><a class="nav-link"
						href="about-store">Cửa hàng</a></li>
					<li class="dropdown">
						<a href="#"
						class="nav-link dropdown-toggle arrow" data-toggle="dropdown">
							<%
							if (name != null) {
							%> ${name} <%
							 } else {
							 %> Tài khoản <%
							 }
							 %> <i class="fa-solid fa-user" style="padding-left: 4px;"></i>
						</a>
						<ul class="dropdown-menu">
							<%
								if(name!=null){
							%>
							<li><a href="my-account?accountId=${accountId}">Thông tin tài khoản</a></li>
							<li><a href="cart">Giỏ hàng</a></li>
							<li><a href="log-out">Đăng xuất</a></li>
							<%		
								}else{%>
								<li><a href="cart">Giỏ hàng</a></li>
 								<li><a href="log-in">Đăng nhập</a></li>
							<%	
								}
							%>
 							
							<%-- <c:if test="${email != null}">
								<li><a href="log-out">Đăng xuất</a></li>
							</c:if> --%>
						</ul>
					</li>
					
				</ul>
			</div>
			<!-- /.navbar-collapse -->

			<!-- Start Atribute Navigation -->

			<div class="container__search menu-right-row">
				<form action="search" class="search" method="post">
					<input class="search__input" name="name-search" type="text" placeholder="Nhập tên, mã sản phẩm" >
					<button type="submit" class="search__icon">
						<i class="fa fa-search"></i>
					</button>
				</form>
			</div>

			<c:set var="size" value="${sessionScope.size}"/>  
			<!-- var="size" là biến để lấy dữ liệu ở dưới các thẻ, value="...size" là tên biến "size" lấy từ CartController -->
			<div class="side-menu menu-right-row " style="margin-left: 8px;">
				<a href="cart"> <i class="fa fa-shopping-bag"></i> <span
					class="badge" style="font-size: 16px;">(${size})</span>
				</a>
			</div>
			<!-- End Atribute Navigation -->
		</div>

	</nav>
	<!-- End Navigation -->
</header>
<!-- End Main Top -->