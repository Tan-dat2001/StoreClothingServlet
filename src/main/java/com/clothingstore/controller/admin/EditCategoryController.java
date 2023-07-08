package com.clothingstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.model.Category;
import com.clothingstore.service.ICategoryService;

@WebServlet(urlPatterns = "/admin-editCategory")
public class EditCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Inject
    private ICategoryService categoryService;
    public EditCategoryController() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		
		Category category = categoryService.getOneCategoryById(categoryId);
		category.setCategoryName(categoryName);
		categoryService.updateCategory(category);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-category");
	}

}
