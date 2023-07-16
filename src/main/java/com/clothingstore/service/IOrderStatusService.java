package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.OrderStatus;

public interface IOrderStatusService {

	List<OrderStatus> getAllOrderStatus();

	OrderStatus getOneOrderStatusById(int statusId);

	void createOrderStatus(OrderStatus orderStatus);

	void updatePaymentMethod(OrderStatus orderStatus);

	void deleteOrderStatus(int statusId);
}
