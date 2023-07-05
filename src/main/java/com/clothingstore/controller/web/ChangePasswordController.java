package com.clothingstore.controller.web;

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
import com.clothingstore.model.Category;
import com.clothingstore.service.IAccountService;
import com.clothingstore.service.ICategoryService;

@WebServlet(urlPatterns = "/change-password")
public class ChangePasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ChangePasswordController() {
        super();
    }
    
    @Inject
    private ICategoryService categoryService;
    
    @Inject
    private IAccountService accountService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/changePassword.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("currentAccount");
		System.out.println(account.getName());
		String currentPassword = account.getPassword();
		System.out.println("hiển thị mật khẩu của account: " + currentPassword);
		
		
		String currentPasswordInput = request.getParameter("currentPass");
		System.out.println("hiển thị mật khẩu nhập hiện tại: " + currentPasswordInput);
		String newPassword = request.getParameter("newPass");
		System.out.println("hiển thị mật khẩu mới nhập : " + newPassword);

		if(currentPassword.equals(currentPasswordInput)) {
			account.setPassword(newPassword);
			accountService.updateAccount(account);
			System.out.println("mật khẩu đã update:" + account.getPassword());
//			RequestDispatcher rd = request.getRequestDispatcher("/views/web/myAccount.jsp");
//			rd.forward(request, response);
			response.sendRedirect("web-home");
		}else {
			session.setAttribute("currentPasswordInput", "Mật khẩu hiện tại không trùng khớp!");
			response.sendRedirect("change-password");
		}
		
		
	}

}
