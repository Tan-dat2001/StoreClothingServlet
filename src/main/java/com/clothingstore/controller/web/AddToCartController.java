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
import com.clothingstore.model.Cart;
import com.clothingstore.model.Category;
import com.clothingstore.model.Item;
import com.clothingstore.model.Product;
import com.clothingstore.service.IProductService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = "/addtocart")
public class AddToCartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@Inject
	private IProductService productService;
	@Inject
	private CategoryService categoryService;
    public AddToCartController() {
        super();
    }
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		HttpSession session = request.getSession(true);
		Account account = (Account) session.getAttribute("currentAccount");
		if(account != null) {
			Cart cart = null;
			Object o = session.getAttribute("cart"); // object chính là giỏ hàng
			if (o != null) { // object này có rồi
				cart = (Cart) o;
			} else {
				cart = new Cart(); // Nếu ngta mua lần đầu, thì tạo một cái cart
			}
			int quantity = Integer.parseInt(request.getParameter("quantity"));
			int productId = Integer.parseInt(request.getParameter("productId"));
			Product product = productService.getProductById(productId);
//			float price = product.getProductPrice()*1.2; Ở đây *1.2 vì khi bán sẽ tăng lên 20% (Nếu muốn)
			float price = product.getProductPrice();
			Item item = new Item(product, quantity, price);
			cart.addItem(item);
			
			List<Item> list = cart.getItems(); // trả về danh sách các sản phẩm trong cart
			session.setAttribute("listItem", list);
			session.setAttribute("cart", cart);
			session.setAttribute("size", list.size()); // .size để lấy số lượng có trong cart
//			RequestDispatcher rd = request.getRequestDispatcher("/views/web/cart.jsp");
			RequestDispatcher rd = request.getRequestDispatcher("/views/web/home.jsp");
			rd.forward(request, response);
			response.sendRedirect("web-home");
		}else {
			response.sendRedirect("log-in");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
