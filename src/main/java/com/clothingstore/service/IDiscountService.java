package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.Discount;

public interface IDiscountService {
	List<Discount> getAllDiscount();

	Discount getOneCategoryById(int discountId);

	void createCategory(Discount discount);

	void updateCategory(Discount discount);

	void deleteCategory(int discountId);
}
