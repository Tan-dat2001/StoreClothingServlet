package com.clothingstore.model;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Order extends AbstractModel {
	private int order_id;
	private int account_id;
	private int delivery_id;
	private int payment_id;
	private int status_id;
	private String paymentTransactionStatus;
//	private Timestamp orderDate;
	private LocalDateTime orderDate;
	private String orderNote;
	private float totalAmount;
	public Order() {

	}
	public Order(int order_id, int account_id, int delivery_id, int payment_id, int status_id,
			String paymentTransactionStatus, LocalDateTime orderDate, String orderNote, float totalAmount) {

		this.order_id = order_id;
		this.account_id = account_id;
		this.delivery_id = delivery_id;
		this.payment_id = payment_id;
		this.status_id = status_id;
		this.paymentTransactionStatus = paymentTransactionStatus;
		this.orderDate = orderDate;
		this.orderNote = orderNote;
		this.totalAmount = totalAmount;
	}
	
	public Order(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int order_id, int account_id,
			int delivery_id, int payment_id, int status_id, String paymentTransactionStatus, LocalDateTime orderDate,
			String orderNote, float totalAmount) {
		super(updateAt, updateBy, createAt, createBy);
		this.order_id = order_id;
		this.account_id = account_id;
		this.delivery_id = delivery_id;
		this.payment_id = payment_id;
		this.status_id = status_id;
		this.paymentTransactionStatus = paymentTransactionStatus;
		this.orderDate = orderDate;
		this.orderNote = orderNote;
		this.totalAmount = totalAmount;
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getPaymentTransactionStatus() {
		return paymentTransactionStatus;
	}
	public void setPaymentTransactionStatus(String paymentTransactionStatus) {
		this.paymentTransactionStatus = paymentTransactionStatus;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getOrderNote() {
		return orderNote;
	}
	public void setOrderNote(String orderNote) {
		this.orderNote = orderNote;
	}
	public float getTotalAmount() {
		return totalAmount;
	}
	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}
	
	
	
	
}
