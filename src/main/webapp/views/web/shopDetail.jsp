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
                    <h2>Shop</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Home</a></li>
                        <li class="breadcrumb-item active">Shop</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Shop Page  -->
    <div class="shop-box-inner">
        <div class="container">
            <div class="row">
                <div class="col-xl-3 col-lg-3 col-sm-12 col-xs-12 sidebar-shop-left product-categori-custom-parent ">
                    <div class="product-categori product-categori-custom-child">
                        <div class="filter-sidebar-left">
                            <div class="title-left">
                                <h3>Danh mục sản phẩm</h3>
                            </div>
                            <div class="list-group list-group-collapse list-group-sm list-group-tree" id="list-group-men" data-children=".sub-men">
                                <div class="list-group-collapse sub-men">
                                    <a class="list-group-item list-group-item-action" href="#sub-men1" data-toggle="collapse" aria-expanded="true" aria-controls="sub-men1">Áo nam</a>
                                    <div class="collapse show" id="sub-men1" data-parent="#list-group-men">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item list-group-item-action active">Áo polo</a>
                                            <a href="#" class="list-group-item list-group-item-action">Áo thun</a>
                                            <a href="#" class="list-group-item list-group-item-action">Áo sơ mi</a>
                                            <a href="#" class="list-group-item list-group-item-action">Áo khoác</a>
                                        </div>
                                    </div>
                                </div>
                                <div class="list-group-collapse sub-men">
                                    <a class="list-group-item list-group-item-action" href="#sub-men2" data-toggle="collapse" aria-expanded="false" aria-controls="sub-men2">Quần nam</a>
                                    <div class="collapse" id="sub-men2" data-parent="#list-group-men">
                                        <div class="list-group">
                                            <a href="#" class="list-group-item list-group-item-action">Quần âu </a>
                                            <a href="#" class="list-group-item list-group-item-action">Quần jeans</a>
                                            <a href="#" class="list-group-item list-group-item-action">Quần kaki </a>
                                            <a href="#" class="list-group-item list-group-item-action">Quần short </a>

                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="filter-price-left">
                            <div class="title-left">
                                <h3>Price</h3>
                            </div>
                            <div class="price-box-slider">
                                <div id="slider-range"></div>
                                <p>
                                    <input type="text" id="amount" readonly style="border:0; color:#fbb714; font-weight:bold;">
                                    <button class="btn hvr-hover" type="submit">Filter</button>
                                </p>
                            </div>
                        </div>
                        
                    </div>
                </div>
                <div class="col-xl-9 col-lg-9 col-sm-12 col-xs-12 shop-content-right">
                    <div class="right-product-box">
                        <div class="product-item-filter row">
                            <div class="col-12 col-sm-8 text-center text-sm-left">
                                <div class="toolbar-sorter-right">
                                    <span>Sort by </span>
                                    <select id="basic" class="selectpicker show-tick form-control" data-placeholder="$ USD">
									<option data-display="Select">Nothing</option>
									<option value="1">Mới nhất</option>
									<option value="2">Cũ nhất</option>
									<option value="3">Giá tăng dần</option>
									<option value="4">Giá giảm dần</option>
									<option value="5">A - Z</option>
									<option value="6">Z - A</option>
								</select>
                                </div>
                            </div>
                        </div>
                        <div class="row product-categorie-box">
                            <div class="tab-content">
                                <div role="tabpanel" class="tab-pane fade show active" id="grid-view">
                                    <div class="row">
                                        <div class="col-sm-6 col-md-6 col-lg-4 col-xl-4">
                                            <div class="products-single fix">
                                                <div class="box-img-hover">
                                                    <div class="type-lb">
                                                        <p class="sale">Sale</p>
                                                    </div>
                                                    <img  src="images/aopolo.webp" class="img-fluid image-product" alt="Image">
                                                    <div class="mask-icon">
                                                        <ul>
                                                            <li><a href="#" data-toggle="tooltip" data-placement="right" title="Xem"><i class="fas fa-eye"></i></a></li>
                                                        </ul>
                                                        <a class="cart" href="#">Thêm vào giỏ hàng</a>
                                                    </div>
                                                </div>
                                                <div class="why-text truncate">
                                                    <a href="product-detail.html">
                                                        <h4>Áo sơ mi ngắn tay họa tiết Leaves Pattern 1.DSTB600</h4>
                                                        <h5> $9.79</h5>
                                                    </a>
                                                </div>
                                            </div>
                                        </div>
                                        
                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- End Shop Page -->    
	<a href="#" id="back-to-top" title="Back to top" style="display: none;">&uarr;</a>
</body>
</html>