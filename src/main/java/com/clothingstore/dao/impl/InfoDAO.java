package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.model.InfoDelivery;

public class InfoDAO extends AbstractDAO {
	public List<InfoDelivery> getInfoDeliveryById(int infoId){
		List<InfoDelivery> results = new ArrayList<>();
		String sql = "select * from info_delivery where info_id=?";
		InfoDelivery infoDelivery = null;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, infoId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int orderId = resultSet.getInt("order_id");
					String name = resultSet.getString("name");
					String phone = resultSet.getString("phone");
					String address = resultSet.getString("address");
					String note = resultSet.getString("note");
					int accountId = resultSet.getInt("account_id");
					infoDelivery = new InfoDelivery(orderId, name, phone, address, note, accountId);
					results.add(infoDelivery);
					}
				return results;
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
		return null;
		
	}
	
	public InfoDelivery getInfoDeliveryByOrderId(int orderId){
		String sql = "select * from info_delivery where order_id=?";
		InfoDelivery infoDelivery = null;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String name = resultSet.getString("name");
					String phone = resultSet.getString("phone");
					String address = resultSet.getString("address");
					String note = resultSet.getString("note");
					int accountId = resultSet.getInt("account_id");
					infoDelivery = new InfoDelivery(orderId, name, phone, address, note, accountId);
					}
				return infoDelivery;
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
		return null;
		
	}
	
	
	public void createInfoDelivery(InfoDelivery infoDelivery) {
		String sql = "insert into info_delivery(order_id, name, phone, address, note, account_id) values(?,?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement statement =null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, infoDelivery.getOrderId());
				statement.setString(2, infoDelivery.getName());
				statement.setString(3, infoDelivery.getPhone());
				statement.setString(4, infoDelivery.getAddress());
				statement.setString(5, infoDelivery.getNote());
				statement.setInt(6, infoDelivery.getAccountId());
				statement.executeUpdate();
				
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					int infoId = generatedKeys.getInt(1);
					infoDelivery.setInfoId(infoId);
				}
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
					// ??? Close ResultSet
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
