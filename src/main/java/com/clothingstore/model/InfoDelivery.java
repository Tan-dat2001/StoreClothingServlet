package com.clothingstore.model;

public class InfoDelivery {
	int infoId;
	int orderId;
	int orderDetailId;
	String name;
	String phone;
	String address;
	String note;	
	int accountId;
	public InfoDelivery() {
		
	}

	
	


	public InfoDelivery(int orderId,  String name, String phone, String address, String note,
			int accountId) {
		super();
		this.orderId = orderId;
		this.name = name;
		this.phone = phone;
		this.address = address;
		this.note = note;
		this.accountId = accountId;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public int getInfoId() {
		return infoId;
	}

	public void setInfoId(int infoId) {
		this.infoId = infoId;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getOrderDetailId() {
		return orderDetailId;
	}

	public void setOrderDetailId(int orderDetailId) {
		this.orderDetailId = orderDetailId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}
	
}
