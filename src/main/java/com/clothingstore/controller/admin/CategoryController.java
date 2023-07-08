package com.clothingstore.controller.admin;

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
import com.clothingstore.service.ICategoryService;

@WebServlet(urlPatterns = "/admin-category")
public class CategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ICategoryService categoryService;
	
    public CategoryController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryService.getAllCategory();
		request.setAttribute("categories", categories);
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
