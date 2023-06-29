package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IPaymentMethod;
import com.clothingstore.model.Category;
import com.clothingstore.model.PaymentMethod;
//DONE
public class PaymentMethodDAO extends AbstractDAO implements IPaymentMethod{

	@Override
	public List<PaymentMethod> getAllPaymentMethod() {
		List<PaymentMethod> results = new ArrayList<>();
		PaymentMethod paymentMethod = null;
		String sql = "select * from payment";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int paymentId = resultSet.getInt("payment_id");
					String paymentName = resultSet.getString("payment_name");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					paymentMethod = new PaymentMethod(updateAt, updateBy, createAt, createBy, paymentId, paymentName, status);
					results.add(paymentMethod);
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
	public PaymentMethod getOnePaymentMethodById(int paymentId) {
		PaymentMethod paymentMethod = null;
		String sql = "select * from payment where payment_id = ?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Connection connection = getConnection();
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, paymentId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String paymentName = resultSet.getString("payment_name");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					paymentMethod = new PaymentMethod(updateAt, updateBy, createAt, createBy, paymentId, paymentName, status);
					
				}
				return paymentMethod;
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
	public void createPaymentMethod(PaymentMethod paymentMethod) {
		String sql = "insert into payment(payment_name, status) values (?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, paymentMethod.getPaymentName());
				statement.setString(2, paymentMethod.getStatus());
				statement.executeUpdate();
				
				resultSet = statement.getGeneratedKeys();
				if(resultSet.next()) {
					int paymentId = resultSet.getInt(1);
					paymentMethod.setPayment_id(paymentId);
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
	public void updatePaymentMethod(PaymentMethod paymentMethod) {
		String sql = "update payment set payment_name=?, status=? where payment_id=?" ;
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, paymentMethod.getPaymentName());
				statement.setString(2, paymentMethod.getStatus());
				statement.setInt(3, paymentMethod.getPayment_id());
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
	public void deletePaymentMethod(int paymentId) {
		String sql = "delete from payment where payment_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, paymentId);
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
		PaymentMethod paymentMethod = new PaymentMethod();
		PaymentMethodDAO paymentMethodDAO = new PaymentMethodDAO();
		paymentMethod.setPaymentName("COD");
		paymentMethod.setStatus("enabled");
		paymentMethod.setPayment_id(6);
//		paymentMethodDAO.createPaymentMethod(paymentMethod);
//		paymentMethodDAO.updatePaymentMethod(paymentMethod);
//		paymentMethodDAO.deletePaymentMethod(6);
//		System.out.println(paymentMethodDAO.getAllPaymentMethod());
//		System.out.println(paymentMethodDAO.getOnePaymentMethodById(2));
	}
}
