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

import com.clothingstore.dao.impl.ProductDAO;
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
