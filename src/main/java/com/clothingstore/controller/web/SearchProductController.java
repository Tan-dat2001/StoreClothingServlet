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
import com.clothingstore.service.impl.CategoryService;
import com.clothingstore.service.impl.ProductService;

@WebServlet(urlPatterns = "/search")
public class SearchProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryService categoryService;

	@Inject
	private ProductService productService;

	public SearchProductController() {

	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		String nameSearch = request.getParameter("name-search");
		List<Product> listProducts = productService.searchProduct(nameSearch);
		request.setAttribute("listProducts", listProducts);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

//	protected void doGet(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//
//		
//
//	}
//
//	protected void doPost(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		
//	}

}
