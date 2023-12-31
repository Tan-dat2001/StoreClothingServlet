package com.clothingstore.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Discount extends AbstractModel{
	private int discount_id;
	private String discountName;
	private Date discountStart;
	private Date discountEnd;
	private int quantity;
	private float discountPrice;
	private String discountCode;
	private String status;
	public Discount() {

	}
	
	
	public Discount(int discount_id, String discountName, Date discountStart, Date discountEnd,
			int quantity, float discountPrice, String discountCode, String status) {
		this.discount_id = discount_id;
		this.discountName = discountName;
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
		this.quantity = quantity;
		this.discountPrice = discountPrice;
		this.discountCode = discountCode;
		this.status = status;
	}
	
	


	public Discount(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int discount_id,
			String discountName, Date discountStart, Date discountEnd, int quantity,
			float discountPrice, String discountCode, String status) {
		super(updateAt, updateBy, createAt, createBy);
		this.discount_id = discount_id;
		this.discountName = discountName;
		this.discountStart = discountStart;
		this.discountEnd = discountEnd;
		this.quantity = quantity;
		this.discountPrice = discountPrice;
		this.discountCode = discountCode;
		this.status = status;
	}


	public int getDiscount_id() {
		return discount_id;
	}
	public void setDiscount_id(int discount_id) {
		this.discount_id = discount_id;
	}
	public String getDiscountName() {
		return discountName;
	}
	public void setDiscountName(String discountName) {
		this.discountName = discountName;
	}
	public Date getDiscountStart() {
		return discountStart;
	}
	public void setDiscountStart(Date discountStart) {
		this.discountStart = discountStart;
	}
	public Date getDiscountEnd() {
		return discountEnd;
	}
	public void setDiscountEnd(Date discountEnd) {
		this.discountEnd = discountEnd;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(float discountPrice) {
		this.discountPrice = discountPrice;
	}
	public String getDiscountCode() {
		return discountCode;
	}
	public void setDiscountCode(String discountCode) {
		this.discountCode = discountCode;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Discount [discount_id=" + discount_id + ", discountName=" + discountName + ", discountStart="
				+ discountStart + ", discountEnd=" + discountEnd + ", quantity=" + quantity + ", discountPrice="
				+ discountPrice + ", discountCode=" + discountCode + ", status=" + status + ", getUpdateAt()="
				+ getUpdateAt() + ", getUpdateBy()=" + getUpdateBy() + ", getCreateAt()=" + getCreateAt()
				+ ", getCreateBy()=" + getCreateBy()  + "] \n";
	}


	
	
	
	
}
