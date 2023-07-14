package com.clothingstore.controller.web;

import java.io.IOException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.clothingstore.dao.impl.InfoDAO;
import com.clothingstore.model.Account;
import com.clothingstore.model.Cart;
import com.clothingstore.model.Category;
import com.clothingstore.model.InfoDelivery;
import com.clothingstore.model.Item;
import com.clothingstore.model.Order;
import com.clothingstore.service.IDeliveryMethodService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.impl.CategoryService;

@WebServlet(urlPatterns = "/make-payment")
public class MakePaymentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    @Inject
    private IOrderService orderService;
    @Inject
	private CategoryService categoryService;
    public MakePaymentController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		HttpSession session = request.getSession();
		LocalDateTime currentTime = java.time.LocalDateTime.now();
		
		
		int paymentId = Integer.parseInt(request.getParameter("paymentMethod"));
		int deliveryId = Integer.parseInt(request.getParameter("delivery"));
//		String paymentId = request.getParameter("paymentMethod");
//		String deliveryId = request.getParameter("delivery");
		Account account = (Account)session.getAttribute("currentAccount");
		String note = request.getParameter("note");
		
		Cart cart = null;
		Object o = session.getAttribute("cart");
		if(o != null) {
			cart = (Cart) o;
		}else {
			cart = new Cart();
		}
		List<Item> list = cart.getItems();
		float total=0;
		for(Item item:list) {
			total += item.getProduct().getProductPrice() * item.getQuantity();
		}
		Order order = new Order();
		order.setAccount_id(account.getAccount_id());
		order.setPayment_id(paymentId);
		order.setDelivery_id(deliveryId);
		order.setOrderDate(currentTime);
		order.setPaymentTransactionStatus("unpaid");
		order.setOrderNote(note);
		order.setTotalAmount(total);
		
		
		orderService.addOrder(account, cart, order);
		//sau khi đặt hàng thành công->  lấy thông tin vận chuyển để lưu vào bảng Info từ đó hiển thị ở orderPage hoặc orderDetail
		int account_id = account.getAccount_id();
		String name = request.getParameter("fullName");
		String phone = request.getParameter("phone");
		String address = request.getParameter("address");
		
		InfoDelivery infoDelivery = new InfoDelivery(order.getOrder_id(), name, phone, address, note, account_id);
		InfoDAO infoDAO = new InfoDAO();
		infoDAO.createInfoDelivery(infoDelivery);
		session.removeAttribute("cart");
		session.setAttribute("size", 0);
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/orderSuccess.jsp");
		rd.forward(request, response);
	}

}
