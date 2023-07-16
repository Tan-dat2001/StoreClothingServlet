package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IOrderStatusDAO;
import com.clothingstore.model.Category;
import com.clothingstore.model.OrderStatus;

public class OrderStatusDAO extends AbstractDAO implements IOrderStatusDAO {

	@Override
	public List<OrderStatus> getAllOrderStatus() {
		List<OrderStatus> results = new ArrayList<>();
		String sql = "select * from order_status";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql); //ps thực thi push câu query .
				resultSet = statement.executeQuery(); // thực hiện câu lệnh query trả dữ liệu về đối tượng resultSet có dạng table.
				while(resultSet.next()) { // nếu có dữ liệu trong table
					
					int status_id = resultSet.getInt("status_id");
					String status_name = resultSet.getString("status_name");
					
					OrderStatus orderStatus = new OrderStatus(status_id, status_name);
					results.add(orderStatus);	
				}
				return results; //khi connection khác null mới vào đây thực hiện câu lệnh và trả về danh sách 
			} catch (SQLException e) {
				return null; 
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close(); 
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null; // khi connection = null thì trả về null.
	}

	@Override
	public OrderStatus getOneOrderStatusById(int statusId) {
		String sql = "select * from order_status where status_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql); //ps thực thi push câu query .
				statement.setInt(1, statusId);
				resultSet = statement.executeQuery(); // thực hiện câu lệnh query trả dữ liệu về đối tượng resultSet có dạng table.
				while(resultSet.next()) { // nếu có dữ liệu trong table
					String status_name = resultSet.getString("status_name");
					OrderStatus orderStatus = new OrderStatus(statusId, status_name);
					return orderStatus; //khi connection khác null mới vào đây thực hiện câu lệnh và trả về danh sách 
				}
			} catch (SQLException e) {
				return null; 
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if(statement != null) {
						statement.close();
					}
					if(resultSet != null) {
						resultSet.close(); 
					}
				} catch (SQLException e) {
					return null;
				}
			}
		}
		return null; // khi connection = null thì trả về null.
	}

	@Override
	public void createOrderStatus(OrderStatus orderStatus) {
		String sql = "insert into order_status(status_name) values(?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, orderStatus.getStatusName());
				statement.executeUpdate();
				
				generatedKeys = statement.getGeneratedKeys();
				if(generatedKeys.next()) {
					int statusId = generatedKeys.getInt(1);
					orderStatus.setStatus_id(statusId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				try {
					if(connection != null) {
						connection.close();
					}
					if (statement != null) {
						statement.close();
					}
					//??? Close ResultSet
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updatePaymentMethod(OrderStatus orderStatus) {
		String sql = "update order_status set status_name = ? where status_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, orderStatus.getStatusName());
				statement.setInt(2, orderStatus.getStatus_id());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteOrderStatus(int statusId) {
		String sql = "delete from order_status where status_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, statusId);
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

}
