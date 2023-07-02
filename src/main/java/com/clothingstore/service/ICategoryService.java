package com.clothingstore.service;

import java.util.List;

import com.clothingstore.model.Category;

public interface ICategoryService {
	List<Category> getAllCategory();

	Category getOneCategoryById(int categoryId);

	void createCategory(Category category);

	void updateCategory(Category category);

	void deleteCategory(int categoryId);

	List<Category> getCategoriesByWord(String keyword);
}
