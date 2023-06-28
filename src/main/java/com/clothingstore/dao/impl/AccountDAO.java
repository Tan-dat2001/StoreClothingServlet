package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IAccountDAO;
import com.clothingstore.model.Account;

public class AccountDAO extends AbstractDAO implements IAccountDAO {

	@Override
	public List<Account> getAllAccount() {
		Account account = null;
		List<Account> results = new ArrayList<>();
		String sql = "select * from account";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int accountId = resultSet.getInt("account_id");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					String name = resultSet.getString("name");
					String role = resultSet.getString("role");
					String status = resultSet.getString("status");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					Date dateOfBirth = resultSet.getDate("dateofbirth");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");

					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name,
							role, status, gender, address, phone, dateOfBirth);
					results.add(account);
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
	public Account getAccountById(int accountId) {
		Account account = null;
		String sql = "select * from account where account_id = ? ";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, accountId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					String name = resultSet.getString("name");
					String role = resultSet.getString("role");
					String status = resultSet.getString("status");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					Date dateOfBirth = resultSet.getDate("dateofbirth");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");

					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name,
							role, status, gender, address, phone, dateOfBirth);
				}
				return account;
			} catch (SQLException e) {
				// TODO: handle exception
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
	public Account getAccountByEmail(String email) {
		Account account = null;
		String sql = "select * from account where email = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int accountId = resultSet.getInt("account_id");
					String password = resultSet.getString("password");
					String name = resultSet.getString("name");
					String role = resultSet.getString("role");
					String status = resultSet.getString("status");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					Date dateOfBirth = resultSet.getDate("dateofbirth");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");

					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name,
							role, status, gender, address, phone, dateOfBirth);
				}
				return account;
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
	public List<Account> getAllAccountByStatus(String isActive) {
		List<Account> results = new ArrayList<>();
		Account account = null;
		String sql = "select * from account where status = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, isActive);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					int accountId = resultSet.getInt("account_id");
					String email = resultSet.getString("email");
					String password = resultSet.getString("password");
					String name = resultSet.getString("name");
					String role = resultSet.getString("role");
					String gender = resultSet.getString("gender");
					String address = resultSet.getString("address");
					String phone = resultSet.getString("phone");
					Date dateOfBirth = resultSet.getDate("dateofbirth");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");
					
					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name, role, isActive, gender, address, phone, dateOfBirth);
					results.add(account);
				}
				return results;
			} catch (SQLException e) {
				// TODO: handle exception
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
	public void createAccount(Account account) {
		String sql = "insert into account(email,password,name,gender,address,phone) values(?,?,?,?,?,?)";
	}

	@Override
	public void updateAccount(Account account) {
		// TODO Auto-generated method stub
	}

	@Override
	public void deleteAccount(int accountId) {
		// TODO Auto-generated method stub
	}

	

}
