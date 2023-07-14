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
import com.clothingstore.model.DeliveryMethod;
import com.clothingstore.model.Item;
import com.clothingstore.model.PaymentMethod;
import com.clothingstore.service.IDeliveryMethodService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.IPaymentMethodService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = "/check-out")
public class CheckoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject 
    private IPaymentMethodService paymentMethodService;
    @Inject
    private IDeliveryMethodService deliveryMethodService;
    @Inject
	private CategoryService categoryService;
    public CheckoutController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		List<PaymentMethod> paymentMethods = paymentMethodService.getAllPaymentMethod();
		request.setAttribute("paymentMethods", paymentMethods);
		List<DeliveryMethod> deliveryMethods = deliveryMethodService.getAllDeliveryMethod();
		request.setAttribute("deliveryMethods", deliveryMethods);
	
		HttpSession session = request.getSession();
		Cart cart = null;
		Object o = session.getAttribute("cart");
		//co roi
		if(o != null) {
			cart = (Cart) o;
		}else {
			cart = new Cart();
		}
		List<Item> list = cart.getItems();
		session.setAttribute("listItem", list);
		session.setAttribute("cart", cart);
		session.setAttribute("size", list.size()); // .size để lấy số lượng có trong cart
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/checkout.jsp");
		rd.forward(request, response);
	}

}
