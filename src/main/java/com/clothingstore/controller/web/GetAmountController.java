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

import com.clothingstore.model.Category;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = "/get-amount")
public class GetAmountController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	@Inject
	private CategoryService categoryService;

    public GetAmountController() {
        super();
    }
//    protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws SecurityException, IOException, ServletException {
//		request.setCharacterEncoding("UTF-8");
//		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
//		request.setAttribute("listCategoriesAo", listCategoriesAo);
//
//		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
//		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
//
//		RequestDispatcher rd = request.getRequestDispatcher("/views/web/shopDetail.jsp");
//		rd.forward(request, response);
//	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		//////////////////////////////////////////////////////////////
			String amount =  request.getParameter("amount");
			System.out.println(amount);
			// Loại bỏ ký tự "d" và khoảng trắng trong chuỗi
			String cleanedAmount = amount.replace("d","").replace(" ", "");
			// Tách chuỗi thành 2 phần dựa trên dấu "-"
			String[] values = cleanedAmount.split("-");
			// Lấy giá trị min và max
			String minString = values[0]; // "0"
			String maxString = values[1]; // "700,000"
			// Chuyển đổi chuỗi thành số
			int min = Integer.parseInt(minString.replaceAll(",", "")); // 0
			int max = Integer.parseInt(maxString.replaceAll(",", "")); // 700000
			//Giả định biến listProductByCategoryId = listProducts để hiển thị tại trang shopdetail.jsp
			List<Product> listProductByCategoryId = productService.getProductByPriceRange(min, max);
			request.setAttribute("listProductByCategoryId", listProductByCategoryId);
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/shopDetail.jsp");
			rd.forward(request, response);
			
//			Lấy tất cả sản phẩm theo giá, chưa lấy được sản phẩm vừa theo giá vừa theo category			
	}

}
