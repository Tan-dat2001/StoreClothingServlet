package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IOrderStatusDAO;
import com.clothingstore.model.OrderStatus;
import com.clothingstore.service.IOrderStatusService;

public class OrderStatusService implements IOrderStatusService {

	@Inject
	private IOrderStatusDAO orderStatusDAO;
	@Override
	public List<OrderStatus> getAllOrderStatus() {
		return orderStatusDAO.getAllOrderStatus();
	}

	@Override
	public OrderStatus getOneOrderStatusById(int statusId) {
		return orderStatusDAO.getOneOrderStatusById(statusId);
	}

	@Override
	public void createOrderStatus(OrderStatus orderStatus) {
		orderStatusDAO.createOrderStatus(orderStatus);
	}

	@Override
	public void updatePaymentMethod(OrderStatus orderStatus) {
		orderStatusDAO.updatePaymentMethod(orderStatus);
	}

	@Override
	public void deleteOrderStatus(int statusId) {
		orderStatusDAO.deleteOrderStatus(statusId);
	}

}
