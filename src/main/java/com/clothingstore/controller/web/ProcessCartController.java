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

import com.clothingstore.model.Cart;
import com.clothingstore.model.Category;
import com.clothingstore.model.Item;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = {"/process", "/processNum"})
public class ProcessCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private CategoryService categoryService;   
	@Inject
	private IProductService productService;
    public ProcessCartController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		HttpSession session = request.getSession(true	);
		Cart cart = null;
		Object o = session.getAttribute("cart");
		//co roi
		if(o != null) {
			cart = (Cart) o;
		}else {
			cart = new Cart();
		}
		String requestURI = request.getRequestURI();
		String processString = requestURI.substring(requestURI.lastIndexOf('/')+1);
		//Lấy id sản phẩm cần xóa khỏi giỏ hàng
		int productId = Integer.parseInt(request.getParameter("productId"));
		
		if(processString.equals("process")) {
			cart.removeItem(productId);			
		}else if(processString.equals("processNum")) {
			int num = Integer.parseInt(request.getParameter("num").trim());
			//thêm và giảm số lượng sản phẩm
			try {
				if(num == -1 & cart.getQuantityById(productId)<=1) {
					cart.removeItem(productId);
				}else {
					Product product = productService.getProductById(productId);
					float price = product.getProductPrice();
					Item item = new Item(product, num, price);
					cart.addItem(item);
				}
			} catch (NumberFormatException e) {
				System.out.println(e);
			}			
		}
		
		// Lấy lại danh sách items trong giỏ hàng
		List<Item> list = cart.getItems();
		session.setAttribute("listItem", list);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size()); // .size để lấy số lượng có trong cart
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
