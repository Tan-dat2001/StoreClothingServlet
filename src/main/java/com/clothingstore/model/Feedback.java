package com.clothingstore.model;

import java.sql.Timestamp;

public class Feedback extends AbstractModel {
	private int feedback_id;
	private int account_id;
	private int product_id;
	private String content;
	private int rateStar;
	private String status;
	public Feedback() {

	}
	
	public Feedback(int feedback_id, int account_id, int product_id, String content, int rateStar, String status) {
		this.feedback_id = feedback_id;
		this.account_id = account_id;
		this.product_id = product_id;
		this.content = content;
		this.rateStar = rateStar;
		this.status = status;
	}


	public Feedback(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy, int feedback_id,
			int account_id, int product_id, String content, int rateStar, String status) {
		super(updateAt, updateBy, createAt, createBy);
		this.feedback_id = feedback_id;
		this.account_id = account_id;
		this.product_id = product_id;
		this.content = content;
		this.rateStar = rateStar;
		this.status = status;
	}

	public int getFeedback_id() {
		return feedback_id;
	}
	public void setFeedback_id(int feedback_id) {
		this.feedback_id = feedback_id;
	}
	public int getAccount_id() {
		return account_id;
	}
	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getRateStar() {
		return rateStar;
	}
	public void setRateStar(int rateStar) {
		this.rateStar = rateStar;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
