package com.clothingstore.model;

import java.sql.Timestamp;

public class DeliveryMethod extends AbstractModel{
	private int delivery_id;
	private String deliveryName;
	private float deliveryPrice;
	private String status;
	
	public DeliveryMethod() {
		
	}
	
	
	public DeliveryMethod(int delivery_id, String deliveryName, float deliveryPrice, String status) {
		this.delivery_id = delivery_id;
		this.deliveryName = deliveryName;
		this.deliveryPrice = deliveryPrice;
		this.status = status;
	}


	public DeliveryMethod(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int delivery_id,
			String deliveryName, float deliveryPrice, String status) {
		super(updateAt, updateBy, createAt, createBy);
		this.delivery_id = delivery_id;
		this.deliveryName = deliveryName;
		this.deliveryPrice = deliveryPrice;
		this.status = status;
	}


	public int getDelivery_id() {
		return delivery_id;
	}
	public void setDelivery_id(int delivery_id) {
		this.delivery_id = delivery_id;
	}
	public String getDeliveryName() {
		return deliveryName;
	}
	public void setDeliveryName(String deliveryName) {
		this.deliveryName = deliveryName;
	}
	public float getDeliveryPrice() {
		return deliveryPrice;
	}
	public void setDeliveryPrice(float deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "DeliveryMethod [delivery_id=" + delivery_id + ", deliveryName=" + deliveryName + ", deliveryPrice="
				+ deliveryPrice + ", status=" + status + "] \n";
	}

	
}
