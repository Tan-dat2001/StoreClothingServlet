package com.clothingstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.model.Order;
import com.clothingstore.service.IOrderService;

@WebServlet(urlPatterns = "/admin-editOrder")
public class EditOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderService orderService;
    
    public EditOrderController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		int orderStatus = Integer.parseInt(request.getParameter("orderStatus"));
        String paymentStatus = request.getParameter("paymentStatus");
        Order order = orderService.getOrderById(orderId);
        order.setStatus_id(orderStatus);
        order.setPaymentTransactionStatus(paymentStatus);
        try {
        	// Gọi phương thức cập nhật đơn hàng từ service
            orderService.updateOrder(order);
            request.setAttribute("successMessage", "Cập nhật đơn hàng thành công");
            // Gửi phản hồi thành công về cho client (nếu cần)
            response.setStatus(HttpServletResponse.SC_OK);
            response.getWriter().println("Cập nhật đơn hàng thành công");
            
		} catch (Exception e) {
			response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Lỗi khi cập nhật đơn hàng: " + e.getMessage());
            request.setAttribute("errorMessage", "Lỗi khi cập nhật đơn hàng: " + e.getMessage());


		}
	}

}
