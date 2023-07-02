<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng ký</title>
</head>
<body>
	<!-- Start body register -->
    <section class="pb-4 mt-5">
        <h2 style="text-align: center;">Đăng ký</h2>
        <div class="bg-white  rounded-5">
            <section class="w-100 p-4 d-flex justify-content-center pb-4">
                <form style="width: 22rem;" method="post" action="sign-up" id="login-form" class="login-form">
                    <!-- FullName input -->
                    <div class="form-outline mb-1">
                        <input type="text" id="form2Example1" class="form-control" name="fullName" required />
                        <label class="form-label" for="form2Example1">Họ và Tên</label>
                    </div>
                    
                    <!-- Email input -->
                    <div class="form-outline mb-1">
                        <input type="email" id="form2Example1" class="form-control" name="email" required/>
                        <label class="form-label" for="form2Example1">Email</label>
                    </div>
                    <!-- Password input -->
                    <div class="form-outline mb-1">
                        <input type="password" id="form2Example2" class="form-control" name="password" required/>
                        <label class="form-label" for="form2Example2">Mật khẩu</label>
                    </div>
                    <!-- Password input again -->
                    <div class="form-outline mb-1">
                        <input type="password" id="form2Example2" class="form-control" name="repeatPassword" />
                        <label class="form-label" for="form2Example2">Nhập lại mật khẩu</label>
                    </div>

                    <div id="field-gender" class="clearfix large_form">
                        <input id="radio1" type="radio" value="nu" name="gender" /> 
                        <label for="radio1">Nữ</label>
                        <input id="radio2" type="radio" value="nam" name="gender"/> 
                        <label for="radio2">Nam</label>
                    </div>
                    
                    <!-- Submit button -->
                    <button type="submit" class="btn btn-primary btn-block mb-4 btn-login">Đăng ký</button>

                    <!-- Register buttons -->
                    <div class="text-center">
                        <p>Bạn đã có tài khoản: <a href="log-in" style="font-size: 20px;">Đăng nhập</a></p>
                        <!-- <p>Hoặc đăng nhập với</p>
                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-facebook-f"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-google"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-twitter"></i>
                        </button>

                        <button type="button" class="btn btn-link btn-floating mx-1">
                            <i class="fab fa-github"></i>
                        </button> -->
                    </div>
                </form>
            </section>
        </div>
    </section>
    <!-- End body register -->
</body>
</html>