package com.clothingstore.model;

import java.sql.Timestamp;

public class PaymentMethod  extends AbstractModel{
	private int payment_id;
	private String paymentName;
	private String status;
	public PaymentMethod() {

	}
	public PaymentMethod(int payment_id, String paymentName, String status) {

		this.payment_id = payment_id;
		this.paymentName = paymentName;
		this.status = status;
	}
	
	
	public PaymentMethod(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int payment_id,
			String paymentName, String status) {
		super(updateAt, updateBy, createAt, createBy);
		this.payment_id = payment_id;
		this.paymentName = paymentName;
		this.status = status;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getPaymentName() {
		return paymentName;
	}
	public void setPaymentName(String paymentName) {
		this.paymentName = paymentName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
