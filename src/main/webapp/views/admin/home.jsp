<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Home</title>
</head>
<body>
	<main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i>Tất cả sản phẩm</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-plus-square-o fa-lg"></i></li>
            <li class="breadcrumb-item active"><a href="admin-addProduct">Thêm Sản phẩm</a></li>
          </ul>
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="sampleTable" style="width: 100%;">
                  <thead>
                    <tr>
                      <th class="col-custom">ID</th>
                      <th class="col-custom">Tên Sản phẩm</th>
                      <th class="col-custom">Loại sản phẩm</th>
                      <th class="col-custom">Số lượng trong kho</th>
                      <th class="col-custom">Đã bán</th>
                      <th class="col-custom">Mô Tả</th>
                      <th class="col-custom">Hình ảnh</th>
                      <th class="col-custom">Mã Giảm giá</th>
                      <th class="col-custom">Trạng thái</th>
                      <th class="col-custom">Tác Vụ</th>
                    </tr>
                  </thead>
                  <tbody>
                   	<c:forEach var="product" items="${listProducts}">
	                    <tr>
	                      <td>${product.product_id}</td>
	                      <td>${product.productName}</td>
	                      <td>${product.category_id}</td>
	                      <td>${product.quantity - product.purchases}</td>
	                      <td>${product.purchases }</td>
	                      <td>${product.productDesc }</td>
	                      <td>${product.productImage }</td>
	                      <td>${product.discount_id }</td>
	                      <td>${product.status }</td>
	                      <td> <a href="admin-delete?productId=${product.product_id}">XÓA</a>||<a href="admin-editProduct?productId=${product.product_id}">SỬA</a></td>
	                    </tr>	
                  	</c:forEach> 
                    
                  </tbody>
                </table>
              </div>
            </div>
          	<nav aria-label="Page navigation example"
				style="display: flex; justify-content: center; margin-bottom: 30px;">
				<ul class="pagination ">
					<c:forEach var="i" begin="1" end="${endPage}">
						<li class="page-item"><a class="page-link ${index == i ? 'active-pagination':''}" href="admin-home?index=${i}">${i}</a></li>
					</c:forEach>
				</ul>
			</nav>
          </div>
        </div>
      </div>
    </main>

</body>
</html>