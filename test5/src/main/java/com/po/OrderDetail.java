package com.po;

public class OrderDetail {
	private int id;
    private int orderbasetable_id;
    private int goodstable_id;
    private int shoppingnum;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getOrderbasetable_id() {
		return orderbasetable_id;
	}
	public void setOrderbasetable_id(int orderbasetable_id) {
		this.orderbasetable_id = orderbasetable_id;
	}
	public int getGoodstable_id() {
		return goodstable_id;
	}
	public void setGoodstable_id(int goodstable_id) {
		this.goodstable_id = goodstable_id;
	}
	public int getShoppingnum() {
		return shoppingnum;
	}
	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}
}
