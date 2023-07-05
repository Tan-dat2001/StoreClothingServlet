<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- Start All Title Box -->
    <div class="all-title-box">
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                    <h2>Chi tiết sản phẩm</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                        <li class="breadcrumb-item active"> Chi tiết sản phẩm </li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Detail  -->
    <div class="shop-detail-box-main">
        <div class="container">
            <div class="row">
                <div class="col-xl-5 col-lg-5 col-md-6">
                    <div id="carousel-example-1" class="single-product-slider carousel slide" data-ride="carousel">
                        <div class="carousel-inner" role="listbox">
                            <div class="carousel-item active"> <img class="d-block w-100" src="${productDetail.productImage}"
                                    alt="First slide"> </div>
                            <div class="carousel-item"> <img class="d-block w-100" src="${productDetail.productImage}"
                                    alt="Second slide"> </div>
                            <div class="carousel-item"> <img class="d-block w-100" src="${productDetail.productImage}"
                                    alt="Third slide"> </div>
                        </div>
                        <a class="carousel-control-prev" href="#carousel-example-1" role="button" data-slide="prev">
                            <i class="fa fa-angle-left" aria-hidden="true"></i>
                            <span class="sr-only">Previous</span>
                        </a>
                        <a class="carousel-control-next" href="#carousel-example-1" role="button" data-slide="next">
                            <i class="fa fa-angle-right" aria-hidden="true"></i>
                            <span class="sr-only">Next</span>
                        </a>
                        <!-- <ol class="carousel-indicators">
                            <li data-target="#carousel-example-1" data-slide-to="0" class="active">
                                <img class="d-block w-100 img-fluid" src="images/somiWhite1-1.jpg" alt="" />
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="1">
                                <img class="d-block w-100 img-fluid" src="images/somiWhite1-2.jpg" alt="" />
                            </li>
                            <li data-target="#carousel-example-1" data-slide-to="2">
                                <img class="d-block w-100 img-fluid" src="images/somiWhite1-3.jpg" alt="" />
                            </li>
                        </ol> -->
                    </div>
                </div>
                <div class="col-xl-7 col-lg-7 col-md-6">
                    <div class="single-product-details">
                        <h2>${productDetail.productName}</h2>
<%--                         <h5><del>${productDetail.productPrice * 1.2}</del> ${productDetail.productPrice}</h5>
 --%>
                        <h5><del>${productDetail.productPrice * 1.2}</del> ${productDetail.productPrice}</h5>
                        
                        <p class="available-stock"><span> Kho: ${productDetail.quantity} / <a href="#">Đã bán: 78 </a></span></p>            
                        <h4>Thông tin sản phẩm:</h4>
                        <p><${productDetail.productDesc}</p>
                        <ul>
                            <li>
                                <div class="form-group size-st">
                                    <label class="size-label">Size</label>
                                    <select id="basic" class="selectpicker show-tick form-control">
                                        <option value="0">Size</option>
                                        <option value="S">S</option>
                                        <option value="M">M</option>
                                        <option value="L">L</option>
                                        <option value="XL">XL</option>
                                    </select>
                                </div>
                            </li>
                            <li>
                                <div class="form-group quantity-box">
                                    <label class="control-label">Số lượng</label>
                                    <input class="form-control" value="0" min="0" max="" type="number" name="quantity">
                                </div>
                            </li>
                        </ul>

                        <div class="price-box-bar">
                            <div class="cart-and-bay-btn">
                                <a class="btn hvr-hover" data-fancybox-close="" href="#">Mua Ngay</a>
                                <a class="btn hvr-hover" data-fancybox-close="" href="addtocart?productId=${productDetail.product_id}&quantity=1">Thêm Vào Giỏ Hàng</a>
                            </div>
                        </div>


                    </div>
                </div>
            </div>

            <div class="row my-5">
                <div class="col-lg-12">
                    <div class="title-all text-center">
                        <h2 class="title-related-products" >Sản phẩm liên quan</h2>
                    </div>
                    <div class="featured-products-box owl-carousel owl-theme">
                    	<c:forEach var="product" items="${listProducts}">                     	
	                        <div class="item">
	                            <div class="products-single fix">
	                                <div class="box-img-hover box-img-hover-custom" style="max-height: 300px;">
	                                    <img src="${product.productImage}" class="img-fluid" alt="Image">
	                                    <div class="mask-icon">
	                                        <ul>
	                                            <li><a href="cart?productId=${product.product_id}" data-toggle="tooltip" data-placement="right" title="View"><i
	                                                        class="fas fa-eye"></i></a></li>
	                                        
	                                        </ul>
	                                        <a class="cart" href="#">Add to Cart</a>
	                                    </div>
	                                </div>
	                                <div class="why-text">
	                                    <h4>${product.productName}</h4>
	                                    <h5>${product.productPrice}</h5>
	                                </div>
	                            </div>
	                        </div>
                    	</c:forEach>
                        
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->
    
        <a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
    
</body>
</html>