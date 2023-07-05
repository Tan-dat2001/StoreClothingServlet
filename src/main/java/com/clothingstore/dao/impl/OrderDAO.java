package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import com.clothingstore.dao.IOrderDAO;
import com.clothingstore.model.Account;
import com.clothingstore.model.Cart;
import com.clothingstore.model.Item;
import com.clothingstore.model.Order;
import com.mysql.cj.protocol.Resultset;

public class OrderDAO extends AbstractDAO implements IOrderDAO {

	@Override
	public List<Order> getAllOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order getOrderById(int orderId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createOrder(Order order) {
		
	}

	@Override
	public void updateOrder(Order order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(int orderId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addOrder(Account account, Cart cart,  Order order) {
		LocalDateTime currentTime = java.time.LocalDateTime.now();
		String dateTime = currentTime.toString();
		Connection connection = getConnection();
		if(connection != null) {
			try {
				//Add item vào order
				PreparedStatement statement = null;
				ResultSet generatedKeys = null;
				String sql = "insert into orderclothes(account_id, payment_id, delivery_id, order_date, order_note, total_amount) values(?,?,?,?,?,?)";
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, account.getAccount_id());
				statement.setInt(2, order.getPayment_id());
				statement.setInt(3, order.getDelivery_id());
				statement.setString(4, dateTime);
				statement.setString(5, order.getOrderNote());
				statement.setFloat(6, order.getTotalAmount());
				statement.executeUpdate();
				generatedKeys = statement.getGeneratedKeys();
				if(generatedKeys.next()) {
					int orderId = generatedKeys.getInt(1);
					order.setOrder_id(orderId);
				}
				generatedKeys.close();
				statement.close();
				// Lấy id của order vừa add
				String sql1 = "select max(order_id) as order_id from order";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				ResultSet resultset1 = statement1.executeQuery();
				if(resultset1.next()) {
					int orderId = resultset1.getInt("order_id");
					for(Item i:cart.getItems()) {
						String sql2= "insert into order_detail(product_id, order_id, price, quantity) values(?,?,?,?)";
						PreparedStatement statement2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
//						ResultSet generatedKeys2 = null;
						statement2.setInt(1, i.getProduct().getProduct_id());
						statement2.setInt(2, orderId);
						statement2.setFloat(3, i.getPrice());
						statement2.setFloat(4, i.getQuantity());
						statement2.executeUpdate();
					}
				}
				statement1.close();
				String sql3 = "update product set quantity = quantity - ? where product_id=?";
				PreparedStatement statement3 = connection.prepareStatement(sql3);
				for(Item i:cart.getItems()) {
					statement3.setInt(1, i.getQuantity());
					statement3.setInt(2, i.getProduct().getProduct_id());
					statement3.executeUpdate();
				}
				statement3.close();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

}
