package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.OrderStatus;

public interface IOrderStatusDAO {
	
	List<OrderStatus> getAllOrderStatus();

	OrderStatus getOneOrderStatusById(int statusId);

	void createOrderStatus(OrderStatus orderStatus);

	void updatePaymentMethod(OrderStatus orderStatus);

	void deleteOrderStatus(int statusId);
}
