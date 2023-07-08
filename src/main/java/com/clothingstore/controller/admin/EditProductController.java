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

import com.clothingstore.model.Category;
import com.clothingstore.model.Discount;
import com.clothingstore.model.Product;
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IDiscountService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/admin-editProduct")
public class EditProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
   
	@Inject
	private IDiscountService discountService;
	
    public EditProductController() {
        super();
    }


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> categories = categoryService.getAllCategory();
		request.setAttribute("categories", categories);
		List<Discount> discounts = discountService.getAllDiscount();
		request.setAttribute("discounts", discounts);	
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		Product product = productService.getProductById(productId);
		request.setAttribute("product", product);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/editProductForm.jsp");
		rd.forward(request, response);
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		int productId = Integer.parseInt(request.getParameter("productId"));
		String productName = request.getParameter("productName");
		String productImage = request.getParameter("image");
		int productCategoryId = Integer.parseInt(request.getParameter("category"));
		int quantity = Integer.parseInt(request.getParameter("quantity")) ;
		float productPrice = Float.parseFloat(request.getParameter("price"));
		int discount = Integer.parseInt(request.getParameter("discount"));
		String productDesc = request.getParameter("description");
		String status = request.getParameter("status");
		Product product= new Product(productId, productCategoryId, discount, productName, productDesc, productPrice, productImage, 0, quantity, status);
		productService.updateProduct(product);
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/home.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-home");
	}

}
