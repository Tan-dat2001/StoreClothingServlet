package com.clothingstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.service.IAccountService;

@WebServlet(urlPatterns = "/admin-deleteAccount")
public class DeleteAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteAccountController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Inject
    private IAccountService accountService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		accountService.deleteAccount(accountId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/customer.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-customer");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


	}

}
