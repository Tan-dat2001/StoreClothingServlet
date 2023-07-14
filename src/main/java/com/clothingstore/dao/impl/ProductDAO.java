package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.clothingstore.dao.IProductDAO;
import com.clothingstore.model.Product;
import com.mysql.cj.protocol.Resultset;
//DONE
public class ProductDAO extends AbstractDAO implements IProductDAO {

	@Override
	public List<Product> getAllProduct() {
		List<Product> results = new ArrayList<>();
		Product product = null;
		String sql = "select * from product order by product_id desc";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					product = new Product(updateAt, updateBy, createAt, createBy, product_id, category_id,
							discount_id, product_name, product_desc, product_price, product_image, purchases, quantity,
							status);
					results.add(product);
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
	public Product getProductById(int id) {
		Product product = null;
		String sql = "select * from product where product_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, id);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					product = new Product(updateAt, updateBy, createAt, createBy, id, category_id, discount_id,
							product_name, product_desc, product_price, product_image, purchases, quantity, status);
				}
				return product;
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
		return product;
	}

	@Override
	public List<Product> getProductByCategoryId(int categoryId) {
		List<Product> results = new ArrayList<>();
		String sql = "select * from product where category_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, categoryId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					Product product = new Product(updateAt, updateBy, createAt, createBy, product_id, categoryId,
							discount_id, product_name, product_desc, product_price, product_image, purchases, quantity,
							status);
					results.add(product);
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
	public void createProduct(Product product) {
		// Bc product_id is auto_increment so we don't need to insert product_id in
		// query sentence.
		String sql = "insert into product(category_id, discount_id, product_name, product_desc, product_price, product_image, quantity)"
				+ " values(?, ?, ?, ?, ?, ?, ?)";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				statement.setInt(1, product.getCategory_id());
				statement.setInt(2, product.getDiscount_id());
				statement.setString(3, product.getProductName());
				statement.setString(4, product.getProductDesc());
				statement.setFloat(5, product.getProductPrice());
				statement.setString(6, product.getProductImage());
				statement.setInt(7, product.getQuantity());
				statement.executeUpdate(); // Thực thi câu query

				// Lấy giá trị product_id được tự động tạo/tăng
				ResultSet generatedKeys = statement.getGeneratedKeys();
				if (generatedKeys.next()) {
					int productId = generatedKeys.getInt(1);
					product.setProduct_id(productId);
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

	@Override
	public void updateProduct(Product product) {
		String sql = "update product set category_id=?, discount_id=?, product_name=?, product_desc=?, "
				+ "product_price=?, product_image=?, quantity=?, status=? where product_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, product.getCategory_id());
				statement.setInt(2, product.getDiscount_id());
				statement.setString(3, product.getProductName());
				statement.setString(4, product.getProductDesc());
				statement.setFloat(5, product.getProductPrice());
				statement.setString(6, product.getProductImage());
				statement.setInt(7, product.getQuantity());
				statement.setString(8, product.getStatus());
				statement.setInt(9, product.getProduct_id());
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
	public void deleteProduct(int productId) {
		String sql = "delete from product where product_id=?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, productId);
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
	public List<Product> getProductByPriceRange(float minPrice, float maxPrice) {
		List<Product> results = new ArrayList<>();
		String sql = "select * from product where product_price >= ? and product_price <= ? ";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setFloat(1, minPrice);
				statement.setFloat(2, maxPrice);

				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Product product = new Product(product_id, category_id, discount_id, product_name, product_desc,
							product_price, product_image, purchases, quantity, status);
					results.add(product);
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
	public List<Product> searchProduct(String keyword) {
		List<Product> results = new ArrayList<>();
		String sql = "select * from product where product_name like ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setString(1, "%" + keyword + "%");
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					Product product = new Product(updateAt, updateBy, createAt, createBy, product_id, category_id,
							discount_id, product_name, product_desc, product_price, product_image, purchases, quantity,
							status);
					results.add(product);
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
	
	
	//Lấy số lượng sản phẩm
	public int getTotalProduct() {
		String sql = "select count(*) from product";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection!=null) {
			try {
				statement = connection.prepareStatement(sql);
				resultSet = statement.executeQuery();
				while(resultSet.next()) {
					//trả về một giá trị số nguyên
					return resultSet.getInt(1);
				}
			} catch (SQLException e) {
				return 0;
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
					return 0;
				}
			}
		}
		return 0;
	}
	
	//index là trng hiện tại
	public List<Product> pagingProduct(int index){
		List<Product> results = new ArrayList<>();
		Product product = null;
		String sql = " SELECT * FROM product ORDER BY product_id desc LIMIT 20 OFFSET ? ";
		//litmit 20 chỉ định 20 sản phẩm được hiển thị
		//offset ? chỉ định bắt đầu từ hàng(row) thứ mấy 
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if(connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				//offset từ index = 1 là trả về 0
				//offset từ index = 2 là trả về 20
				//offset từ index = 3 là trả về 40
				statement.setInt(1, (index-1)*20 );
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					product = new Product(updateAt, updateBy, createAt, createBy, product_id, category_id,
							discount_id, product_name, product_desc, product_price, product_image, purchases, quantity,
							status);
					results.add(product);
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
		return results;
		
	}

	//Lỗi. --> bỏ
	@Override
	public List<Product> getProductByOrderId(int orderId) {
		List<Product> results = new ArrayList<>();
		Product product = null;
		String sql = "select p.* from product p "
				+ "join order_detail od on p.product_id = od.product_id"
				+ "where od.order_id = ?";
		Connection connection = getConnection();
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		if (connection != null) {
			try {
				statement = connection.prepareStatement(sql);
				statement.setInt(1, orderId);
				resultSet = statement.executeQuery();
				while (resultSet.next()) {
					int product_id = resultSet.getInt("product_id");
					int category_id = resultSet.getInt("category_id");
					int discount_id = resultSet.getInt("discount_id");
					String product_name = resultSet.getString("product_name");
					String product_desc = resultSet.getString("product_desc");
					float product_price = resultSet.getFloat("product_price");
					String product_image = resultSet.getString("product_image");
					int purchases = resultSet.getInt("purchases");
					int quantity = resultSet.getInt("quantity");
					String status = resultSet.getString("status");
					Timestamp createAt = resultSet.getTimestamp("create_at");
					String createBy = resultSet.getString("create_by");
					Timestamp updateAt = resultSet.getTimestamp("update_at");
					String updateBy = resultSet.getString("update_by");
					product = new Product(updateAt, updateBy, createAt, createBy, product_id, category_id,
							discount_id, product_name, product_desc, product_price, product_image, purchases, quantity,
							status);
					results.add(product);
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
		ProductDAO productDAO = new ProductDAO();
		Product product = new Product();
//		product.setCategory_id(1);
//		product.setDiscount_id(1);
//		product.setProductName("Áo sơ mi Torano ABCDXYZ");
//		product.setProductDesc("Co giãn tốt, chất liệu vải thiên nhiên");
//		product.setProductPrice(5555000);
//		product.setProductImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTQ2PrKjcquzshqyA5UrJOpc-RelJUchBPxeIOiuqk&s");
//		product.setQuantity(250);
//		product.setStatus("enabled");
//		product.setProduct_id(54);
//		productDAO.createProduct(product);
//		System.out.println(productDAO.getAllProduct().toString());
//		System.out.println(productDAO.getProductById(1));
//		System.out.println(productDAO.getProductByCategoryId(2));
//		System.out.println(productDAO.getProductByPriceRange(500000, 1000000));
//		productDAO.updateProduct(product);
//		productDAO.deleteProduct(53);
//		System.out.println(productDAO.searchProduct("ao"));
//		int count = productDAO.getTotalProduct();
//		System.out.println(count);
//		System.out.println(productDAO.pagingProduct(3).toString());
		System.out.println(productDAO.getProductByOrderId(40));
	}
}
