package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IOrderDetailDAO;
import com.clothingstore.model.OrderDetail;

public class OrderDetailDAO extends AbstractDAO implements IOrderDetailDAO{

	@Override
	public List<OrderDetail> getAllOrderDetail() {
		List<OrderDetail> results = new ArrayList<>();
		String sql = "select * from order_detail";
		OrderDetail orderDetail = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					
					results.add(new OrderDetail(null, null, null, null, resultSet.getInt("order_detail_id"), resultSet.getInt("product_id"), resultSet.getInt("order_id"), resultSet.getString("discount_code"), resultSet.getFloat("price"), resultSet.getInt("quantity"), resultSet.getFloat("total_amount")));
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
	public OrderDetail getOrderDetailById(int orderDetailId) {
		String sql = "select * from order_detail";
		OrderDetail orderDetail = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderDetailId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					orderDetail = new OrderDetail(null, null, null, null, orderDetailId, resultSet.getInt("product_id"), resultSet.getInt("order_id"), resultSet.getString("discount_code"), resultSet.getFloat("price"), resultSet.getInt("quantity"), resultSet.getFloat("total_amount"));
				}
				return orderDetail;
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
	//not
	@Override
	public void createOrderDetail(OrderDetail orderDetail) {
		// TODO Auto-generated method stub
		
	}
	//not
	@Override
	public void updateOrderDetail(OrderDetail orderDetail) {
		
	}

	@Override
	public void deleteOrderDetail(int orderId) {
		String sql ="delete from order_detail where order_id=?";
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
	public List<OrderDetail> getAllOrderDetailByOrderId(int orderId) {
		List<OrderDetail> results = new ArrayList<>();
		String sql = "select * from order_detail where order_id = ?";
		OrderDetail orderDetail = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					
					results.add(new OrderDetail(null, null, null, null, resultSet.getInt("order_detail_id"), resultSet.getInt("product_id"), orderId, resultSet.getString("discount_code"), resultSet.getFloat("price"), resultSet.getInt("quantity"), resultSet.getFloat("total_amount")));
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
	public static void main(String[] args) {
		OrderDetailDAO orderDetailDAO = new OrderDetailDAO();
		System.out.println(orderDetailDAO.getAllOrderDetailByOrderId(38));
	}
}
