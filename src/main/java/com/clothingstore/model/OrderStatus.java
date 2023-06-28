package com.clothingstore.model;

public class OrderStatus {
	private int status_id;
	private String statusName;
	public OrderStatus() {
	}
	public OrderStatus(int status_id, String statusName) {
		super();
		this.status_id = status_id;
		this.statusName = statusName;
	}
	public int getStatus_id() {
		return status_id;
	}
	public void setStatus_id(int status_id) {
		this.status_id = status_id;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	
	

}
