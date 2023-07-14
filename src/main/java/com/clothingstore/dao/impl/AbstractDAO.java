package com.clothingstore.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AbstractDAO {
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); // load driver
			String url = "jdbc:mysql://localhost:3306/clothes_ecom";
			String user = "root";
			String password = "280412092312";
			return DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			return null;
		}
	}
}
