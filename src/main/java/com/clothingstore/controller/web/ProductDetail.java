package com.clothingstore.controller.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.model.Category;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = "/product-detail")
public class ProductDetail extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ProductDetail() {
        super();
    }
    
    @Inject
    private IProductService productService;
	@Inject
	private CategoryService categoryService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		int productID = Integer.parseInt(request.getParameter("productId"));
		
		Product product = productService.getProductById(productID);
//		System.out.println(product.getProductName());
		request.setAttribute("productDetail", product);	
		
		List<Product> listProducts = productService.searchProduct(product.getProductName());
		request.setAttribute("listProducts", listProducts); // dùng để hiển thị các sản phẩm liên quan
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/productDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
