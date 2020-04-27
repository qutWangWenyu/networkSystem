package com.po;

public class CartResult {
	private int id;
	private String gname;
	private String gpicture;
	private double grprice;
	private int shoppingnum;
	private double smallsum;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public String getGpicture() {
		return gpicture;
	}

	public void setGpicture(String gpicture) {
		this.gpicture = gpicture;
	}

	public double getGrprice() {
		return grprice;
	}

	public void setGrprice(double grprice) {
		this.grprice = grprice;
	}

	public int getShoppingnum() {
		return shoppingnum;
	}

	public void setShoppingnum(int shoppingnum) {
		this.shoppingnum = shoppingnum;
	}

	public double getSmallsum() {
		return smallsum;
	}

	public void setSmallsum(double smallsum) {
		this.smallsum = smallsum;
	}

}
