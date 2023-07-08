<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Main css -->
<link rel="stylesheet"
	href="<c:url value='/template/admin/css/main.css'/> ">
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

</head>
<body>
	<!-- header -->
	<%@ include file="/common/admin/header.jsp"%>
	<!-- header -->

	<div>
		<dec:body />
	</div>

	<script type="text/javascript">
	(function () {
		"use strict";

		var treeviewMenu = $('.app-menu');

		// Toggle Sidebar
		$('[data-toggle="sidebar"]').click(function(event) {
			event.preventDefault();
			$('.app').toggleClass('sidenav-toggled');
		});

		// Activate sidebar treeview toggle
		$("[data-toggle='treeview']").click(function(event) {
			event.preventDefault();
			if(!$(this).parent().hasClass('is-expanded')) {
				treeviewMenu.find("[data-toggle='treeview']").parent().removeClass('is-expanded');
			}
			$(this).parent().toggleClass('is-expanded');
		});

		// Set initial active toggle
		$("[data-toggle='treeview.'].is-expanded").parent().toggleClass('is-expanded');

		//Activate bootstrip tooltips
		$("[data-toggle='tooltip']").tooltip();

	})();

	</script>
	
	<script type="text/javascript">
	document.addEventListener('DOMContentLoaded', function() {
		  const dropdownToggle = document.querySelector('.app-nav__item');
		  const profileDropdown = document.getElementById('profile-dropdown');

		  dropdownToggle.addEventListener('click', function() {
		    profileDropdown.classList.toggle('active');
		  });
		});
	
	</script>
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