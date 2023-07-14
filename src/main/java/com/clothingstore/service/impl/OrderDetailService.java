package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IOrderDetailDAO;
import com.clothingstore.model.OrderDetail;
import com.clothingstore.service.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService{

	@Inject
	private IOrderDetailDAO orderDetailDAO;
	@Override
	public List<OrderDetail> getAllOrderDetail() {
		return orderDetailDAO.getAllOrderDetail();
	}

	@Override
	public OrderDetail getOrderDetailById(int orderDetailId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getOrderDetailById(orderDetailId);
	}

	@Override
	public void createOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrderDetail(int orderId) {
		orderDetailDAO.deleteOrderDetail(orderId);
	}

	@Override
	public List<OrderDetail> getAllOrderDetailByOrderId(int orderId) {
		// TODO Auto-generated method stub
		return orderDetailDAO.getAllOrderDetailByOrderId(orderId);
	}

}
