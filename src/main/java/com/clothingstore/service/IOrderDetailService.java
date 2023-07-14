package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.OrderDetail;

public interface IOrderDetailService {
	List<OrderDetail> getAllOrderDetail();
	
	List<OrderDetail> getAllOrderDetailByOrderId(int orderId);

	OrderDetail getOrderDetailById(int orderDetailId);

	void createOrderDetail(OrderDetail orderDetail);

	void updateOrderDetail(OrderDetail orderDetail);

	void deleteOrderDetail(int orderId);
}
