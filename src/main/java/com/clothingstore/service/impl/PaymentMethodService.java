package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IPaymentMethodDAO;
import com.clothingstore.model.PaymentMethod;
import com.clothingstore.service.IPaymentMethodService;

public class PaymentMethodService implements IPaymentMethodService{

	@Inject
	private IPaymentMethodDAO paymentMethodDAO;
	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		return paymentMethodDAO.getAllPaymentMethod();
	}

	@Override
	public PaymentMethod getOnePaymentMethodById(int paymentId) {
		return paymentMethodDAO.getOnePaymentMethodById(paymentId);
	}

	@Override
	public void createPaymentMethod(PaymentMethod paymentMethod) {
		paymentMethodDAO.createPaymentMethod(paymentMethod);
	}

	@Override
	public void updatePaymentMethod(PaymentMethod paymentMethod) {
		paymentMethodDAO.updatePaymentMethod(paymentMethod);
	}

	@Override
	public void deletePaymentMethod(int paymentId) {
		paymentMethodDAO.deletePaymentMethod(paymentId);
	}

}
