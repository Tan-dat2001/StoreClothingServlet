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
                    <h2>Thanh Toán</h2>
                    <ul class="breadcrumb">
                        <li class="breadcrumb-item"><a href="#">Trang chủ</a></li>
                        <li class="breadcrumb-item active">Thanh toán</li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <!-- End All Title Box -->

    <!-- Start Cart  -->
    <div class="cart-box-main">
        <div class="container">
            
            <div class="row">
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="checkout-address">
                        <div class="title-left">
                            <h3>Địa chỉ nhận hàng</h3>
                        </div>
                        <form class="needs-validation" novalidate>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="firstName">Tên *</label>
                                    <input type="text" class="form-control" id="firstName" placeholder="" value=""
                                        required>
                                    <div class="invalid-feedback"> Valid first name is required. </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="lastName">Họ *</label>
                                    <input type="text" class="form-control" id="lastName" placeholder="" value=""
                                        required>
                                    <div class="invalid-feedback"> Valid last name is required. </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="username">Số điện thoại *</label>
                                <div class="input-group">
                                    <input type="text" class="form-control" id="username" placeholder="" required>
                                    <div class="invalid-feedback" style="width: 100%;"> Your username is required.
                                    </div>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="email">Email *</label>
                                <input type="email" class="form-control" id="email" placeholder="">
                                <div class="invalid-feedback"> Please enter a valid email address for shipping updates.
                                </div>
                            </div>
                            <div class="mb-3">
                                <label for="address">Địa chỉ *</label>
                                <input type="text" class="form-control" id="address" placeholder="" required>
                                <div class="invalid-feedback"> Please enter your shipping address. </div>
                            </div>
                            <div class="mb-3">
                                <label for="address2">Ghi chú</label>
                                <input type="text" class="form-control" id="address2" placeholder="">
                            </div>

                            <hr class="mb-4">
                            <div class="title"> <span style="font-weight: bolder;">Phương thức thanh toán</span> </div>
                            <div class="d-block my-3">
                                <div class="custom-control custom-radio">
                                    <input id="credit" name="paymentMethod" type="radio" class="custom-control-input"
                                        checked required>
                                    <label class="custom-control-label" for="credit">Thẻ tín dụng</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="debit" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="debit">Thẻ ghi nợ</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="momo" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="momo">Momo</label>
                                </div>
                                <div class="custom-control custom-radio">
                                    <input id="cod" name="paymentMethod" type="radio" class="custom-control-input"
                                        required>
                                    <label class="custom-control-label" for="cod">Thanh toán khi nhận Hàng</label>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-6 mb-3">
                                    <label for="cc-name">Tên thẻ</label>
                                    <input type="text" class="form-control" id="cc-name" placeholder="" required> <small
                                        class="text-muted">Vui lòng điền đầy đủ như trên thẻ</small>
                                    <div class="invalid-feedback"> Name on card is required </div>
                                </div>
                                <div class="col-md-6 mb-3">
                                    <label for="cc-number">Số thẻ</label>
                                    <input type="text" class="form-control" id="cc-number" placeholder="" required>
                                    <div class="invalid-feedback"> Credit card number is required </div>
                                </div>
                            </div>
                            <div class="row">
                                <div class="col-md-3 mb-3">
                                    <label for="cc-expiration">Ngày hết hạn</label>
                                    <input type="text" class="form-control" id="cc-expiration" placeholder="" required>
                                    <div class="invalid-feedback"> Expiration date required </div>
                                </div>
                                <div class="col-md-3 mb-3">
                                    <label for="cc-expiration">CVV</label>
                                    <input type="text" class="form-control" id="cc-cvv" placeholder="" required>
                                    <div class="invalid-feedback"> Security code required </div>
                                </div>

                            </div>
                        </form>
                    </div>
                </div>
                <div class="col-sm-6 col-lg-6 mb-3">
                    <div class="row">
                        <div class="col-md-12 col-lg-12">
                            <div class="shipping-method-box">
                                <div class="title-left">
                                    <h3>Phương thức vận chuyển</h3>
                                </div>
                                <div class="mb-4">
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption1" name="shipping-option" class="custom-control-input"
                                            checked="checked" type="radio">
                                        <label class="custom-control-label" for="shippingOption1">Giao hàng tiêu
                                            chuẩn</label> <span class="float-right font-weight-bold">FREE</span>
                                    </div>
                                    <div class="ml-4 mb-2 small">(3-7 ngày)</div>
                                    <div class="custom-control custom-radio">
                                        <input id="shippingOption2" name="shipping-option" class="custom-control-input"
                                            type="radio">
                                        <label class="custom-control-label" for="shippingOption2">Giao hàng
                                            nhanh</label> <span class="float-right font-weight-bold">$10.00</span>
                                    </div>
                                    <div class="ml-4 mb-2 small">(2-4 business days)</div>
                                    
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="odr-box">
                                <div class="title-left">
                                    <h3>Sản phẩm</h3>
                                </div>
                                <div class="rounded p-2 bg-light">
                                    <div class="media mb-2 border-bottom">
                                        <div class="media-body"> <a href="detail.html"> Lorem ipsum dolor sit amet</a>
                                            <div class="small text-muted">Giá: $80.00 <span class="mx-2">|</span> Số lượng:
                                                1 <span class="mx-2">|</span> Tổng: $80.00</div>
                                        </div>
                                    </div>
                                    <div class="media mb-2 border-bottom">
                                        <div class="media-body"> <a href="detail.html"> Lorem ipsum dolor sit amet</a>
                                            <div class="small text-muted">Giá: $60.00 <span class="mx-2">|</span> Số lượng:
                                                1 <span class="mx-2">|</span> Tổng: $60.00</div>
                                        </div>
                                    </div>
                                    <div class="media mb-2">
                                        <div class="media-body"> <a href="detail.html"> Lorem ipsum dolor sit amet</a>
                                            <div class="small text-muted">Giá: $40.00 <span class="mx-2">|</span> Số lượng:
                                                1 <span class="mx-2">|</span> Tổng: $40.00</div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-12 col-lg-12">
                            <div class="order-box">
                                <div class="title-left">
                                    <h3>Đơn hàng của bạn</h3>
                                </div>
                                <div class="d-flex">
                                    <div class="font-weight-bold">Sản phẩm</div>
                                    <div class="ml-auto font-weight-bold">Tổng</div>
                                </div>
                                <hr class="my-1">
                                <div class="d-flex">
                                    <h4>Tổng tạm tính</h4>
                                    <div class="ml-auto font-weight-bold"> $ 440 </div>
                                </div>
                                <div class="d-flex">
                                    <h4>Giảm giá</h4>
                                    <div class="ml-auto font-weight-bold"> $ 40 </div>
                                </div>
                                <hr class="my-1">
                                <div class="d-flex">
                                    <h4>Mã giảm</h4>
                                    <div class="ml-auto font-weight-bold"> $ 10 </div>
                                </div>
                                <div class="d-flex">
                                    <h4>Thuế</h4>
                                    <div class="ml-auto font-weight-bold"> $ 2 </div>
                                </div>
                                <div class="d-flex">
                                    <h4>Chi phí vận chuyển</h4>
                                    <div class="ml-auto font-weight-bold"> Free </div>
                                </div>
                                <hr>
                                <div class="d-flex gr-total">
                                    <h5>Tổng thanh toán</h5>
                                    <div class="ml-auto h5"> $ 388 </div>
                                </div>
                                <hr>
                            </div>
                        </div>
                        <div class="col-12 d-flex shopping-box"> <a href="order-detail.html"
                                class="ml-auto btn hvr-hover">Đặt hàng</a> </div>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- End Cart -->
</body>
</html>