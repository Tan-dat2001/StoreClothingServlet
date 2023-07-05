package com.clothingstore.model;

import java.util.ArrayList;
import java.util.List;

//Class is used to show the items in cart.
public class Cart {
	private List<Item> items;
	
	public Cart() {
		items = new ArrayList<>();
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	private Item getItemById(int id) { //id chính là id của sản phẩm productId
		for(Item i:items) {
			if(i.getProduct().getProduct_id() == id) {
				return i; // trả về i chính là trả về item có trong giỏ
			}
		}
		return null; // trả về null là k có trong giỏ
	}
	
	public int getQuantityById(int id) {
		return getItemById(id).getQuantity();
	}
		
	// thêm sản phẩm vào giỏ
	public void addItem(Item item) {
		if(getItemById(item.getProduct().getProduct_id()) != null){ //nếu sản phẩm đã có trong giỏ thì chỉ tăng số lượng lên
			Item m = getItemById(item.getProduct().getProduct_id()); // đối tượng ban đầu có trong giỏ hàng
			m.setQuantity(m.getQuantity()+ item.getQuantity()); //set số lượng sản phẩm = số lượng của object ban đầu
																// đã có trong giỏ hàng + số lượng của object vừa thêm vào
		}else {
			items.add(item); // Nếu chưa có thì thêm item/sản phẩm vào giỏ hàng.
		}
	}
	
	// remove sản phẩm khỏi giỏ
	public void removeItem(int id) {
		if(getItemById(id) != null) {
			items.remove(getItemById(id));
		}
	}
	
	// lấy tổng tiền của giỏ hàng
	public float getTotalMoney() {
		float total = 0;
		for(Item i:items) {
			total += (i.getQuantity()*i.getProduct().getProductPrice());
		}
		return total;
	}
}
