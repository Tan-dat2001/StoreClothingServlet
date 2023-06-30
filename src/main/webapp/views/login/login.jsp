<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><dec:title default="Đăng Nhập"/></title>
</head>
<body>
	<div class="pb-4 mt-5 ">
        <h2 style="text-align: center;">Đăng nhập</h2>
        <div class="bg-white  rounded-5" >
            <section class="w-100 p-4 d-flex justify-content-center pb-4">
                <form style="width: 22rem;">
                    <!-- Email input -->
                    <div class="form-outline mb-4">
                      <input type="email" id="form2Example1" class="form-control" name="email" />
                      <label class="form-label" for="form2Example1">Email</label>
                    </div>
                  
                    <!-- Password input -->
                    <div class="form-outline mb-4">
                      <input type="password" id="form2Example2" class="form-control" name="password"/>
                      <label class="form-label" for="form2Example2">Mật khẩu</label>
                    </div>
                  
                    <!-- 2 column grid layout for inline styling -->
                    <div class="row mb-4">
                      <div class="col d-flex justify-content-center">
                        <!-- Checkbox -->
                        <div class="form-check">
                          <input class="form-check-input" type="checkbox" value="" id="form2Example31" checked />
                          <label class="form-check-label" for="form2Example31"> Remember me </label>
                        </div>
                      </div>
                  
                      <div class="col">
                        <!-- Simple link -->
                        <a href="#!">Forgot password?</a>
                      </div>
                    </div>
                  
                    <!-- Submit button -->
                    <button type="button" class="btn btn-primary btn-block mb-4 btn-login" >Đăng nhập</button>
                  
                    <!-- Register buttons -->
                    <div class="text-center">
                      <p>Not a member? <a href="register.html">Đăng ký</a></p>
                      <p>or sign up with:</p>
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
                      </button>
                    </div>
                  </form>   
            </section>
        </div>
    </div>
</body>
</html>