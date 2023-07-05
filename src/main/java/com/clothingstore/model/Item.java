package com.clothingstore.model;

// Class is stored the items 
public class Item {
	private Product product;
	private int quantity;
	private float price;
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Item(Product product, int quantity, float price) {
		super();
		this.product = product;
		this.quantity = quantity;
		this.price = price;
	}
	
	
}
