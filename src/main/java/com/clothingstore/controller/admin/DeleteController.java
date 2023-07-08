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
import com.clothingstore.service.IProductService;
//Delete Product
@WebServlet(urlPatterns = "/admin-delete")
public class DeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
    public DeleteController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int productId = Integer.parseInt(request.getParameter("productId"));
		productService.deleteProduct(productId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-home");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
