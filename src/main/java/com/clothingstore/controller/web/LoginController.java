package com.clothingstore.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothingstore.dao.impl.AccountDAO;
import com.clothingstore.model.Account;
import com.clothingstore.service.impl.AccountService;

/**
 * Servlet implementation class LoginController
 */
//url="/dang-nhap"
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private AccountService accountService;
	
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/login/login.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		AccountDAO accountDAO = new AccountDAO();
		HttpSession session = request.getSession();
		String email = request.getParameter("txtemail");
		System.out.println("xuat email" + email);
		String password = request.getParameter("txtpassword");
		System.out.println("xuat password" + password);
		boolean isValid = accountService.checkLogin(email, password);
		System.out.println("xuat isValid" + isValid);
		if(isValid) {
			
			Account account = accountService.getAccountByEmail(email);
			session.setAttribute("email", email);
			session.setAttribute("name", account.getName());
			session.setAttribute("accountId", account.getAccount_id());
			RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
			rd.forward(request, response);
			response.sendRedirect("web-home");
		}else {
			session.setAttribute("errorMessage", "Đăng nhập thất bại! Vui lòng kiểm tra lại email và mật khẩu.");
			RequestDispatcher rq = request.getRequestDispatcher("views/login/login.jsp");
			rq.forward(request, response);
		}
	}

}
