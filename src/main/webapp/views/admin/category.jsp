<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@include file="/common/taglib.jsp" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<main class="app-content">
      <div class="app-title">
        <div>
          <h1><i class="fa fa-th-list"></i> DANH MỤC SẢN PHẨM</h1>
        </div>
        <ul class="app-breadcrumb breadcrumb">
            <li class="breadcrumb-item"><i class="fa fa-plus-square-o fa-lg"></i></li>
            <li class="breadcrumb-item active"><a href="admin-addProduct">Thêm sản phẩm</a></li>
          </ul>
      </div>
     

      <div class="row">

        <div class="col-md-9">
            <div class="tile">
            <div class="heading" style="font-size:20px; font-weight: 600; margin-bottom: 4px;">Danh mục</div>
              <div class="tile-body">
                <div class="table-responsive">
                  <table class="table table-hover table-bordered" id="sampleTable">
                    <thead>
                      <tr>
                        <th>STT</th> 
                        <th>ID</th>
                        <th>Danh mục sản phẩm</th>
                        <th>Tác Vụ</th>
                       
                      </tr>
                    </thead>
                    <tbody>
                    	<c:set var="t" value="0" />
                    	<c:forEach var="category" items="${categories}">
                    	<c:set var="t" value="${t+1}" />
	                      <tr>
	                        <td>${t}</td>
	                        <td>${category.category_id}</td>
	                        <td>${category.categoryName}</td>
	                        <%-- <td> <a href="admin-deleteCategory?categoryId=${category.category_id}">XÓA</a>||<a href="admin-editCategory?categoryId=${category.category_id}">SỬA</a></td> --%>
	                        <td> <a href="admin-deleteCategory?categoryId=${category.category_id}">XÓA</a></td>
	                      </tr>                    	
                    	</c:forEach>
                    
                   
                    </tbody>
                  </table>
                </div>
              </div>
            </div>
          </div>

          <div class="col-md-3">
            <div class="tile">
                <div class="heading" style="font-size:20px; font-weight: 600; margin-bottom: 4px;">Thêm danh mục</div>
              <div class="tile-body">
                <form action="admin-addCategory" method="post"  class="add-brand-list">
                  <input type="hidden" name="categoryId"  value="0">
                  <input type="text" name="categoryName" placeholder="nhập tên danh mục">
                  <input type="submit" value="Thêm">
              </form>
              </div>
            </div>
            
            <div class="tile">
                <div class="heading" style="font-size:20px; font-weight: 600; margin-bottom: 4px;">Sửa danh mục</div>
              <div class="tile-body">
                <form action="admin-editCategory" method="post"  class="add-brand-list">
                  <input type="text" name="categoryId" placeholder="nhập ID danh mục cần sửa">
                  <input type="text" name="categoryName" placeholder="nhập tên danh mục ">
                  <input type="submit" value="Sửa">
              </form>
              </div>
            </div>
          </div>
          
      </div>



    </main>
</body>
</html>