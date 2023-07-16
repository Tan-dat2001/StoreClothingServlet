package com.clothingstore.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.dao.impl.InfoDAO;
import com.clothingstore.model.InfoDelivery;
import com.clothingstore.model.Order;
import com.clothingstore.model.OrderDetail;
import com.clothingstore.model.Product;
import com.clothingstore.service.IOrderDetailService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/admin-showOrderDetail")
public class ShowOrderDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ShowOrderDetailController() {
		super();

	}

	@Inject
	private IProductService productService;
	@Inject
	private IOrderDetailService orderDetailService;
	@Inject
	private IOrderService orderService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		// lấy thông tin vận chuyển ở page checkout
		InfoDAO infoDAO = new InfoDAO();
		InfoDelivery infoDelivery = new InfoDelivery();
		infoDelivery = infoDAO.getInfoDeliveryByOrderId(orderId);
		request.setAttribute("infoDelivery", infoDelivery);
		//Lấy thông tin đơn hàng bởi id đơn hàng.
		Order orderInfo = orderService.getOrderById(orderId);
		request.setAttribute("orderInfo", orderInfo);
		//Lấy danh sách orderDetails, cụ thể là các sản phẩm trong một đơn hàng 
		List<OrderDetail> orderDetails = orderDetailService.getAllOrderDetailByOrderId(orderId);
		request.setAttribute("orderDetails",orderDetails);
		List<Product> products = new ArrayList<>();
		for(OrderDetail orderDetail:orderDetails) {
				Product product = productService.getProductById(orderDetail.getProduct_id());
				products.add(product);
				request.setAttribute("products", products);
		}
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/orderDetail.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)	throws ServletException, IOException {
	}

}
