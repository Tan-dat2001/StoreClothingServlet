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

import com.clothingstore.dao.impl.ProductDAO;
import com.clothingstore.model.Category;
import com.clothingstore.model.Product;
import com.clothingstore.service.impl.CategoryService;
import com.clothingstore.service.impl.ProductService;

@WebServlet(urlPatterns = "/web-home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private CategoryService categoryService;

	@Inject
	private ProductService productService;

	public HomeController() {
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws SecurityException, IOException, ServletException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		//Phân trang
		//lấy giá trị index của trang
		String indexPage = request.getParameter("index");
		if(indexPage == null ) {
			indexPage = "1";
		}
		int index = Integer.parseInt(indexPage);
		
		ProductDAO productDAO = new ProductDAO();
		int count = productDAO.getTotalProduct();
		int endPage = count/20;
		if(count % 20 != 0) {
			endPage++;
		}
		request.setAttribute("endPage", endPage);
		request.setAttribute("index", index);
		List<Product> listProducts = productService.pagingProduct(index);
		request.setAttribute("listProducts", listProducts);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
