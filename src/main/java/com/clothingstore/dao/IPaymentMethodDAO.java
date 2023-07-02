package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.PaymentMethod;

public interface IPaymentMethodDAO {
	
	List<PaymentMethod> getAllPaymentMethod();
	
	PaymentMethod getOnePaymentMethodById(int paymentId);
	
	void createPaymentMethod(PaymentMethod paymentMethod);
	
	void updatePaymentMethod(PaymentMethod paymentMethod);
	
	void deletePaymentMethod(int paymentId);

}
