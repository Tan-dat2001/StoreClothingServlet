package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IDeliveryMethodDAO;
import com.clothingstore.model.DeliveryMethod;
import com.clothingstore.service.IDeliveryMethodService;

public class DeliveryMethodService implements IDeliveryMethodService{

	@Inject
	private IDeliveryMethodDAO deliveryMethodDAO;
	@Override
	public List<DeliveryMethod> getAllDeliveryMethod() {
		return deliveryMethodDAO.getAllDeliveryMethod();
	}

	@Override
	public DeliveryMethod getOneDeliveryMethodById(int deliveryId) {
		return deliveryMethodDAO.getOneDeliveryMethodById(deliveryId);
	}

	@Override
	public void createDeliveryMethod(DeliveryMethod deliveryMethod) {
		deliveryMethodDAO.createDeliveryMethod(deliveryMethod);
	}

	@Override
	public void updateDeliveryMethod(DeliveryMethod deliveryMethod) {
		deliveryMethodDAO.updateDeliveryMethod(deliveryMethod);
	}

	@Override
	public void deleteDeliveryMethod(int deliveryId) {
		deliveryMethodDAO.deleteDeliveryMethod(deliveryId);
	}

}
