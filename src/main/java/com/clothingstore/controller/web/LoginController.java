package com.clothingstore.controller.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
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
@WebServlet(urlPatterns = "/log-in")
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
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		String email = request.getParameter("txtemail");
		System.out.println("xuat email" + email);
		String password = request.getParameter("txtpassword");
		System.out.println("xuat password" + password);
		boolean isValid = accountService.checkLogin(email, password);
		System.out.println("xuat isValid" + isValid);
		if(isValid) {
					
			Account account = accountService.getAccountByEmail(email);
			session.setAttribute("currentAccount", account);
			session.setAttribute("email", email);
			session.setAttribute("name", account.getName());
			session.setAttribute("accountId", account.getAccount_id());
			System.out.println(account.getAccount_id());
			if(account.getRole().equalsIgnoreCase("user") && account.getStatus().equalsIgnoreCase("enabled")) {
				RequestDispatcher rd = request.getRequestDispatcher("views/web/home.jsp");
				rd.forward(request, response);
				response.sendRedirect("web-home");				
			}else if(account.getRole().equalsIgnoreCase("admin") && account.getStatus().equalsIgnoreCase("enabled")) {
//				RequestDispatcher rd = request.getRequestDispatcher("views/web/adminHome.jsp");
//				rd.forward(request, response);
				
				response.sendRedirect(request.getContextPath() + "/admin-home");		
			}else {
				RequestDispatcher rq = request.getRequestDispatcher("views/login/login.jsp");
				rq.forward(request, response);
			}
		}else {
			
			session.setAttribute("errorMessage"," Đăng nhập thất bại! Vui lòng kiểm tra lại email và mật khẩu.");			 		
			RequestDispatcher rq = request.getRequestDispatcher("views/login/login.jsp");
			rq.forward(request, response);
		}
	}

}
