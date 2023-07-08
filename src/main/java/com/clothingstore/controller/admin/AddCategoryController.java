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

import com.clothingstore.dao.IDiscountDAO;
import com.clothingstore.model.Category;
import com.clothingstore.model.Discount;
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IDiscountService;

@WebServlet(urlPatterns = "/admin-addCategory")
public class AddCategoryController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private ICategoryService categoryService;   
    
	@Inject
	private IDiscountService discountService;
    public AddCategoryController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryService.getAllCategory();
		request.setAttribute("categories", categories);
		List<Discount> discounts = discountService.getAllDiscount();
		request.setAttribute("discounts", discounts);		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//EditCategory
		request.setCharacterEncoding("UTF-8");
		int categoryId = Integer.parseInt(request.getParameter("categoryId"));
		String categoryName = request.getParameter("categoryName");
		Category category = new Category(categoryId, categoryName);
		categoryService.createCategory(category);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/category.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-addCategory");
				
	}

}
