
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body class="app sidebar-mini">
<%
	HttpSession ss = request.getSession();
	String name = (String)ss.getAttribute("name");
%>
	<header class="app-header">
		<a class="app-header__logo" href="../../pages/AdminView/index.html">Admin</a>
		<!-- Sidebar toggle button-->
		<a class="app-sidebar__toggle" href="#" data-toggle="sidebar"
			aria-label="Hide Sidebar"></a>
		<h3 style="margin-top:10px;">Xin chào Admin: ${name}</h3>	
		<!-- Navbar Right Menu-->
		<ul class="app-nav">
			<li class="app-search"><input class="app-search__input"
				type="search" placeholder="Search">
				<button class="app-search__button">
					<i class="fa fa-search"></i>
				</button></li>


			<!-- User Menu-->
			<li class="dropdown">
				<a class="app-nav__item" href="#" data-toggle="dropdown" aria-label="Open Profile Menu"><i
					class="fa fa-user fa-lg"></i></a>
				<ul id="profile-dropdown" class="dropdown-menu settings-menu dropdown-menu-right">
					<li><a class="dropdown-item" href="page-user.html"><i
							class="fa fa-cog fa-lg"></i> Cài đặt</a></li>
					<li><a class="dropdown-item" href="page-user.html"><i
							class="fa fa-user fa-lg"></i> Thông tin tài khoản</a></li>
					<li><a class="dropdown-item" href="log-out"><i
							class="fa fa-sign-out fa-lg"></i> Đăng xuất</a></li>
				</ul></li>
		</ul>
	</header>


	<!-- Sidebar menu-->
	<div class="app-sidebar__overlay" data-toggle="sidebar"></div>
	<aside class="app-sidebar">
		<div class="app-sidebar__user" style="width: 600px;">
			<img style="background-color: white;"
				class="app-sidebar__user-avatar"
				src="<c:url value='/template/admin/images/logo.png' /> "
				alt="User Image">

		</div>

		<ul class="app-menu">
			<li><a class="app-menu__item" href="admin-home"><i
					class="app-menu__icon fa fa-laptop"></i><span
					class="app-menu__label">Quản lý sản phẩm</span></a>
			<li><a class="app-menu__item" href="admin-category"><i
					class="app-menu__icon fa fa-pie-chart"></i><span
					class="app-menu__label">Quản lý danh mục </span></a></li>
			<li><a class="app-menu__item" href="admin-customer"><i
					class="app-menu__icon fa fa-pie-chart"></i><span
					class="app-menu__label">Quản lý khách Hàng</span></a></li>
			<li><a class="app-menu__item" href="admin-order"><i
					class="app-menu__icon fa fa-pie-chart"></i><span
					class="app-menu__label">Quản lý đơn hàng </span></a></li>
		</ul>
	</aside>

	
	<!-- Essential javascripts for application to work-->
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/jquery-3.3.1.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/popper.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/bootstrap.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/main.js'/>"></script>
	<!-- The javascript plugin to display page loading on top-->
	<script type="text/javascript"
		src="<c:url value='/template/admin/js/plugins/pace.min.js'/>"></script>
</body>
</html>