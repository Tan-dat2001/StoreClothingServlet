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
import com.clothingstore.model.Product;
import com.clothingstore.service.ICategoryService;
import com.clothingstore.service.IOrderDetailService;
import com.clothingstore.service.IOrderService;
import com.clothingstore.service.IProductService;

@WebServlet(urlPatterns = "/orderDetail-page")
public class OrderDetailPageController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Inject
    private ICategoryService categoryService;
	@Inject
	private IOrderDetailService orderDetailService;
	@Inject
	private IOrderService orderService;
	@Inject
	private IProductService productService;
    public OrderDetailPageController() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> listCategoriesAo = categoryService.getCategoriesByWord("ao");
		request.setAttribute("listCategoriesAo", listCategoriesAo);

		List<Category> listCategoriesQuan = categoryService.getCategoriesByWord("quan");
		request.setAttribute("listCategoriesQuan", listCategoriesQuan);
		
		HttpSession session = request.getSession();
		Account account = (Account)session.getAttribute("currentAccount");
		int orderId = Integer.parseInt(request.getParameter("orderId"));
		//lấy thông tin vận chuyển ở page checkout
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
//			request.setAttribute("product", product);
			products.add(product);
			request.setAttribute("products", products);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/views/web/orderDetail.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
