package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.DeliveryMethod;

public interface IDeliveryMethodDAO {
	
	List<DeliveryMethod> getAllDeliveryMethod();
	
	DeliveryMethod getOneDeliveryMethodById(int deliveryId);
	
	void createDeliveryMethod(DeliveryMethod deliveryMethod);
	
	void updateDeliveryMethod(DeliveryMethod deliveryMethod);
	
	void deleteDeliveryMethod(int deliveryId);

}
