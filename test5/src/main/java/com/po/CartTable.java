package com.po;

public class CartTable {
	private int id;
	private int busertable_id;
	private int goodstable_id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getBusertable_id() {
		return busertable_id;
	}
	public void setBusertable_id(int busertable_id) {
		this.busertable_id = busertable_id;
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
	private int shoppingnum;
}
