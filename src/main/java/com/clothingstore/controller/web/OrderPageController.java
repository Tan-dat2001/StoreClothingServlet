package com.clothingstore.controller.web;

import java.io.IOException;
import java.util.ArrayList;
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
import com.clothingstore.model.Category;
import com.clothingstore.model.InfoDelivery;
import com.clothingstore.model.Order;
import com.clothingstore.model.OrderDetail;
import com.clothingstore.model.OrderStatus;
import com.clothingstore.model.PaymentMethod;
import com.clothingstore.model.Product;
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IOrderDetailService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.IOrderStatusService;
import com.clothingstore.service.IPaymentMethodService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/order-page")
public class OrderPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public OrderPageController() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Inject
    private ICategoryService categoryService;
    @Inject 
    private IOrderService orderService;
	@Inject
	private IOrderDetailService orderDetailService;
	@Inject
	private IProductService productService;
	@Inject
	private IOrderStatusService orderStatusService;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("currentAccount");
		List<Order> listOrders = orderService.getAllOrderByAccountId(account.getAccount_id());
		request.setAttribute("listOrders",listOrders);
		List<InfoDelivery> infoDeliveries = new ArrayList<>();
		InfoDelivery infoDelivery = new InfoDelivery();
		InfoDAO infoDAO = new InfoDAO();
		List<OrderStatus> listOrderStatus = new ArrayList<>();
		for(Order order:listOrders) {
			List<OrderDetail> listOrderDetails = orderDetailService.getAllOrderDetailByOrderId(order.getOrder_id());			
			request.setAttribute("listOrderDetails", listOrderDetails);
			//Lấy thông tin vận chuyển
			infoDelivery = infoDAO.getInfoDeliveryByOrderId(order.getOrder_id());
			infoDeliveries.add(infoDelivery);
			request.setAttribute("infoDeliveries", infoDeliveries);
			//Lấy thông tin trạng thái đơn hàng
			OrderStatus orderStatus = orderStatusService.getOneOrderStatusById(order.getStatus_id());
			listOrderStatus.add(orderStatus);
			request.setAttribute("listOrderStatus", listOrderStatus);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/orderPage.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
