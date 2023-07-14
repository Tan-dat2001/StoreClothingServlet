package com.clothingstore.model;

import java.sql.Timestamp;

public class OrderDetail extends AbstractModel{
	private int orderDetail_id;
	private int product_id;
	private int order_id;
	private String discountCode;
	private float price;
	private int quantity;
	private float totalAmount;
	public OrderDetail() {
		
	}
	public OrderDetail(int orderDetail_id, int product_id, int order_id, String discountCode, float price, int quantity,
			float totalAmount) {

		this.orderDetail_id = orderDetail_id;
		this.product_id = product_id;
		this.order_id = order_id;
		this.discountCode = discountCode;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	
	
	public OrderDetail(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int orderDetail_id,
			int product_id, int order_id, String discountCode, float price, int quantity, float totalAmount) {
		super(updateAt, updateBy, createAt, createBy);
		this.orderDetail_id = orderDetail_id;
		this.product_id = product_id;
		this.order_id = order_id;
		this.discountCode = discountCode;
		this.price = price;
		this.quantity = quantity;
		this.totalAmount = totalAmount;
	}
	public int getOrderDetail_id() {
		return orderDetail_id;
	}
	public void setOrderDetail_id(int orderDetail_id) {
		this.orderDetail_id = orderDetail_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	@Override
	public String toString() {
		return "OrderDetail [orderDetail_id=" + orderDetail_id + ", product_id=" + product_id + ", order_id=" + order_id
				+ ", discountCode=" + discountCode + ", price=" + price + ", quantity=" + quantity + ", totalAmount="
				+ totalAmount + "]\n";
	}
	
	
}
