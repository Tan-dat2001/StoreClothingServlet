package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IDiscountDAO;
import com.clothingstore.model.Discount;
import com.clothingstore.service.IDiscountService;

public class DiscountService implements IDiscountService{
	@Inject
	private IDiscountDAO discountDAO;
	
	@Override
	public List<Discount> getAllDiscount() {
		return discountDAO.getAllDiscount();
	}

	@Override
	public Discount getOneCategoryById(int discountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCategory(Discount discount) {
		discountDAO.createCategory(discount);
	}

	@Override
	public void updateCategory(Discount discount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int discountId) {
		// TODO Auto-generated method stub
		
	}

}
