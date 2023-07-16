package com.clothingstore.controller.admin;

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

import com.clothingstore.model.Account;
import com.clothingstore.model.Order;
import com.clothingstore.model.OrderDetail;
import com.clothingstore.model.OrderStatus;
import com.clothingstore.model.Product;
import com.clothingstore.service.IAccountService;
import com.clothingstore.service.IOrderDetailService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.IOrderStatusService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/admin-order")
public class OrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public OrderController() {
        super();
    }
    @Inject
    private IOrderService orderService;
    @Inject
    private IAccountService accountService;
    @Inject
    private IOrderStatusService orderStatusService;
    @Inject
    private IOrderDetailService orderDetailService;
    @Inject
    private IProductService productService;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Order> listOrders = orderService.getAllOrder();
		request.setAttribute("listOrders", listOrders);
		List<Account> listAccounts = new ArrayList<>();
		//
		List<OrderStatus> orderStatusList = orderStatusService.getAllOrderStatus();
		request.setAttribute("orderStatusList", orderStatusList);
		//
		List<OrderStatus> listOrderStatus = new ArrayList<>();
		List<Product> listProducts = new ArrayList<>(); 
		for(Order order:listOrders) {
			Account account = accountService.getAccountById(order.getAccount_id());
			listAccounts.add(account);
			request.setAttribute("listAccounts", listAccounts);
			//Lấy danh sách sản phẩm trong đơn hàng ->orderDetail
			List<OrderDetail> listOrderDetails = orderDetailService.getAllOrderDetailByOrderId(order.getOrder_id());
			request.setAttribute("listOrderDetails", listOrderDetails);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
