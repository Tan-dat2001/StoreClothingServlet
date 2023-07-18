package com.clothingstore.controller.web;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.dao.impl.AccountDAO;
import com.clothingstore.model.Account;
import com.clothingstore.service.impl.AccountService;


@WebServlet(urlPatterns = "/sign-up")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
    private AccountService accountService;
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd = request.getRequestDispatcher("views/login/register.jsp");
		rd.forward(request, response);
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		String fullName = request.getParameter("fullName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String gender = request.getParameter("gender");
		
		
		request.setAttribute("fullName", fullName);
		request.setAttribute("email", email);
		request.setAttribute("gender", gender);
		String error="";
		String url = "";
//		AccountDAO accountDAO = new AccountDAO();
		if(accountService.getAccountByEmail(email) != null) {
			error += "Email đã tồn tại, vui lòng nhập email khác. <br/>";
		}
		if(!password.equals(repeatPassword)) {
			error += "Mật khẩu không khớp, vui lòng nhập lại. <br/>";
		}
		if(error.length()>0) {
			url = "/views/login/register.jsp";
		}else {
			Account account = new Account(0, email, password, fullName, null, null, gender, null, null, null);
			accountService.createAccount(account);
			url = "dang-nhap";
			//sau khi đăng ký chuyển về trang home nhưng url vẫn là sign-up, sai UI.
		}
//		RequestDispatcher rd = request.getRequestDispatcher(url);
//		rd.forward(request, response);
		response.sendRedirect(url);
	}

}
