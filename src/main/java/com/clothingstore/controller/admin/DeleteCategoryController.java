package com.clothingstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.service.ICategoryService;

@WebServlet(urlPatterns = "/admin-deleteCategory")
public class DeleteCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private ICategoryService categoryService;
    public DeleteCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		categoryService.deleteCategory(categoryId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-category");
				
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
