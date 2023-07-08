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

import com.clothingstore.model.Account;
import com.clothingstore.service.IAccountService;

@WebServlet(urlPatterns = "/admin-customer")
public class CustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IAccountService accountService;
    public CustomerController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Account> accounts = accountService.getAllAccount();
		request.setAttribute("accounts", accounts);
		for(Account account:accounts) {
			System.out.println(account.getAccount_id());
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/customer.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
