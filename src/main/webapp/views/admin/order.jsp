<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp"%>

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
				<h1>
					<i class="fa fa-th-list"></i> ĐƠN HÀNG
					<c:if test="${not empty successMessage}">
						<div class="success-message">${successMessage}</div>
					</c:if>

					<c:if test="${not empty errorMessage}">
						<div class="error-message">${errorMessage}</div>
					</c:if>

				</h1>
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
										<th>ID đơn hàng</th>
										<th>ID tài khoản</th>
										<th>Tên khách hàng</th>
										<th>Ngày đặt hàng</th>
										<th>Trạng thái</th>
										<th>Thanh toán</th>
										<th>Tổng tiền</th>
										<th>Ngày cập nhật</th>
										<th>Tác vụ</th>
									</tr>
								</thead>
								<tbody>
									<c:set var="num" value="0" />
									<c:forEach var="o" items="${listOrders}">
										<c:set var="num" value="${num+1}" />
										<tr>
											<td>${num}</td>
											<td>#${o.order_id}</td>
											<td>#${o.account_id }</td>
											<c:forEach var="acc" items="${listAccounts}">
												<c:if test="${acc.account_id == o.account_id}">
													<c:set var="accountName" value="${acc.name}" />
												</c:if>
											</c:forEach>
											<td>${accountName}</td>
											<td>${o.orderDate}</td>
											<td><select name="orderStatus"
												id="orderStatus_${o.order_id}">
													<c:forEach var="st" items="${orderStatusList}">
														<option value="${st.status_id}"
															<c:if test="${st.status_id == o.status_id}">selected="selected"</c:if>>
															${st.statusName}
															<%--${st.status_id}--%>
														</option>
													</c:forEach>
											</select></td>
											<td><select name="paymentStatus"
												id="paymentStatus_${o.order_id}">
													<option value="paid"
														<c:if test="${o.paymentTransactionStatus == 'paid'}">selected="selected"</c:if>>Đã
														thanh toán</option>
													<option value="unpaid"
														<c:if test="${o.paymentTransactionStatus == 'unpaid'}">selected="selected"</c:if>>Chưa
														thanh toán</option>
											</select></td>

											<%-- <c:forEach var="st" items="${listOrderStatus}">
												<c:if test="${st.status_id == o.status_id }">
													<c:set var="status" value="${st.statusName}" />
												</c:if>
											</c:forEach>
											<td>${status}</td> 
											<td>${o.paymentTransactionStatus }</td> --%>
											<td>${o.totalAmount}đ</td>
											<td>${o.updateAt }</td>
											<td><a href="admin-deleteOrder?orderId=${o.order_id}">XÓA</a>
												||
												<button  class="btn-update custom-btn-update" data-orderid="${o.order_id}">CẬP NHẬT</button> 
												|| <a href="admin-showOrderDetail?orderId=${o.order_id}">XEM</a></td>
										</tr>

									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</main>

<script src="https://cdnjs.cloudflare.com/ajax/libs/sweetalert/2.1.2/sweetalert.min.js"></script>

<!-- Bao gồm phiên bản jQuery -->
<!-- <script src="path/to/jquery.min.js"></script> -->
	<script type="text/javascript">
		$(document).ready(function() {
			// Lắng nghe sự kiện click của nút "Cập nhật"
			$('table').on('click', '.btn-update', function() {
				// Lấy ID đơn hàng từ thuộc tính data-orderid
				var orderId = $(this).data('orderid');

				// Lấy giá trị trạng thái và thanh toán từ các phần tử select
				var orderStatus = $('#orderStatus_' + orderId).val();
				var paymentStatus = $('#paymentStatus_' + orderId).val();

				console.log('orderId:', orderId);
				console.log('orderStatus:', orderStatus);
				console.log('paymentStatus:', paymentStatus);
				// Gửi dữ liệu đến máy chủ để xử lý
				$.ajax({
					url : 'admin-editOrder', // Đường dẫn xử lý cập nhật đơn hàng trên máy chủ
					method : 'POST',
					data : {
						orderId : orderId,
						orderStatus : orderStatus,
						paymentStatus : paymentStatus
					},
					success : function(response) {
						// Xử lý phản hồi từ máy chủ sau khi cập nhật thành công (nếu cần)
						console.log('Đã cập nhật đơn hàng thành công');
						 swal("Thành công", "Cập nhật đơn hàng thành công", "success");
					},
					error : function(error) {
						// Xử lý lỗi khi gửi yêu cầu cập nhật đơn hàng (nếu cần)
						console.log('Lỗi khi cập nhật đơn hàng: ' + error);
						 swal("Lỗi", "Cập nhật đơn hàng không thành công", "error");
					}
				});
			});
		});
	</script>
</body>
</html>