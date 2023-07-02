package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.Order;

public interface IOrderDAO {

	List<Order> getAllOrder();
	
	Order getOrderById(int orderId);
	
	void createOrder(Order order);
	
	void updateOrder(Order order);
	
	void deleteOrder(int orderId);
	//Note: if u want to delete an order, u have to delete all order detail before.
}
