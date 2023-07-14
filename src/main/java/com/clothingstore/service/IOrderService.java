package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.Account;
import com.clothingstore.model.Cart;
import com.clothingstore.model.Order;

public interface IOrderService {
	List<Order> getAllOrder();
	
	//show in user
	List<Order> getAllOrderByAccountId(int accountId);
	
	Order getOrderById(int orderId);

	void createOrder(Order order);

	void updateOrder(Order order);

	void deleteOrder(int orderId);
	// Note: if u want to delete an order, u have to delete all order detail before.

	void addOrder(Account account, Cart cart, Order order);
}
