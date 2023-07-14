package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IOrderDAO;
import com.clothingstore.model.Account;
import com.clothingstore.model.Cart;
import com.clothingstore.model.Order;
import com.clothingstore.service.IOrderService;

public class OrderService implements IOrderService {

	@Inject
	private IOrderDAO orderDAO;
	@Override
	public List<Order> getAllOrder() {
		return orderDAO.getAllOrder();
	}

	@Override
	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	@Override
	public void createOrder(Order order) {
		
	}

	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public void deleteOrder(int orderId) {
		orderDAO.deleteOrder(orderId);
		
	}

	@Override
	public void addOrder(Account account, Cart cart, Order order) {
		orderDAO.addOrder(account, cart, order);
		
	}

	@Override
	public List<Order> getAllOrderByAccountId(int accountId) {
		// TODO Auto-generated method stub
		return orderDAO.getAllOrderByAccountId(accountId);
	}

}
