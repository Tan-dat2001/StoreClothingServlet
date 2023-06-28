package com.clothingstore.model;

import java.sql.Timestamp;

public class AbstractModel {

	private Timestamp updateAt;
	private String updateBy;
	private Timestamp createAt;
	private String createBy;

	public AbstractModel() {
	}

	public AbstractModel(Timestamp updateAt, String updateBy, Timestamp createAt, String createBy) {
		super();
		this.updateAt = updateAt;
		this.updateBy = updateBy;
		this.createAt = createAt;
		this.createBy = createBy;
	}

	public Timestamp getUpdateAt() {
		return updateAt;
	}

	public void setUpdateAt(Timestamp updateAt) {
		this.updateAt = updateAt;
	}

	public String getUpdateBy() {
		return updateBy;
	}

	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}

	public Timestamp getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Timestamp createAt) {
		this.createAt = createAt;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

}
