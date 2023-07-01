package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
					Timestamp updateAt = resultSet.getTimestamp("update_at");
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
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");

					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name,
							role, status, gender, address, phone, dateOfBirth);
					return account;
				}
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
					Timestamp updateAt = resultSet.getTimestamp("update_at");
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
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, isActive);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
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
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");

					account = new Account(updateAt, updateBy, createAt, createBy, accountId, email, password, name,
							role, isActive, gender, address, phone, dateOfBirth);
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
		String sql = "insert into account(email,password,name,gender) values(?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, account.getEmail());
				statement.setString(2, account.getPassword());
				statement.setString(3, account.getName());
				statement.setString(4, account.getGender());
				statement.executeUpdate();

				resultSet = statement.getGeneratedKeys();
				if (resultSet.next()) {
					int accountId = resultSet.getInt(1);
					account.setAccount_id(accountId);
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
	public void updateAccount(Account account) {
		String sql = "update account set email=?, password=?, name=?, gender=?, address=?, phone=?, dateofbirth=? where account_id=? ";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, account.getEmail());
				statement.setString(2, account.getPassword());
				statement.setString(3, account.getName());
				statement.setString(4, account.getGender());
				statement.setString(5, account.getAddress());
				statement.setString(6, account.getPhone());
				statement.setDate(7, account.getDateOfBirth());
				statement.setInt(8, account.getAccount_id());
				statement.executeUpdate();
			} catch (SQLException e) {
				// TODO: handle exception
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
	public void deleteAccount(int accountId) {
		String sql = "delete from account where account_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, accountId);
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
	public boolean checkLogin(String email, String password) {
		boolean isValid = false;
		Connection connection = getConnection();
		String sql = "select * from account where email =?  and password=?";
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, email);
				statement.setString(2, password);
				resultSet = statement.executeQuery();
				if(resultSet.next()) {
					isValid = true;
				}else {
					isValid = false;
				}
			} catch (SQLException e) {
				return false;
			}
		}
		return isValid;
	}

//	@SuppressWarnings("deprecation")
//  Test - chưa test createAccount
	public static void main(String[] args) {
		AccountDAO accountDAO = new AccountDAO();
		Account newAccount = new Account();
		newAccount.setAccount_id(8);
		newAccount.setEmail("ntd123@gmail.com");
		newAccount.setPassword("000000");
		newAccount.setName("nguyen tan dat");
		newAccount.setGender("nam");
		newAccount.setAddress("DUY NGHIA, DUY XUYEN, QUANG NAM");
		newAccount.setPhone("0954545555");
		newAccount.setDateOfBirth(new Date(2001 - 1900, 3, 13));
//		accountDAO.updateAccount(newAccount);
//		accountDAO.deleteAccount(4);
//		System.out.println(accountDAO.getAccountById(1).toString());
//		System.out.println(accountDAO.getAllAccount());
//		System.out.println(accountDAO.getAccountByEmail("bigboss@gmail.com"));
		accountDAO.updateAccount(newAccount);
	}

}
