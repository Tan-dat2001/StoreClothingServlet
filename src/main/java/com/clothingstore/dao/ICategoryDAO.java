package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.Category;

public interface ICategoryDAO {
	List<Category> getAllCategory();
	
	Category getOneCategoryById(int categoryId);
	
	void createCategory(Category category);
	
	void updateCategory(Category category);
	
	void deleteCategory(int categoryId);
	
	List<Category> getCategoriesByWord(String keyword);
}
