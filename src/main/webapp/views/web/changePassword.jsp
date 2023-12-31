<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Thay đổi mật khẩu</title>
<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css" rel="stylesheet">
</head>
<body>
	<%
		HttpSession ss = request.getSession();
		String currentPasswordInput = (String)ss.getAttribute("currentPasswordInput");
		String name = (String)ss.getAttribute("name");
		String email = (String)ss.getAttribute("email");
	%>
    <div class="container">
        <div class="view-account">
            <section class="module">
                <div class="module-inner">
                    <div class="side-bar">
                        <div class="user-info">
                            <ul class="meta list list-unstyled " style="color:#000000; font-weight: 700;">
                                <li class="name">${name}
                                    <label class="label label-info">${email}</label>
                                </li>
                            </ul>
                        </div>
                        <nav class="side-menu">
                            <ul class="nav">
                                <li class="active"><a href="my-account" class="text-dark"><span class="fa fa-user"></span> Hồ sơ</a></li>
                                <li><a href="order-page" class="text-dark"><span class="fa fa-credit-card"></span> Đơn mua</a></li>
                                <li><a href="#" class="text-dark"><i class="fa fa-key" aria-hidden="true"></i> Đổi mật khẩu</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="content-panel">
                        <form class="form-horizontal" action="change-password" method="post">
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                <h4 class="panel-title" style="font-size: 20px; font-weight: 600; color: #fe6232;">Thay đổi mật khẩu</h4>
                                </div>
                                <div class="panel-body">
                                  <div class="form-group">
                                  	<div>${currentPasswordInput}</div>
                                    <!-- <label class="col-sm-2 control-label">Mật khẩu hiện tại</label> -->
                                    <div class="col-sm-10">
                                      <input type="password" class="form-control" name="currentPass" placeholder="Nhập mật khẩu hiện tại">
                                    </div>
                                  </div>
                                  <div class="form-group">
<!--                                     <label class="col-sm-2 control-label">Mật khẩu mới</label>
 -->                                    <div class="col-sm-10">
                                      <input type="password" class="form-control" name="newPass" placeholder="Nhập mật khẩu mới">
                                    </div>
                                  </div>
                                  
                                  <div class="form-group">
                                    <div class="col-sm-10 col-sm-offset-2">
                                      <button type="submit" class="btn btn-danger">Submit</button>
                                      <!-- <button type="reset" class="btn btn-default">Cancel</button> -->
                                    </div>
                                  </div>
                                </div>
                              </div>
                            <hr>
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