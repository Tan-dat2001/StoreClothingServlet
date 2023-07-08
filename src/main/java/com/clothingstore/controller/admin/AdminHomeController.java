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
import javax.servlet.http.HttpSession;

import com.clothingstore.model.Account;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;


@WebServlet(urlPatterns = "/admin-home")
public class AdminHomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@Inject
	private IProductService productService;
    public AdminHomeController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("currentAccount");
		session.setAttribute("name", account.getName());
		
		List<Product> listProducts = productService.getAllProduct();
		request.setAttribute("listProducts", listProducts);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
