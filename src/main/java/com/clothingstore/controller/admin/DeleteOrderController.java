package com.clothingstore.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.clothingstore.service.IOrderService;

@WebServlet(urlPatterns = "/admin-deleteOrder")
public class DeleteOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public DeleteOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }
    @Inject
    private IOrderService orderService;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		orderService.deleteOrder(orderId);
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/admin/order.jsp");
		rd.forward(request, response);
		response.sendRedirect("admin-order");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
