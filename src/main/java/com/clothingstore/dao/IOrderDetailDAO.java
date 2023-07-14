package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.OrderDetail;

public interface IOrderDetailDAO {
	List<OrderDetail> getAllOrderDetail();
	
	List<OrderDetail> getAllOrderDetailByOrderId(int orderId);
	
	OrderDetail getOrderDetailById(int orderDetailId);
	
	void createOrderDetail(OrderDetail orderDetail );
	
	void updateOrderDetail(OrderDetail orderDetail);
	
	void deleteOrderDetail(int orderId);
}
