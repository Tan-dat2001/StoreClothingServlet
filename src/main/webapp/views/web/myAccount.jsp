<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<%@ page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Tài khoản của tôi</title>
<link href="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
<%
	HttpSession ss = request.getSession();
	String name = (String)ss.getAttribute("name");
	String email = (String)ss.getAttribute("email");
	String gender = (String)ss.getAttribute("gender");
	String address = (String)ss.getAttribute("address");
	String phone = (String)ss.getAttribute("phone");
	String dateOfBirth = (String)ss.getAttribute("dateOfBirth");
%>
<div class="container">
        <div class="view-account">
            <section class="module">
                <div class="module-inner">
                    <div class="side-bar">
                        <div class="user-info">
                            <ul class="meta list list-unstyled">
                                <li class="name">${name}
                                    <label class="label label-info">${email}</label>
                                </li>
                            </ul>
                        </div>
                        <nav class="side-menu">
                            <ul class="nav">
                                <li class="active"><a href="#"><span class="fa fa-user"></span> Hồ sơ</a></li>
                                <li><a href="order-page"><span class="fa fa-credit-card"></span> Đơn mua</a></li>
                                <li><a href="change-password"><i class="fa fa-key" aria-hidden="true"></i> Đổi mật khẩu</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="content-panel">
                        <form class="form-horizontal" action="my-account?accountId=${accountId}" method="post">
                            <fieldset class="fieldset">
                                <h3 class="fieldset-title">Thông tin tài khoản</h3>

                                <div class="form-group">
                                    <label class="col-md-2 col-sm-3 col-xs-12 control-label">Họ tên</label>
                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" value="${name}" name="fullName">
                                    </div>
                                </div>

                                <div class="form-group">
                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label" >Email</label>
                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                        <input type="email" class="form-control" name="email" value="${email}" >
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label" >Địa chỉ</label>
                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                        <input type="text" class="form-control" name="address" value="${address}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label" for="phone">Số điện thoại</label>
                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                        <input type="tel" class="form-control" id="phone" name="phone" value="${phone}">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-md-2  col-sm-3 col-xs-12 control-label" for="gender"
                                        style="margin-right: 20px;">Giới tính:</label>
                                    <select id="gender" name="gender" style="font-size: 18px; margin-top: 8px;">
                                        <option name="gender" value="nam">Nam</option>
                                        <option name="gender" value="nữ">Nữ</option>
                                    </select>
                                </div>
                                
                                <div class="form-group">
                                    <label for="dob" class="col-md-2  col-sm-3 col-xs-12 control-label">Ngày sinh:</label>
                                    <div class="col-md-10 col-sm-9 col-xs-12">
                                        <input type="date" id="dob" name="dob" value="${sqlDate}" >
                                    </div>
                                  </div>

                            </fieldset>
                            <hr>
                            <div class="form-group">
                                <div class="col-md-10 col-sm-9 col-xs-12 col-md-push-2 col-sm-push-3 col-xs-push-0">
                                    <input class="btn btn-primary" type="submit" value="Update Profile">
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </section>
        </div>
    </div>
    <script data-cfasync="false" src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
    <script src="https://netdna.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript"></script>
</body>
</html>