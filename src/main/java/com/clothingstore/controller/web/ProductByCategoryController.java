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
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IProductService;


@WebServlet(urlPatterns = "/product-category")
public class ProductByCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
	
    public ProductByCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		List<Product> listProductByCategoryId = productService.getProductByCategoryId(categoryId);
		request.setAttribute("listProductByCategoryId", listProductByCategoryId);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/shopDetail.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

}
