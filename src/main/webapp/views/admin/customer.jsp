<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<%@ page import="com.clothingstore.model.Account"%>
<%@ page import="java.util.List"%>
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
          <h1><i class="fa fa-th-list"></i> KHÁCH HÀNG</h1>
        </div>
       
      </div>
      <div class="row">
        <div class="col-md-12">
          <div class="tile">
            <div class="tile-body">
              <div class="table-responsive">
                <table class="table table-hover table-bordered" id="sampleTable">
                  <thead>
                    <tr>
                      <th>STT</th> 
                      <th>ID</th>
                      <th>Email</th>
                      <th>Họ Tên</th>
                      <th>Mật Khẩu</th>
                      <th>Số Điện Thoại</th>
                      <th>Địa Chỉ</th>
                      <th>Ngày Sinh</th>
                      <th>Giới Tính</th>
                      <th>Trạng Thái</th>
                      <th>Tác vụ</th>
                    </tr>
                  </thead>
                  <tbody>
                   <%--  <c:set var="t" value="0" />
                  	<c:forEach var="account" items="accounts">
					<c:set var="t" value="${t+1}" />
	                    <tr>
	                      <td>${t}</td>
	                      <td>${account.account_id}</td>
	                      <td>${account.email }</td>
	                      <td>${account.name }</td>
	                      <td>${account.password }</td>
	                      <td>${account.phone }</td>
	                      <td>${account.address }</td>
	                      <td>${account.dateOfBirth }</td>
	                      <td>${account.gender }</td>
	                      <td>${account.status }</td>
	                      <td><a href="#">XÓA</a>||<a href="#">SỬA</a></td>
	                    </tr>
                  	
                  	</c:forEach> --%>
                  	<%
                  		int i=0;
                  		List<Account> accounts = (List<Account>)request.getAttribute("accounts");
                  		if(accounts != null){
                  			for(Account account:accounts){%>
                  			<tr>
                  				<td><%=i+1 %></td>
			                      <td><%=account.getAccount_id() %></td>
			                      <td><%=account.getEmail() %></td>
			                      <td><%=account.getName() %></td>
			                      <td><%=account.getPassword()%></td>
			                      <td><%=account.getPhone()%></td>
			                      <td><%=account.getAddress()%></td>
			                      <td><%=account.getDateOfBirth() %></td>
			                      <td><%=account.getGender() %></td>
			                      <td><%=account.getStatus() %></td>
			                      <td><a href="#">XÓA</a>||<a href="#">SỬA</a></td>
			                <tr>
                  	<%		}
                  		}
                  	
                  	%>
                    
                 
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </main>
</body>
</html>