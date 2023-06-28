package com.clothingstore.model;

import java.util.ArrayList;
import java.util.List;

//Class is used to show the items in cart.
public class Cart {
	private List<CartItem> items;
	
	public Cart() {
		items = new ArrayList<>();
	}

	public List<CartItem> getItems() {
		return items;
	}

	public void setItems(List<CartItem> items) {
		this.items = items;
	}
	
}
