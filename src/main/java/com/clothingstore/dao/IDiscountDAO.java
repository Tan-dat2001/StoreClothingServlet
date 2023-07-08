package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.Discount;

public interface IDiscountDAO {
	List<Discount> getAllDiscount();

	Discount getOneCategoryById(int discountId);

	void createCategory(Discount discount);

	void updateCategory(Discount discount);

	void deleteCategory(int discountId);
}
