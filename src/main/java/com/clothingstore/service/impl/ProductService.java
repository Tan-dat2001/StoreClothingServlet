package com.clothingstore.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.clothingstore.dao.IProductDAO;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;

public class ProductService implements IProductService {
	//Muốn sử dụng method findAllProduct() ở ProductDAO
	//Case1: thông thường
//	private IProductDAO productDAO;
//	public ProductService() {
//		productDAO = new ProductDAO();
//	}
	//Case2: sử dụng dependency injection ->lib: java servlet weld.
	@Inject
	private IProductDAO productDAO;
	
	@Override
	public List<Product> getAllProduct() {
		return productDAO.getAllProduct();
	}

	@Override
	public Product getProductById(int id) {
		return productDAO.getProductById(id);
	}

	@Override
	public List<Product> getProductByCategoryId(int categoryId) {
		return productDAO.getProductByCategoryId(categoryId);
	}

	@Override
	public List<Product> getProductByPriceRange(float minPrice, float maxPrice) {
		return productDAO.getProductByPriceRange(minPrice, maxPrice);
	}

	@Override
	public void createProduct(Product product) {
//		product.setCreateAt(new Local);
		productDAO.createProduct(product);
	}

	@Override
	public void updateProduct(Product product) {
		productDAO.updateProduct(product);
	}

	@Override
	public void deleteProduct(int productId) {
		productDAO.deleteProduct(productId);
	}

	@Override
	public List<Product> searchProduct(String keyword) {
		return productDAO.searchProduct(keyword);
	}

}
