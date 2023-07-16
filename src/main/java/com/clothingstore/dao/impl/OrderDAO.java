package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IOrderDAO;
import com.clothingstore.model.Account;
import com.clothingstore.model.Cart;
import com.clothingstore.model.Item;
import com.clothingstore.model.Order;
import com.clothingstore.model.Product;
import com.mysql.cj.protocol.Resultset;

public class OrderDAO extends AbstractDAO implements IOrderDAO {
	
	
	@Override
	public List<Order> getAllOrder() {
		List<Order> results = new ArrayList<>();
		String sql = "select * from orderclothes ";
		Order order = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int orderId = resultSet.getInt("order_id");
					int accountId = resultSet.getInt("account_id");
					int paymentId = resultSet.getInt("payment_id");
					int deliveryId = resultSet.getInt("delivery_id");
					int statusId = resultSet.getInt("status_id");
					String paymentTransaction = resultSet.getString("payment_transaction");
					Timestamp timestamp = resultSet.getTimestamp("order_date");
					LocalDateTime orderDate = timestamp.toLocalDateTime();
					String orderNote = resultSet.getString("order_note");
					Float totalAmount = resultSet.getFloat("total_amount");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					order = new Order(updateAt, updateBy, createAt, createBy, orderId, accountId, deliveryId, paymentId, statusId, paymentTransaction, orderDate, orderNote, totalAmount);
					results.add(order);
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public Order getOrderById(int orderId) {
		String sql = "select * from orderclothes where order_id=?";
		Order order = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int accountId = resultSet.getInt("account_id");
					int paymentId = resultSet.getInt("payment_id");
					int deliveryId = resultSet.getInt("delivery_id");
					int statusId = resultSet.getInt("status_id");
					String paymentTransaction = resultSet.getString("payment_transaction");
					Timestamp timestamp = resultSet.getTimestamp("order_date");
					LocalDateTime orderDate = timestamp.toLocalDateTime();
					String orderNote = resultSet.getString("order_note");
					Float totalAmount = resultSet.getFloat("total_amount");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					order = new Order(updateAt, updateBy, createAt, createBy, orderId, accountId, deliveryId, paymentId, statusId, paymentTransaction, orderDate, orderNote, totalAmount);
				}
				return order;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null;
	}

	@Override
	public void createOrder(Order order) {
		
	}

	@Override
	public void updateOrder(Order order) {
		String sql = "update orderclothes set status_id=?, payment_transaction=? where order_id=? ";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, order.getStatus_id());
				statement.setString(2, order.getPaymentTransactionStatus());
				statement.setInt(3, order.getOrder_id());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}

	@Override
	public void deleteOrder(int orderId) {
		OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
		InfoDAO infoDAO = new InfoDAO();
		infoDAO.deleteInfoDelivery(orderId);
		orderDetailDAO.deleteOrderDetail(orderId);
		String sql = "delete from orderclothes where order_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderId);
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
		}
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
				String sql = "insert into orderclothes(account_id, payment_id, delivery_id, payment_transaction, order_date, order_note, total_amount) values(?,?,?,?,?,?,?)";
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, account.getAccount_id());
				statement.setInt(2, order.getPayment_id());
				statement.setInt(3, order.getDelivery_id());
				statement.setString(4, order.getPaymentTransactionStatus());
				statement.setString(5, dateTime);
				statement.setString(6, order.getOrderNote());
				statement.setFloat(7, order.getTotalAmount());
				statement.executeUpdate();
				generatedKeys = statement.getGeneratedKeys();
				if(generatedKeys.next()) {
					int orderId = generatedKeys.getInt(1);
					order.setOrder_id(orderId);
				}
				generatedKeys.close();
				statement.close();
				// Lấy id của order vừa add
				String sql1 = "select max(order_id) as order_id from orderclothes";
				PreparedStatement statement1 = connection.prepareStatement(sql1);
				ResultSet resultset1 = statement1.executeQuery();
				if(resultset1.next()) {
					int orderId = resultset1.getInt("order_id");
					for(Item i:cart.getItems()) {
						String sql2= "insert into order_detail(product_id, order_id, price, quantity, total_amount) values(?,?,?,?,?)";
						PreparedStatement statement2 = connection.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
//						ResultSet generatedKeys2 = null;
						statement2.setInt(1, i.getProduct().getProduct_id());
						statement2.setInt(2, orderId);
						statement2.setFloat(3, i.getPrice());
						statement2.setFloat(4, i.getQuantity());
						statement2.setFloat(5, i.getTotalAmount());
						statement2.executeUpdate();
					}
				}
				statement1.close();
				resultset1.close();
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
	public static void main(String[] args) {
		OrderDAO orderDAO = new OrderDAO();
		Product product = new Product(66, 1, 1, "tất", "mô tả", 500, null, 0, 2, "enabled");
		Cart cart = new Cart();
		Item item = new Item(product, 3, 1000);
		cart.addItem(item);
		Account account = new Account(16, "linh@gmail.com", "linhdien","linh123", "user", "enabled", "nữ", "fptsoft", null, null);
		Order order = new Order(0, 16, 1, 1, 1, "unpaid", java.time.LocalDateTime.now(), "fptsoft", 5000);
//		orderDAO.addOrder(account, cart, order);
		orderDAO.deleteOrder(42);
		
	}

	@Override
	public List<Order> getAllOrderByAccountId(int accountId) {
		List<Order> results = new ArrayList<>();
		String sql = "select * from orderclothes where account_id=? ";
		Order order = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, accountId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int orderId = resultSet.getInt("order_id");
					int paymentId = resultSet.getInt("payment_id");
					int deliveryId = resultSet.getInt("delivery_id");
					int statusId = resultSet.getInt("status_id");
					String paymentTransaction = resultSet.getString("payment_transaction");
					Timestamp timestamp = resultSet.getTimestamp("order_date");
					LocalDateTime orderDate = timestamp.toLocalDateTime();
					String orderNote = resultSet.getString("order_note");
					Float totalAmount = resultSet.getFloat("total_amount");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					order = new Order(updateAt, updateBy, createAt, createBy, orderId, accountId, deliveryId, paymentId, statusId, paymentTransaction, orderDate, orderNote, totalAmount);
					results.add(order);
				}
				return results;
			} catch (SQLException e) {
				return null;
			} finally {
				try {
					if (connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					if (resultSet != null) {
						resultSet.close();
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null;
	}
}
