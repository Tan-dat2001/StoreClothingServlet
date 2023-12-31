<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Trang chủ" /></title>

    <!-- css -->
    <link href="<c:url value='/template/web/assets/favicon.ico'/>">
<%--     <link href="<c:url value='/template/web/css/styles.css' />" rel="stylesheet" type="text/css" media="all"/>
 --%>    <!-- Site Icons -->
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
    <link rel="stylesheet" href="<c:url value='/template/web/css/my-account.css'/> ">
    <link rel="stylesheet" href="<c:url value='/template/web/css/orderPage.css'/> ">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css" 
    crossorigin="anonymous" />
<!--     <link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet"> -->
<!--      <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">  -->
</head>
<body>
	<!-- header -->
    <%@ include file="/common/web/header.jsp" %>
    <!-- header -->
    
    <div>
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
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery-ui.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/jquery.nicescroll.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/form-validator.min.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/contact-form-script.js' />"></script>
	<script type="text/javascript" src="<c:url value='/template/web/js/custom.js' />"></script>
</body>
</html>