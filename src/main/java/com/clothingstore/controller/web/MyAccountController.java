package com.clothingstore.controller.web;

import java.io.IOException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothingstore.dao.IAccountDAO;
import com.clothingstore.model.Account;
import com.clothingstore.model.Category;
import com.clothingstore.service.IAccountService;
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/my-account")
public class MyAccountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
    public MyAccountController() {
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
		
		HttpSession session = request.getSession();
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		Account account = accountService.getAccountById(accountId);
		session.setAttribute("name", account.getName());
		session.setAttribute("email", account.getEmail());
		session.setAttribute("gender", account.getGender());	
		session.setAttribute("address", account.getAddress());
		session.setAttribute("phone", account.getPhone());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String dateOfBirthString = sdf.format(account.getDateOfBirth()); // dateOfBirth là kiểu java.sql.Date
		session.setAttribute("dateOfBirth", dateOfBirthString);
//		session.setAttribute("dateOfBirth", account.getDateOfBirth());
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/myAccount.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String name = request.getParameter("fullName");
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String sqlDate = request.getParameter("dob");
		java.util.Date utilDate = new java.util.Date();
		try {
			utilDate = new SimpleDateFormat("yyyy-mm-dd").parse(sqlDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		java.sql.Date dateOfBirth = new java.sql.Date(utilDate.getTime());
		
//		Date dateOfBirth = (Date) request.getAttribute("dob");
		int accountId = Integer.parseInt(request.getParameter("accountId"));
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("currentAccount");
		account.setName(name);
		account.setEmail(email); 
		account.setAddress(address);
		account.setPhone(phone); 
		account.setGender(gender);
		account.setDateOfBirth(dateOfBirth); 
		accountService.updateAccount(account);
		
		// Kiểm tra
//		Account checked = accountService.getAccountById(accountId);
//		if(checked != null && !checked.equals(account)) {
//			//cập nhật thành công
//			request.setAttribute("message", "Cập nhật thông tin thành công");
//		}else {
//			//không thành công
//			request.setAttribute("message", "Cập nhật thông tin không thành công");
//		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
		rd.forward(request, response);
		response.sendRedirect("web-home");
		
	}

}
