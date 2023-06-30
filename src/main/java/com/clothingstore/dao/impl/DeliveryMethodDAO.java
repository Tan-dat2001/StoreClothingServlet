package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IDeliveryMethod;
import com.clothingstore.model.DeliveryMethod;

public class DeliveryMethodDAO extends AbstractDAO implements IDeliveryMethod {

	@Override
	public List<DeliveryMethod> getAllDeliveryMethod() {
		List<DeliveryMethod> results = new ArrayList<>();
		DeliveryMethod deliveryMethod = null;
		Connection connection = getConnection();
		String sql = "select * from delivery";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int deliveryId = resultSet.getInt("delivery_id");
					String deliveryName = resultSet.getString("delivery_name");
					float deliveryPrice = resultSet.getFloat("delivery_price");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					deliveryMethod = new DeliveryMethod(updateAt, updateBy, createAt, createBy, deliveryId, deliveryName, deliveryPrice, status);
					results.add(deliveryMethod);
				}
				return results;
			} catch (SQLException e) {
				return null;
			}finally {
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
	public DeliveryMethod getOneDeliveryMethodById(int deliveryId) {
		String sql = "select * from delivery where delivery_id =?";
		DeliveryMethod deliveryMethod = null;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, deliveryId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String deliveryName = resultSet.getString("delivery_name");
					float deliveryPrice = resultSet.getFloat("delivery_price");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					
					deliveryMethod = new DeliveryMethod(updateAt, updateBy, createAt, createBy, deliveryId, deliveryName, deliveryPrice, status);
				}
				return deliveryMethod;
			} catch (SQLException e) {
				return null;
			}finally {
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
	public void createDeliveryMethod(DeliveryMethod deliveryMethod) {
		String sql = "insert into delivery(delivery_name, delivery_price) values (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, deliveryMethod.getDeliveryName());
				statement.setFloat(2, deliveryMethod.getDeliveryPrice());
				statement.executeUpdate();
				
				resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int deliveryId = resultSet.getInt(1);
					deliveryMethod.setDelivery_id(deliveryId);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
					e.printStackTrace();
				}
			}
		}
	}

	@Override
	public void updateDeliveryMethod(DeliveryMethod deliveryMethod) {
		String sql = "update delivery set delivery_name=?, delivery_price=?, status=? where delivery_id=?" ;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, deliveryMethod.getDeliveryName());
				statement.setFloat(2, deliveryMethod.getDeliveryPrice());
				statement.setString(3, deliveryMethod.getStatus());
				statement.setInt(4, deliveryMethod.getDelivery_id());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
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
	public void deleteDeliveryMethod(int deliveryId) {
		String sql = "delete from delivery where delivery_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, deliveryId);
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
	
	public static void main(String[] args) {
		DeliveryMethod deliveryMethod = new DeliveryMethod();
		DeliveryMethodDAO deliveryMethodDAO = new DeliveryMethodDAO();
//		System.out.println(deliveryMethodDAO.getAllDeliveryMethod());
//		System.out.println(deliveryMethodDAO.getOneDeliveryMethodById(2));
//		deliveryMethod.setStatus("enabled");
//		deliveryMethod.setDeliveryName("Giao hàng tiêu chuẩn");
//		deliveryMethod.setDeliveryPrice(30000);
//		deliveryMethod.setDelivery_id(2);
//		deliveryMethodDAO.updateDeliveryMethod(deliveryMethod);
//		deliveryMethodDAO.createDeliveryMethod(deliveryMethod);
//		deliveryMethodDAO.deleteDeliveryMethod(3);
	}

}
