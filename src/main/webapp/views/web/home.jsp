<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Trang chủ</title>
</head>
<body>
	<%-- <%
	HttpSession ss = request.getSession();
	String email = (String)ss.getAttribute("email");
	String name = (String)ss.getAttribute("name");
	/* String name = ((String) ss.getAttribute("name"));
	String key = name == null ? "Đăng nhập" : name; */
	%>
	<h1>${email} </h1>
	<h1>${name} </h1> --%>
	    <!-- Start Slider -->
    <div id="slides-shop" class="cover-slides">
        <ul class="slides-container">
            <li class="text-left">
                <img src="<c:url value='/template/web/images/clothing-background1.jpg'/> " alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>Welcome To <br> D&L Clothing</strong></h1>
                            <!-- <p class="m-b-40">See how your users experience your website in realtime or view <br> trends
                                to see any changes in performance over time.</p> -->

                        </div>
                    </div>
                </div>
            </li>
            <li class="text-right">
                <img src="<c:url value='/template/web/images/clothing-background3.jpg'/>" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <!-- <h1 class="m-b-20"><strong>Welcome To <br> D&L Clothing</strong></h1>
                            <p class="m-b-40">See how your users experience your website in realtime or view <br> trends
                                to see any changes in performance over time.</p> -->
                            <h1 class="m-b-20"> <strong>NEW COLLECTION</strong></h1>
                        </div>
                    </div>
                </div>
            </li>
            <li class="text-center">
                <img src="<c:url value='/template/web/images/clothing-background2.jpg'/>" alt="">
                <div class="container">
                    <div class="row">
                        <div class="col-md-12">
                            <h1 class="m-b-20"><strong>IMPRESS WITH STYLE</strong></h1>
                            <p class="m-b-40">Fashion is what you're offered four times a year by designers. And style
                                is what you choose.</p>

                        </div>
                    </div>
                </div>
            </li>
        </ul>
        <div class="slides-navigation">
            <a href="#" class="next"><i class="fa fa-angle-right" aria-hidden="true"></i></a>
            <a href="#" class="prev"><i class="fa fa-angle-left" aria-hidden="true"></i></a>
        </div>
    </div>
    <!-- End Slider -->

    <!-- Start Categories  -->
    <div class="categories-shop" style="background-color:#f5f5f5;">
        <div class="container">
            <h2 class="category-text">Danh mục sản phẩm</h2>
            <div class="row">
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/aothun1.jpg'/> " alt=""
                            style="max-height: 290px; height: 100%;" />
                        <a class="btn hvr-hover" href="#">Áo Thun</a>
                    </div>
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/quanau.webp' /> " alt="" />
                        <a class="btn hvr-hover" href="#">Quần Âu</a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/somi.webp' /> " alt="" />
                        <a class="btn hvr-hover" href="#">Sơ Mi</a>
                    </div>
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/quankaki.webp' /> " alt="" />
                        <a class="btn hvr-hover" href="#">Quần Kaki</a>
                    </div>
                </div>
                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/polo.jpg' /> " alt="" />
                        <a class="btn hvr-hover" href="#">Áo Polo</a>
                    </div>
                    <div class="shop-cat-box shop-cat-box-custom">
                        <img class="img-fluid" src="<c:url value='/template/web/images/quanjean.jpg' /> " alt="" />
                        <a class="btn hvr-hover" href="#">Quần Jeans</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Categories -->

    <!-- Start All Products  -->
    <div class="products-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <div class="special-menu text-center">
                        <div class="button-group filter-button-group mb-5">
                            <button class="active" data-filter="*">Tất cả sản phẩm</button>
                        </div>
                    </div>
                </div>
            </div>

            <div class="row special-list">
                <div class="col-lg-3 col-md-6 special-grid best-seller">
                    <div class="products-single fix">
                        <div class="box-img-hover box-img-hover-custom">
                            <div class="type-lb">
                                <p class="sale">Sale</p>
                            </div>
                            <img src="<c:url value='/template/web/images/aopolo.webp' /> " class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="product-detail.html" data-toggle="tooltip" data-placement="right"
                                            title="View"><i class="fas fa-eye"></i></a></li>
                                </ul>
                                <a class="cart" href="#">Add to Cart</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Lorem ipsum dolor sit amet</h4>
                            <h5> $7.79</h5>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 special-grid top-featured">
                    <div class="products-single fix">
                        <div class="box-img-hover box-img-hover-custom">
                            <!-- <div class="type-lb">
                                <p class="new">New</p>
                            </div> -->
                            <img src="<c:url value='/template/web/images/aothun1.jpg' /> " class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i
                                                class="fas fa-eye"></i></a></li>
                                </ul>
                                <a class="cart" href="#">Add to Cart</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Lorem ipsum dolor sit amet</h4>
                            <h5> $9.79</h5>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 special-grid top-featured">
                    <div class="products-single fix">
                        <div class="box-img-hover box-img-hover-custom">
                            <div class="type-lb">
                                <p class="sale">Sale</p>
                            </div>
                            <img src="<c:url value='/template/web/images/quanjean.jpg' /> " class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i
                                                class="fas fa-eye"></i></a></li>

                                </ul>
                                <a class="cart" href="#">Add to Cart</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Lorem ipsum dolor sit amet</h4>
                            <h5> $10.79</h5>
                        </div>
                    </div>
                </div>

                <div class="col-lg-3 col-md-6 special-grid best-seller">
                    <div class="products-single fix">
                        <div class="box-img-hover box-img-hover-custom">
                            <div class="type-lb">
                                <p class="sale">Sale</p>
                            </div>
                            <img src="<c:url value='/template/web/images/quankaki.jpg' /> " class="img-fluid" alt="Image">
                            <div class="mask-icon">
                                <ul>
                                    <li><a href="#" data-toggle="tooltip" data-placement="right" title="View"><i
                                                class="fas fa-eye"></i></a></li>

                                </ul>
                                <a class="cart" href="#">Add to Cart</a>
                            </div>
                        </div>
                        <div class="why-text">
                            <h4>Lorem ipsum dolor sit amet</h4>
                            <h5> $15.79</h5>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Products  -->
</body>
</html>