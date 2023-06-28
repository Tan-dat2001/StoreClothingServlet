package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.ICategoryDAO;
import com.clothingstore.dao.impl.CategoryDAO;
import com.clothingstore.model.Category;
import com.clothingstore.service.ICategoryService;

public class CategoryService implements ICategoryService {
	//Muốn sử dụng method findAllCategory() ở CategoryDAO
	//Case1: thông thường
//	private ICategoryDAO categoryDAO;
//	public CategoryService() {
//		categoryDAO = new CategoryDAO();
//	}
	//Case2: sử dụng dependency injection ->lib: java servlet weld.
	@Inject
	private ICategoryDAO categoryDAO;
	
	@Override
	public List<Category> getAllCategory() {
		return categoryDAO.getAllCategory();
	}

}
