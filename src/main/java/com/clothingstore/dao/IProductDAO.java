package com.clothingstore.dao;

import java.util.List;

import com.clothingstore.model.Product;

public interface IProductDAO {
	List<Product> getAllProduct(); //done
	
	Product getProductById(int id); //done
	
	List<Product> getProductByCategoryId(int categoryId); //done
	
	List<Product> getProductByPriceRange(float minPrice, float maxPrice); // done
	
	void createProduct(Product product); //done
	
	void updateProduct(Product product);//done
	
	void deleteProduct(int productId); //done
	
	List<Product> searchProduct(String keyword); //done
}
