package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.ICategoryDAO;
import com.clothingstore.model.Category;

public class CategoryDAO extends AbstractDAO implements ICategoryDAO {

	@Override
	public List<Category> getAllCategory() {
		List<Category> results = new ArrayList<>();
		String sql = "select * from category";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql); //ps thực thi push câu query .
				resultSet = statement.executeQuery(); // thực hiện câu lệnh query trả dữ liệu về đối tượng resultSet có dạng table.
				while(resultSet.next()) { // nếu có dữ liệu trong table
					
					int category_id = resultSet.getInt("category_id");
					String category_name = resultSet.getString("category_name");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");
					
					Category category = new Category(updateAt, updateBy, createAt, createBy, category_id, category_name);
					results.add(category);	
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
	public Category getOneCategoryById(int categoryId) {
		Category category = null;
		String sql = "select * from category where category_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, categoryId);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					String categoryName = resultSet.getString("category_name");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_by");
					String updateBy = resultSet.getString("update_by");
					category  = new Category(updateAt, updateBy, createAt, createBy, categoryId, categoryName);
					
				}
				return category;
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
	public void createCategory(Category category) {
		String sql = "insert into category(category_name)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, category.getCategoryName());
				statement.executeUpdate();
				
				generatedKeys = statement.getGeneratedKeys();
				if(generatedKeys.next()) {
					int categoryId = generatedKeys.getInt(1);
					category.setCategory_id(categoryId);
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
	public void updateCategory(Category category) {
		String sql = "update category set category_name = ? where category_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, category.getCategoryName());
				statement.setInt(2, category.getCategory_id());
				statement.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void deleteCategory(int categoryId) {
		String sql = "delete from category where category_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, categoryId);
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
