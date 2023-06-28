package com.clothingstore.model;

import java.sql.Timestamp;

public class Product extends AbstractModel{
	private int product_id;
	private int category_id;
	private int discount_id;
	private String productName;
	private String productDesc;
	private float productPrice;
	private String productImage;
	private int purchases;
	private int quantity;
	private String status;
	
	public Product() {
	}
	
	public Product(int product_id, int category_id, int discount_id, String productName, String productDesc,
			float productPrice, String productImage, int purchases, int quantity, String status) {
		this.product_id = product_id;
		this.category_id = category_id;
		this.discount_id = discount_id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.purchases = purchases;
		this.quantity = quantity;
		this.status = status;
	}
	
	public Product(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int product_id,
			int category_id, int discount_id, String productName, String productDesc, float productPrice,
			String productImage, int purchases, int quantity, String status) {
		super(updateAt, updateBy, createAt, createBy);
		this.product_id = product_id;
		this.category_id = category_id;
		this.discount_id = discount_id;
		this.productName = productName;
		this.productDesc = productDesc;
		this.productPrice = productPrice;
		this.productImage = productImage;
		this.purchases = purchases;
		this.quantity = quantity;
		this.status = status;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getCategory_id() {
		return category_id;
	}
	public void setCategory_id(int category_id) {
		this.category_id = category_id;
	}
	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public float getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(float productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductImage() {
		return productImage;
	}
	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}
	public int getPurchases() {
		return purchases;
	}
	public void setPurchases(int purchases) {
		this.purchases = purchases;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
