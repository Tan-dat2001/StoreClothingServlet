package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IDiscountDAO;
import com.clothingstore.model.Category;
import com.clothingstore.model.Discount;

public class DiscountDAO extends AbstractDAO implements IDiscountDAO {

	@Override
	public List<Discount> getAllDiscount() {
		List<Discount> results = new ArrayList<>();
		String sql = "select * from discount";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql); //ps thực thi push câu query .
				resultSet = statement.executeQuery(); // thực hiện câu lệnh query trả dữ liệu về đối tượng resultSet có dạng table.
				while(resultSet.next()) { // nếu có dữ liệu trong table
					
					int discount_id = resultSet.getInt("discount_id");
					String discountName = resultSet.getString("discount_name");
					Date discountStart = resultSet.getDate("discount_start");
					Date discountEnd = resultSet.getDate("discount_end");	
					int quantity = resultSet.getInt("quantity");
					float discountPrice = resultSet.getFloat("discount_price");
					String discountCode = resultSet.getString("discount_code");
					String discountStatus = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					
					Discount discount = new Discount(updateAt, updateBy, createAt, createBy, discount_id, discountName, discountStart, discountEnd, quantity, discountPrice, discountCode, discountStatus); 
					results.add(discount);	
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
	public Discount getOneCategoryById(int discountId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCategory(Discount discount) {
		String sql = "insert into discount(discount_name, discount_start, discount_end, quantity, discount_price,discount_code) values(?,?,?,?,?,?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet generatedKeys = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setString(1, discount.getDiscountName());
				statement.setDate(2, discount.getDiscountStart() );
				statement.setDate(3, discount.getDiscountEnd());
				statement.setInt(4, discount.getQuantity());
				statement.setFloat(5, discount.getDiscountPrice());
				statement.setString(6, discount.getDiscountCode());
				statement.executeUpdate();
				
				generatedKeys = statement.getGeneratedKeys();
				if(generatedKeys.next()) {
					int discountId = generatedKeys.getInt(1);
					discount.setDiscount_id(discountId);;
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
	public void updateCategory(Discount discount) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCategory(int discountId) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		DiscountDAO discountDAO = new DiscountDAO();
		Discount discount = new Discount();
		System.out.println(discountDAO.getAllDiscount());
//		discount.setDiscountName("Giảm 5 triệu đồng");
//		discount.setDiscountStart(new Date(2023-1900, 7, 23));
//		discount.setDiscountEnd(new Date(2023-1900, 9, 23));
//		discount.setQuantity(10);
//		discount.setDiscountPrice(5000000);
//		discount.setDiscountCode("G5T");
//		discountDAO.createCategory(discount);
		
	}
}
